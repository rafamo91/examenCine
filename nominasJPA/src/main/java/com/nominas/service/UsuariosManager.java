package com.nominas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.nominas.domain.Usuario;
import com.nominas.domain.Pelicula;
import com.nominas.repository.UsuarioDao;


/**
 * Esta clase es la encargada de manipular las diferentes funciones de la base de datos a traves de JPAEmpleadoDao. Separandolo con el modelo
 * mvc podemos usar varias funciones de JPAEmpleadosDao desde aquí.
 * También manipula las consultas personalizadas para que el usuario pueda buscar en la bbdd a traves de combinaciones de parámetros.
 * @author rafa_
 *
 */
@Component
public class UsuariosManager implements IUsuariosManager{
	
	@Autowired
	public UsuarioDao usuarioDao;
	
	
	/**
	 * Inicia sesion a traves del dao
	 */
	@Override
	public Usuario iniciarSesion(String usuario, String password) {
		return usuarioDao.findUser(usuario, password);
	}


	@Override
	public List<Pelicula> consultaIndividual(String consulta) {
		return usuarioDao.consultaDirectos(consulta);
	}

	@Override
	public void darAlta(Usuario usuarioBBDD) {
		usuarioDao.darAltaUsuario(usuarioBBDD);
	}

	@Override
	public void darAltaPelicula(Pelicula peliculaBBDD) {
		usuarioDao.darAltaPelicula(peliculaBBDD);
		
	}
	
	@Override
	public ArrayList<Pelicula> consultaPersonalizada(ArrayList<String> consultas) {
		ArrayList<Pelicula> peliculas = null;
		String consultaPersonalizada = "";
		String consultaReparada = "";
		String[] parametros = { "titulo='", "director='","fecha='"};
		

		for (int i = 0; i < consultas.size(); i++) {
			switch (consultas.get(i)) {
			case "": {
				break;
			}
			default:
				consultaReparada = comprobarParametros(consultas, i, parametros[i]);
				consultas.set(i, consultaReparada);
			}
		}

		for (String consulta : consultas) {
			consultaPersonalizada = consultaPersonalizada + consulta;
		}
		
		peliculas = usuarioDao.consultaPersonalizada(consultaPersonalizada);


		return peliculas;
	}
	
	



	 
	private String comprobarParametros(ArrayList<String> consultas, int i, String parametro) {
		String consultaCustom = "";
		boolean comprobar;
		comprobar = false;
		for (int index = i; index < consultas.size() - 1; index++) {
			if (consultas.get(index + 1) != "") {
				consultaCustom = parametro + consultas.get(i) + "' and ";
				comprobar = true;
			}
		}
		if (comprobar == false) {
			consultaCustom = parametro + consultas.get(i) + "'";
		}
		return consultaCustom;
	}




}
