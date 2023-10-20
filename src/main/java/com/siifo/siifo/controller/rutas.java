package com.siifo.siifo.controller;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// import com.siifo.siifo.model.producto;

import ch.qos.logback.core.model.Model;

@Controller
public class rutas {

	//landing site
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
	
	//catagories site
	@RequestMapping("/sonido")
	public String sonido() {
		return "sonido";
	}

	@RequestMapping("/banquetes")
	public String banquetes() {
		return "banquetes";
	}

	@RequestMapping("/recreacion")
	public String recreacion() {
		return "recreacion";
	}

	@RequestMapping("/colegios")
	public String colegios() {
		return "colegios";
	}

	//sub-categories-recreacion
	@RequestMapping("/recreacion/ferias")
	public String ferias() {
		return "ferias";
	} 

	@RequestMapping("/recreacion/decoraciones")
	public String decoraciones() {
		return "decoraciones";
	} 

	@RequestMapping("/recreacion/baby_shower")
	public String babyShower() {
		return "baby_showers";
	}

	@RequestMapping("/recreacion/recreacion_infantil")
	public String recreacion_infantil() {
		return "recreacion_infantil";
	}

	@RequestMapping("/recreacion/minitks")
	public String minitks() {
		return "minitks";
	}

	@RequestMapping("/recreacion/refrigerios")
	public String refrigerios() {
		return "refrigerios";
	}

	@RequestMapping("/recreacion/talleres_ludicos")
	public String talleresLudicos() {
		return "talleres_ludicos";
	}

	@RequestMapping("/recreacion/saltarines")
	public String saltarines() {
		return "saltarines";
	}

	
	//rol site
	@RequestMapping("/admin")
	public String admin() {
		return "administrador";
	}
	
	@PostMapping("/register")
	public String registroProducto(Model model) {
		System.out.println(model.toString());
		return "index";
	}
}
