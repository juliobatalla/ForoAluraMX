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

import com.foro.web.entidad.Usuario;
import com.foro.web.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model modelo, @RequestParam(value = "error", required = false) String error) {
        List<Usuario> usuarios = servicio.listarTodosLosUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        if (error != null) {
            modelo.addAttribute("error", true);
        }
        return "usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioRegistroUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "crear_usuario";
    }

    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        try {
            servicio.guardarUsuario(usuario);
        } catch (Exception e) {
            return "redirect:/usuarios?error=true";
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
        return "editar_usuario";
    }

    @PostMapping("/usuarios/{id}")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario, Model modelo) {
        Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);
        usuarioExistente.setId(id);
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setContrasena(usuario.getContrasena());

        servicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}")
    public String eliminarUsuarios(@PathVariable Long id) {
        servicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
    
}
