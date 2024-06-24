package com.siifo.siifo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;


import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.entity.Provedor;
import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.repository.UsuarioRepository;
import com.siifo.siifo.service.AuthenticationService;
import com.siifo.siifo.service.ProductoService;
import com.siifo.siifo.service.ProveedorService;
import com.siifo.siifo.service.UsuarioService;


@Controller
public class CoordinadorController {
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

	

    @GetMapping("/coor")
	public String admin(Model model) {
		//logistica
		model.addAttribute("usuario", new Usuario());

		//inventario
        model.addAttribute("producto", new Producto());
		model.addAttribute("proveedor", new Provedor());


		if(autenticador.isUserAuthenticadedCoor()){
			autenticador.setUserAuth(false);
			return "coordinador";
			
		} else {
			return "redirect:/";
		}

		
	}


	


	//logistica
	//@PostMapping("/registerUsuario")
	// public String registroUsuarios(@Validated Usuario usuario, Model model){
	// 	serviceUsuario.saveOrUpdate(usuario);
	// 	return "redirect:/admin";
	// }


	// //Inventario
    // @PostMapping("/registerProducto")
	// public String registroProducto(@Validated Producto producto,Model model) {
	// 	serviceProducto.saveOrUpdate(producto);
	// 	return "redirect:/admin";
	// }

	// @PostMapping("/registerProveedor")
	// public String registroProveedor(@Validated Proveedor proveedor,Model model) {
	// 	serviceProoovedor.saveOrUpdate(proveedor);
	// 	return "redirect:/admin";
	// }


	// //deslogueo
	@GetMapping("/salirCoor")
	public String salir(){

		autenticador.setUserAuthCoor(false);
		return "redirect:/";
	}
}
