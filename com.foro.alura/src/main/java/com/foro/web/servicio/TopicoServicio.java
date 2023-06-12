package com.foro.web.servicio;

import java.util.List; 

import com.foro.web.entidad.Topico;

public interface TopicoServicio {

	List<Topico> listarTodosLosTopicos();

	Topico guardarTopico(Topico topico);

	Topico obtenerTopicoPorId(Long id);

	Topico actualizarTopico(Topico topicoExistente);

	void eliminarTopico(Long id);






}
