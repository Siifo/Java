package com.siifo.siifo.controller;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.siifo.siifo.model.producto;

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
	
	//rol site
	@RequestMapping("/admin")
	public String admin() {
		return "administrador";
	}
	
	@PostMapping("/register")
	public String registroProducto(@ModelAttribute producto Producto) {
		System.out.println(Producto.toString());
		return "index";
	}
}
