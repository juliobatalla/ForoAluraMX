package com.foro.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foro.web.entidad.Curso;


@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long>{

}
