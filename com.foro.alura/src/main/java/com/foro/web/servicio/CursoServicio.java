package com.foro.web.servicio;

import java.util.List;

import com.foro.web.entidad.Curso;

public interface CursoServicio {

	List<Curso> listarTodosLosCurso();

	Curso guardarCurso(Curso curso);

	Curso obtenerCursoPorId(Long id);

	Curso actualizarCurso(Curso cursoExistente);

	void eliminarCurso(Long id);

}
