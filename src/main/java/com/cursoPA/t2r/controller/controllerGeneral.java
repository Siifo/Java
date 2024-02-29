package com.cursoPA.t2r.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoPA.t2r.entity.Empleado;
import com.cursoPA.t2r.repository.empleadoRepository;
import com.cursoPA.t2r.service.empleadoService;

@RestController
@RequestMapping(path = "api/v1")
public class controllerGeneral {
    @Autowired
    private empleadoService EmpleadoService;
    // private viviendaService ViviendaService;

    // @GetMapping
    // public List<Vivienda> getAll(){
    // return ViviendaService.getViviendaList();
    // }

    // @GetMapping("/{viviendaId}")
    // public Optional<Vivienda> getById(@PathVariable("viviendaId") Long
    // viviendaId){
    // return ViviendaService.getVivienda(viviendaId);
    // }

    // @PostMapping
    // public void saveUpdate(@RequestBody Vivienda producto){
    // ViviendaService.saveOrUpdate(producto);
    // }

    // @DeleteMapping("/{viviendaId}")
    // public void delete(@PathVariable("viviendaId") Long viviendaId){
    // ViviendaService.delete(viviendaId);
    // }
    @GetMapping("/login")
    public String getAllUsers(String correo) {
        Empleado empleado = EmpleadoService.findByCorreo("asd@gmail.com", "Bogota");
        System.out.println("a" + empleado);
        return "Exito";
    }
}
