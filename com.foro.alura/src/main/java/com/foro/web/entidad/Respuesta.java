package com.foro.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mensaje", nullable = false, length = 50)
	private String mensaje;

	@Column(name = "topico", nullable = false, length = 50)
	private String topico;

	@Column(name = "fechaCreacion", nullable = false, length = 50)
	private String fechaCreacion;

	@Column(name = "autor", nullable = false, length = 50)
	private String autor;

	@Column(name = "solucion", nullable = false, length = 50)
	private String solucion;

	public Respuesta() {

	}

	public Respuesta(String mensaje, String topico, String fechaCreacion, String autor, String solucion) {
		this.mensaje = mensaje;
		this.topico = topico;
		this.fechaCreacion = fechaCreacion;
		this.autor = autor;
		this.solucion = solucion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", mensaje=" + mensaje + ", topico=" + topico + ", fechaCreacion="
				+ fechaCreacion + ", autor=" + autor + ", solucion=" + solucion + "]";
	}


}	
