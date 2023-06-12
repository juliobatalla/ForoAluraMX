package com.foro.web.servicio;

import java.util.List;  

import com.foro.web.entidad.Respuesta;

public interface RespuestaServicio {

	List<Respuesta> listarTodosLosRespuestas();

	Respuesta guardarRespuesta(Respuesta respuesta);

	Respuesta obtenerRespuestaPorId(Long id);

	void actualizarRespuesta(Object respuestaExistente);

	void eliminarRespuesta(Long id);

	Respuesta actualizarRespuesta(Respuesta respuesta);


	

}
