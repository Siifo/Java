package com.siifo.siifo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.entity.Proveedor;
import com.siifo.siifo.service.ProductoService;
import com.siifo.siifo.service.ProveedorService;

import jakarta.servlet.http.HttpServletRequest;



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
	//registros
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

	//Consultas
	// el proceso debe hacerse desde el rest controller solo para buscar los datos
	// llenar los campos del formulario y mostrarlo mediante eventos en js
		//async
		//prueba
	// @GetMapping("/buscar/{id}")
	// public Integer cosnultaProAsync(@PathVariable Long id){
	// 	CompletableFuture<Producto> productoA = serviceProducto.getProductoByIdAsync(id);
	// 	while (id!=0) {
	// 		Producto producto = productoA.join();
	// 		System.out.println("debes ver esto: "+producto);
	// 		return 1;
	// 	}
	// 	return 0;
	// }
		//proceso dinamico
	// @GetMapping("/buscar")
	// public String consultaAsyncProd(@RequestParam Long idProductos, Model model){
	// 	CompletableFuture<Producto> producto = serviceProducto.getProductoByIdAsync(idProductos);
	// 	if(idProductos!=0 && producto!=null){
	// 		Producto productoA = producto.join();
	// 		model.addAttribute("productoA", productoA);
	// 		System.out.println("hola hola"+productoA);
	// 		return "administrador";
	// 	}else{
	// 		System.out.println("Comprueba la existencia del id o revisa el proceso del service");
	// 		return "redirect:/";
	// 	}
		
	// }
	 // guardar cambios
    @PostMapping("/editProducto")
    public String productoEdit(@ModelAttribute("producto") Producto producto, Model model) {
		model.addAttribute("producto", new Producto());
        serviceProducto.saveOrUpdate(producto); // guardamos en la DB si estan todos los datos
        System.out.println("Se actualizo correctamente" + producto.getIdProductos().toString());
        return "redirect:/admin";
    }
	// delete empleado
    @RequestMapping("/deleteProducto")
    public String deletePro(HttpServletRequest request, Model model) {
		String id = request.getParameter("idProductos");
		Long idProductos = Long.parseLong(id);
        serviceProducto.delete(idProductos);
        System.out.println("se elimino el id: " + idProductos);
        return "redirect:/admin";
    }

}
