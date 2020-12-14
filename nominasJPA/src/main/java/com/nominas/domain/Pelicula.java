package com.nominas.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * Es la entidad de la tabla nominas. Los atributos forman las columnas con un id que actua como primary key
 * GeneratedValue está comentado ya que es la clave foránea que comparte con la tabla empleados, por lo que no se genera al crear un objeto
 * Contiene la funcion que calcula los sueldos de los empleados
 * @author rafa_
 *
 */


@Component
@Entity
@Table(name="pelicula")
public class Pelicula {
	
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "director")
    private String director;
    
    @Column(name = "fecha")
    private String fecha;

    

    public Pelicula() {
    }

    public Pelicula(int id, String titulo, String director, String fecha) {
    	this.id=id;
    	this.titulo=titulo;
    	this.director=director;
    	this.fecha=fecha;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



}
