package com.foro.web.servicio;

import java.util.List;  

import com.foro.web.entidad.Usuario;

public interface UsuarioServicio {
	
    public List<Usuario> listarTodosLosUsuarios();
    
    public Usuario guardarUsuario(Usuario usuario);
    
    public Usuario obtenerUsuarioPorId(Long id);
    
    public Usuario actualizarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Long id);

	
    
}
