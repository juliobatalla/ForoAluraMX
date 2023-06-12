package com.foro.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foro.web.entidad.Respuesta;
import com.foro.web.repositorio.RespuestaRepositorio;

@Service
public class RespuestaServicioImpl implements RespuestaServicio{
	
	@Autowired
	private RespuestaRepositorio respuestaRepositorio;

	@Override
	public List<Respuesta> listarTodosLosRespuestas() {
		return respuestaRepositorio.findAll();
	}

	@Override
	public Respuesta guardarRespuesta(Respuesta respuesta) {
		return respuestaRepositorio.save(respuesta);
	}

	@Override
	public Respuesta obtenerRespuestaPorId(Long id) {

		return respuestaRepositorio.findById(id).get();
	}
	
	@Override
	public Respuesta actualizarRespuesta(Respuesta respuesta) {
		return respuestaRepositorio.save(respuesta);
		
	}

	@Override
	public void actualizarRespuesta(Object respuestaExistente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRespuesta(Long id) {
		respuestaRepositorio.deleteById(id);
		
	}
	




}
