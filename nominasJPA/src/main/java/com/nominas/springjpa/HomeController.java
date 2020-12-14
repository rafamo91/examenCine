package com.nominas.springjpa;

import java.awt.List;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Locale;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nominas.domain.Pelicula;
import com.nominas.domain.Usuario;
import com.nominas.service.IUsuariosManager;

/**
 * Es el controlador principal a través de Spring
 */
@Controller
public class HomeController {
	
	private HttpSession misession;

	@Autowired
	private IUsuariosManager userManager;

	/**
	 * Redirige segun el nombre del proyecto, en este caso al home o pantalla principal
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	/**
	 * Vuelve a la pantalla principal
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "home")
	public ModelAndView homeRedirect(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		return new ModelAndView("home");
	}
	
	/**
	 * Redirige a la pantalla de busquedas por directores
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "buscar")
	public ModelAndView buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("titulo", "Buscar director");
		return new ModelAndView("pages/buscarDirector");
	}
	
	/**
	 * Resetea las peliculas y usuarios activos de la sesión.
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "salir")
	public ModelAndView salir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.getSession().setAttribute("arrayPeliculas", null);
		request.getSession().setAttribute("usuarioActivo", null);
		return new ModelAndView("home");
	}
	
	
	/**
	 * Realiza la consulta de directores a traves de una sesión y 
	 * añade solo cuando los directores no son duplicados
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "mostrar")
	public ModelAndView mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ArrayList<String> directores;
		if (request.getSession().getAttribute("arrayPeliculas") != null) {
			directores = (ArrayList<String>) request.getSession().getAttribute("arrayPeliculas");
		} else {
			directores = new ArrayList<>();
		}
		String consulta = (String) request.getParameter("consulta");
		if(!directores.contains(consulta)) {
			directores.add(consulta);
		}
		
		request.setAttribute("titulo", "Pantalla Final");
		
		ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) userManager.consultaIndividual(consulta);
		request.getSession().setAttribute("arrayPeliculas", directores);
		request.setAttribute("peliculas", peliculas);
		return new ModelAndView("pages/mostrarPeliculas");
	}
	
	/**
	 * Redirige a la pantalla login
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("titulo", "Login");
		return new ModelAndView("pages/login");
	}
	
	/**
	 * Redirige a la pantalla principal reseteando el usuario activo de la sesión y 
	 * la busqueda de directores.
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "salirSesion")
	private ModelAndView salirSesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (misession != null) {
			misession.setAttribute("usuarioActivo", null);
		}
		misession = request.getSession(false);
		request.getSession().setAttribute("arrayPeliculas", null);
		return new ModelAndView("home");

	}
	
	/**
	 * Comprueba el inicio de sesión a través del entity manager con modelo mvc
	 * SI el usuario es nulo va a la pantalla de login mostrando un mensaje de que no existe el usuario
	 * Si el usuario existe lo otorga a la sesión y lo lleva a la pantalla principal
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "iniciarSesion")
	public ModelAndView iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String usuario = (String) request.getParameter("usuario");
		String password = (String) request.getParameter("password");
		Usuario usuarioObj = userManager.iniciarSesion(usuario, password);
		String usuario1 = null;
		if (usuarioObj != null) {
			misession = request.getSession(true);
			usuario1 = usuarioObj.getNombre();
			misession.setAttribute("usuarioActivo", usuario1);
			request.getSession().setAttribute("arrayPeliculas", null);
			return new ModelAndView("home");
			
		} else {
			misession = request.getSession(false);
			misession.removeAttribute(usuario1);
			misession.setAttribute("noExiste", "No existe el usuario");
			request.getSession().setAttribute("arrayPeliculas", null);
			return new ModelAndView("pages/login");
		}
	}
	/**
	 * Redirige a la pantalla de informacion
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "info")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("titulo", "Información");
		return new ModelAndView("pages/info");
	}
	
	/**
	 * Finaliza la sesion y la busqueda.
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "finalizar")
	public ModelAndView finalizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ArrayList<String> directores;
		if (request.getSession().getAttribute("arrayPeliculas") != null) {
			directores = (ArrayList<String>) request.getSession().getAttribute("arrayPeliculas");
		} else {
			directores = new ArrayList<>();
		}
		request.setAttribute("directores", directores);
		request.setAttribute("titulo", "Pantalla Final");
		return new ModelAndView("pages/finalizar");
	}
	/**
	 * Redirige a la pantalla de dar alta a usuarios y peliculas
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "darAlta")
	public ModelAndView modificarPelicula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("titulo", "Dar de alta");
		return new ModelAndView("pages/darAlta");
	}
	/**
	 * Redirige a la pantalla de dar de alta a usuarios
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "altaUsuario")
	public ModelAndView altaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("titulo", "Dar de alta");
		return new ModelAndView("pages/altaUsuario");
	}
	/**
	 * Da de alta a usuarios a traves de em
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "altaUserBBDD")
	public ModelAndView altaBBDD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Usuario usuarioBBDD = new Usuario(Integer.parseInt(request.getParameter("consultaId")), 
				request.getParameter("consultaNombre"),
				request.getParameter("consultaPassword"));
		request.setAttribute("titulo", "Dar de alta");
		userManager.darAlta(usuarioBBDD);
		return new ModelAndView("pages/altaUsuario");
	}
	/**
	 * Redirige a la pantalla pelicula
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "altaPelicula")
	public ModelAndView altaPelicula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("titulo", "Dar de alta");
		return new ModelAndView("pages/altaPelicula");
	}
	
	/**
	 * Crea un nuevo objeto en la base de datos 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "altaPeliculaBBDD")
	public ModelAndView altaPeliculaBBDD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		Pelicula peliculaBBDD = new Pelicula(
				Integer.parseInt( request.getParameter("consultaId")), 
				request.getParameter("consultaTitulo"), 
				request.getParameter("consultaDirector"), 
				request.getParameter("consultaFecha"));
		
		userManager.darAltaPelicula(peliculaBBDD);
		return new ModelAndView("pages/altaPelicula");
	}
	

	


	

}
