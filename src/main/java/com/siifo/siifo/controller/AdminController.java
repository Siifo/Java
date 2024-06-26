package com.siifo.siifo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.entity.Proveedor;
import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.repository.UsuarioRepository;
import com.siifo.siifo.service.AuthenticationService;
import com.siifo.siifo.service.ProductoService;
import com.siifo.siifo.service.ProveedorService;
import com.siifo.siifo.service.UsuarioService;



@Controller
public class AdminController {
	//login
	@Autowired
	public AuthenticationService autenticador;

	
	

	@Autowired
	public UsuarioRepository repositoryUsuario;

	//logistica
	@Autowired
	public UsuarioService serviceUsuario;

	//inventario
    @Autowired
    public ProductoService serviceProducto;

	@Autowired
    public ProveedorService serviceProoovedor;

	

    @GetMapping("/admin")
	public String admin(Model model) {
		//logistica
		model.addAttribute("usuario", new Usuario());

		//inventario
        model.addAttribute("producto", new Producto());
		model.addAttribute("proveedor", new Proveedor());


		if(autenticador.isUserAuthenticaded()){
			return "administrador";
			
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

	@GetMapping("/validacionUser")
	public String ingreso(@RequestParam String correoUsuario, @RequestParam String contraseñaUsuario, Model model){

		if (correoUsuario != null && contraseñaUsuario != null ){
			
			Usuario usuario = repositoryUsuario.findByCorreo(correoUsuario, contraseñaUsuario);
			
			if(usuario != null) {
				autenticador.setUserAuth(true);				
				return "redirect:/admin";				
			}
		}
		return "redirect:/login";
	}
	


	//logistica
	@PostMapping("/registerUsuario")
	public String registroUsuarios(@Validated Usuario usuario, Model model){
		serviceUsuario.saveOrUpdate(usuario);
		return "redirect:/admin";
	}


	//Inventario
    @PostMapping("/registerProducto")
	public String registroProducto(@Validated Producto producto,Model model) {
		serviceProducto.saveOrUpdate(producto);
		return "redirect:/admin";
	}

	@PostMapping("/registerProveedor")
	public String registroProveedor(@Validated Proveedor proveedor,Model model) {
		serviceProoovedor.saveOrUpdate(proveedor);
		return "redirect:/admin";
	}


	//deslogueo
	@GetMapping("/salir")
	public String salir(){

		autenticador.setUserAuth(false);
		return "redirect:/";
	}


}
