package com.foro.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foro.web.entidad.Respuesta;

@Repository
public interface RespuestaRepositorio extends JpaRepository<Respuesta, Long> {



}
