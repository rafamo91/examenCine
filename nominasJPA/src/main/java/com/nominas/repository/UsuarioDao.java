package com.nominas.repository;


import java.util.ArrayList;
import java.util.List;

import com.nominas.domain.Usuario;
import com.nominas.domain.Pelicula;

public interface UsuarioDao {
	
	public Usuario findUser(String user,String password);
	public List<Pelicula> consultaDirectos(String director);
	public ArrayList<Pelicula> consultaPersonalizada(String consultaPersonalizada);
	public void darAltaUsuario(Usuario usuarioBBDD);
	public void darAltaPelicula(Pelicula peliculaBBDD);

}
