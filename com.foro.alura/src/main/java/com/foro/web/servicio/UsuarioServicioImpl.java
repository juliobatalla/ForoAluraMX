package com.foro.web.servicio;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foro.web.entidad.Usuario;
import com.foro.web.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {

		return usuarioRepositorio.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {

		return usuarioRepositorio.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepositorio.deleteById(id);

	}

}
