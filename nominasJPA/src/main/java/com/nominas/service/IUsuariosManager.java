package com.nominas.service;

import java.util.ArrayList;
import java.util.List;

import com.nominas.domain.Usuario;
import com.nominas.domain.Pelicula;

public interface IUsuariosManager {

	public Usuario iniciarSesion(String usuario, String password);

	public ArrayList<Pelicula> consultaPersonalizada(ArrayList<String> consultas);

	public List<Pelicula> consultaIndividual(String consulta);

	public void darAlta(Usuario usuarioBBDD);
	
	
	
	public void darAltaPelicula(Pelicula usuarioBBDD);


}
