package com.nominas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nominas.domain.Usuario;
import com.nominas.domain.Pelicula;
/**
 * Hace uso del entityManager con una configuracion previa en el servlet.xml y en el persistence.xml
 * @author rafa_
 */
@Component
@Repository(value = "usuarioDao")
public class JPAUsuarioDao implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Pelicula> getListaEmpleados() {
		return em.createQuery("from Pelicula").getResultList();
	}
	
	@Transactional(readOnly = true)
	public Usuario findUser(String user,String password) {
		Usuario user1 = (Usuario) em.createQuery("from Usuario where nombre='"+user+"' and password='"+password+"'").getSingleResult();		
		
		System.out.println(user1.getNombre());
		
		return user1;
	}
	

	@Transactional(readOnly = false)
	public void saveProduct(Usuario empl) {
		em.merge(empl);
	}


	@Transactional(readOnly = true)
	public List<Pelicula> consultaDirectos(String director) {
		List<Pelicula> peliculas = em.createQuery("from Pelicula where director='"+director+"'").getResultList();
		return peliculas;
	}


	@Transactional(readOnly = true)
	public ArrayList<Pelicula> consultaPersonalizada(String consultaPersonalizada) {
		return  (ArrayList<Pelicula>) em.createQuery("from Pelicula").getResultList();
	}


	@Transactional(readOnly = false)
	public void darAltaUsuario(Usuario usuarioBBDD) {
		em.persist(usuarioBBDD);		
	}
	
	@Transactional(readOnly = false)
	public void darAltaPelicula(Pelicula peliculaBBDD) {
		em.persist(peliculaBBDD);		
	}





}
