package com.nominas.domain;

import javax.persistence.*;


/**
 * Es una entidad de la tabla de la base de datos. Hace referencia a la tabla empleado y contiene un control de excepciones para actualizar
 * De forma correcta los datos del empleado
 * Contiene una sobrecarga para que el xml pueda crear la entidad correctamente.
 * 
 * Los atributos tienen un id primary key y el resto de columnas
 * @author rafa_
 *
 */

@Entity
@Table(name="usuario")
public class Usuario {
	
	
	public Usuario() {
		
	}

	public Usuario(int id, String nombre, String password) {
		this.id=id;
		this.nombre=nombre;
		this.password=password;
	}
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="password")
	private String password;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	

	

	
	
	
}
