package com.foro.web.controlador;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foro.web.entidad.Curso;
import com.foro.web.servicio.CursoServicio;


@Controller
public class CursoControlador {
	
    @Autowired
    private CursoServicio servicio;

    @GetMapping("/cursos")
    public String listarCurso(Model modelo, @RequestParam(value = "error", required = false) String error) {
        List<Curso> cursos = servicio.listarTodosLosCurso();
        modelo.addAttribute("cursos", cursos);
        if (error != null) {
            modelo.addAttribute("error", true);
        }
        return "cursos";
    }

    @GetMapping("/cursos/nuevo")
    public String mostrarFormularioRegistroCurso(Model modelo) {
    	Curso curso = new Curso();
        modelo.addAttribute("curso", curso);
        return "crear_curso";
    }

    @PostMapping("/cursos")
    public String guardarCurso(@ModelAttribute("curso") Curso curso, Model modelo) {
        try {
            servicio.guardarCurso(curso);
        } catch (Exception e) {
            return "redirect:/curso?error=true";
        }
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("curso", servicio.obtenerCursoPorId(id));
        return "editar_curso";
    }

    @PostMapping("/cursos/{id}")
    public String actualizarCurso(@PathVariable Long id, @ModelAttribute("curso") Curso curso, Model modelo) {
    	Curso cursoExistente = servicio.obtenerCursoPorId(id);
    	cursoExistente.setId(id);
    	cursoExistente.setNombre(curso.getNombre());
    	cursoExistente.setCategoria(curso.getCategoria());

        servicio.actualizarCurso(cursoExistente);
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        servicio.eliminarCurso(id);
        return "redirect:/cursos";
    }


}
