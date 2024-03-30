package com.siifo.siifo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.entity.Proveedor;
import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.service.ProductoService;
import com.siifo.siifo.service.ProveedorService;
import com.siifo.siifo.service.UsuarioService;



@Controller
public class AdminController {
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


		return "administrador";
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
}
