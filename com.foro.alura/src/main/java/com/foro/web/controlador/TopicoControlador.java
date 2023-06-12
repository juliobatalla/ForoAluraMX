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

import com.foro.web.entidad.Topico;
import com.foro.web.servicio.TopicoServicio;


@Controller
public class TopicoControlador {

    @Autowired
    private TopicoServicio servicio;

    @GetMapping("/topicos")
    public String listarUsuarios(Model modelo, @RequestParam(value = "error", required = false) String error) {
        List<Topico> topicos = servicio.listarTodosLosTopicos();
        modelo.addAttribute("topicos", topicos);
        if (error != null) {
            modelo.addAttribute("error", true);
        }
        return "topicos";
    }

    @GetMapping("/topicos/nuevo")
    public String mostrarFormularioRegistroTopico(Model modelo) {
    	Topico topico = new Topico();
        modelo.addAttribute("topico", topico);
        return "crear_topico";
    }

    @PostMapping("/topicos")
    public String guardarTopico(@ModelAttribute("topico") Topico topico, Model modelo) {
        try {
            servicio.guardarTopico(topico);
        } catch (Exception e) {
            return "redirect:/topicos?error=true";
        }
        return "redirect:/topicos";
    }

    @GetMapping("/topicos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("topico", servicio.obtenerTopicoPorId(id));
        return "editar_topico";
    }

    @PostMapping("/topicos/{id}")
    public String actualizarTopico(@PathVariable Long id, @ModelAttribute("topico") Topico topico, Model modelo) {
    	Topico topicoExistente = servicio.obtenerTopicoPorId(id);
        topicoExistente.setId(id);
        topicoExistente.setNombre(topico.getNombre());
        topicoExistente.setTitulo(topico.getTitulo());
        topicoExistente.setFechaCreacion(topico.getFechaCreacion());
        topicoExistente.setStatus(topico.getStatus());
        topicoExistente.setAutor(topico.getAutor());
        topicoExistente.setCurso(topico.getCurso());
        topicoExistente.setRespuesta(topico.getRespuesta());

        servicio.actualizarTopico(topicoExistente);
        return "redirect:/topicos";
    }

    @GetMapping("/topicos/{id}")
    public String eliminarTopicos(@PathVariable Long id) {
        servicio.eliminarTopico(id);
        return "redirect:/topicos";
    }
    

}