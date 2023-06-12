package com.foro.web.entidad;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @Column(name = "titulo", nullable = false, length = 50, unique = true)
    private String titulo;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "autor", nullable = false, length = 50)
    private String autor;

    @Column(name = "curso", nullable = false, length = 50)
    private String curso;

    @Column(name = "respuesta", nullable = false, length = 50)
    private String respuesta;

    public Topico() {

    }

    public Topico(String nombre, String titulo, LocalDate fechaCreacion, String status, String autor,
                  String curso, String respuesta) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respuesta = respuesta;
    }

    // Getters y setters

    // ...

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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
    public String toString() {
        return "Topico [id=" + id + ", nombre=" + nombre + ", titulo=" + titulo + ", fecha_creacion=" + fechaCreacion
                + ", status=" + status + ", autor=" + autor + ", curso=" + curso + ", respuesta=" + respuesta + "]";
    }
}
