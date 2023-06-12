package com.foro.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foro.web.entidad.Curso;
import com.foro.web.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio{
	
	@Autowired
	private CursoRepositorio cursoRepositorio;

	@Override
	public List<Curso> listarTodosLosCurso() {

		return cursoRepositorio.findAll();
	}

	@Override
	public Curso guardarCurso(Curso curso) {
		return cursoRepositorio.save(curso);
	}

	@Override
	public Curso obtenerCursoPorId(Long id) {

		return cursoRepositorio.findById(id).get();
	}
	
	@Override
	public Curso actualizarCurso(Curso curso) {
		
		return cursoRepositorio.save(curso);
	}


	@Override
	public void eliminarCurso(Long id) {
		// TODO Auto-generated method stub
		cursoRepositorio.deleteById(id);
	}

}
