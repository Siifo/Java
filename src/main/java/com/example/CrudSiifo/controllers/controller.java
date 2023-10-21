package com.example.CrudSiifo.controllers;

import com.example.CrudSiifo.models.producto;
import com.example.CrudSiifo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    private Repository repo;
    @GetMapping()
    public String index(){
        return "CONECTADO PAPI LINDISIMO";
    }

    @GetMapping("productos")
    public List<producto> getProductos(){

        return repo.findAll();
    }

    @PostMapping("grabar")
    public String save(@RequestBody producto productos){
        repo.save(productos);
        return "Añadido";
    }

    @PutMapping("Editar/{id}")
    public String update(@PathVariable Long id, @RequestBody producto productos){
        producto updateProductos = repo.findById(id).get();
        updateProductos.setNombreProducto(productos.getNombreProducto());
        updateProductos.setPrecioCompra(productos.getPrecioCompra());
        updateProductos.setCantidad(productos.getCantidad());
        updateProductos.setEstado(productos.getEstado());
        repo.save(updateProductos);
        return "Editado Correctamente";
    }

    @DeleteMapping("delete/{id}")
        public String delete(@PathVariable Long id) {
        producto deleteProductos = repo.findById(id).get();
        repo.delete(deleteProductos);
            return "Eliminado";
        }

}
