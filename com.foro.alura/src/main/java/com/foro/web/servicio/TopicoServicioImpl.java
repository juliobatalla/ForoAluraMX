package com.foro.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foro.web.entidad.Topico;
import com.foro.web.repositorio.TopicoRepositorio;

@Service
public class TopicoServicioImpl implements TopicoServicio {
	
	@Autowired
	private TopicoRepositorio topicoRepositorio;

	@Override
	public List<Topico> listarTodosLosTopicos() {
		return topicoRepositorio.findAll();
	}

	@Override
	public Topico guardarTopico(Topico topico) {
		return topicoRepositorio.save(topico);
	}

	@Override
	public Topico obtenerTopicoPorId(Long id) {

		return topicoRepositorio.findById(id).get();
	}

	@Override
	public Topico actualizarTopico(Topico topico) {

		return topicoRepositorio.save(topico);
	}

	@Override
	public void eliminarTopico(Long id) {
		topicoRepositorio.deleteById(id);

	}

}
