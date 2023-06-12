package com.foro.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 50, unique = true)
	private String nombre;

	@Column(name = "categoria", nullable = false, length = 50)
	private String categoria;

	public Curso() {

	}

	public Curso(String nombre, String categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "]";
	}
	
	
}
