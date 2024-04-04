package com.siifo.siifo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.service.ProductoService;

@RestController
@RequestMapping(path = "/siifo/inventario")
public class InventarioRestController {
    
    @Autowired
    ProductoService serviceProducto;
    //consutla de producto
    @GetMapping("/producto/{idProductos}")
    public Optional getProdcutoById(@PathVariable Long idProductos){
        Optional<Producto> producto= serviceProducto.getProducto(idProductos);
        return producto;
    }
}
