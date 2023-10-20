package com.siifo.siifo.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siifo.siifo.interfaceService.IproductoService;
import com.siifo.siifo.model.producto;

@Controller
@RequestMapping
public class invetarioDashboard {
	
	@Autowired
	private IproductoService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("producto", new producto());
		return "administrador";
	}
	
	@PostMapping("/register")
	public String registroProducto(@Valid producto p, Model model) {
		service.equals(p);
		return "redirect:/administrador";
	}

	
	
}
