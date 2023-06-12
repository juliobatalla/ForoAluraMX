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

import com.foro.web.entidad.Respuesta;
import com.foro.web.servicio.RespuestaServicio;


@Controller
public class RespuestaControlador {

	
    @Autowired
    private RespuestaServicio servicio;

    @GetMapping("/respuestas")
    public String listarRespuestas(Model modelo, @RequestParam(value = "error", required = false) String error) {
        List<Respuesta> respuestas = servicio.listarTodosLosRespuestas();
        modelo.addAttribute("respuestas", respuestas);
        if (error != null) {
            modelo.addAttribute("error", true);
        }
        return "respuestas";
    }

    @GetMapping("/respuestas/nuevo")
    public String mostrarFormularioRegistroRespuesta(Model modelo) {
    	Respuesta respuesta = new Respuesta();
        modelo.addAttribute("respuesta", respuesta);
        return "crear_respuesta";
    }

    @PostMapping("/respuestas")
    public String guardarRespuesta(@ModelAttribute("respuesta") Respuesta respuesta, Model modelo) {
        try {
            servicio.guardarRespuesta(respuesta);
        } catch (Exception e) {
            return "redirect:/respuesta?error=true";
        }
        return "redirect:/respuestas";
    }

    @GetMapping("/respuestas/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("respuesta", servicio.obtenerRespuestaPorId(id));
        return "editar_respuesta";
    }

    @PostMapping("/respuestas/{id}")
    public String actualizarRespuesta(@PathVariable Long id, @ModelAttribute("respuesta") Respuesta respuesta, Model modelo) {
    	Respuesta respuestaExistente = servicio.obtenerRespuestaPorId(id);
    	respuestaExistente.setId(id);
    	respuestaExistente.setMensaje(respuesta.getMensaje());
    	respuestaExistente.setTopico(respuesta.getTopico());
    	respuestaExistente.setFechaCreacion(respuesta.getFechaCreacion());
    	respuestaExistente.setAutor(respuesta.getAutor());
    	respuestaExistente.setSolucion(respuesta.getSolucion());

        servicio.actualizarRespuesta(respuestaExistente);
        return "redirect:/respuestas";
    }

    @GetMapping("/respuestas/{id}")
    public String eliminarRespuesta(@PathVariable Long id) {
        servicio.eliminarRespuesta(id);
        return "redirect:/respuestas";
    }
	
	
}
