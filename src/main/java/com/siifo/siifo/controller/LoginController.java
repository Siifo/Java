package com.siifo.siifo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.repository.UsuarioRepository;
import com.siifo.siifo.service.AuthenticationService;
import com.siifo.siifo.service.ProductoService;
import com.siifo.siifo.service.ProveedorService;
import com.siifo.siifo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;



@Controller
public class LoginController {
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

    @GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

    @GetMapping("/validacionUser")
	public String ingreso(@RequestParam String correoUsuario, @RequestParam String contraseñaUsuario,  Model model, HttpSession session){

		if (correoUsuario != null && contraseñaUsuario != null ){
			
			Usuario usuario = repositoryUsuario.findByCorreo(correoUsuario, contraseñaUsuario);

			String nombreUsuario = usuario.getNombreUsuario();
			String rolUsuario = usuario.getRol().getNombreRol();

			session.setAttribute("rolUsuario", rolUsuario);
			session.setAttribute("nombreUsuario", nombreUsuario);

			
			if(usuario != null) {
				switch (usuario.getRol().getIdRol()) {
					case 1:
						autenticador.setUserAuth(true);
						return "redirect:/admin";

					case 2:
					autenticador.setUserAuthCoor(true);
					return "redirect:/coor";
					default:
						break;
				}

									
			}
		}
		return "redirect:/login";
	}

}
