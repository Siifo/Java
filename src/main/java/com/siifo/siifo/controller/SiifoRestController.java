package com.siifo.siifo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siifo.siifo.entity.Detalle_evento;
import com.siifo.siifo.entity.Producto;
import com.siifo.siifo.service.DetalleEventoService;
import com.siifo.siifo.service.ProductoService;

@RestController
@RequestMapping(path = "/siifo")
public class SiifoRestController {
    
    @Autowired
    ProductoService serviceProducto;

    @Autowired
    DetalleEventoService serviceDetalleEvento;

    //consutla de producto
    @GetMapping("/inventario/producto/{idProductos}")
    public Optional getProdcutoById(@PathVariable Long idProductos){
        Optional<Producto> producto= serviceProducto.getProducto(idProductos);
        return producto;
    }
    //consulta detalleEvento
    @GetMapping("/logistica/evento/{idEvento}")
    public Optional getDetalleEventobyId(@PathVariable Long idEvento){
        Optional<Detalle_evento> detalleEvento = serviceDetalleEvento.getDetalleById(idEvento);
        return detalleEvento;
    }


}
