package com.siifo.siifo.controller;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.siifo.siifo.model.producto;

@Controller
public class invetarioDashboard {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
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
