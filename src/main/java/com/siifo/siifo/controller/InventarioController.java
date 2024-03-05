package com.siifo.siifo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.entity.Proveedor;
import com.siifo.siifo.service.ProductoService;
import com.siifo.siifo.service.ProveedorService;



@Controller
public class InventarioController {
    @Autowired
    public ProductoService serviceProducto;

	@Autowired
    public ProveedorService serviceProoovedor;

    @GetMapping("/admin")
	public String admin(Model model) {
        model.addAttribute("producto", new Producto());
		model.addAttribute("proveedor", new Proveedor());

		return "administrador";
	}

    @PostMapping("/register")
	public String registroProducto(@Validated Producto producto,Model model) {
		serviceProducto.saveOrUpdate(producto);
		return "redirect:/admin";
	}

	@PostMapping("/save")
	public String registroProveedor(@Validated Proveedor proveedor,Model model) {
		serviceProoovedor.saveOrUpdate(proveedor);
		return "redirect:/admin";
	}
}
