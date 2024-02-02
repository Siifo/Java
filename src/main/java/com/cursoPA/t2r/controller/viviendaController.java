package com.cursoPA.t2r.controller;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursoPA.t2r.entity.Vivienda;
import com.cursoPA.t2r.service.viviendaService;

/**
 * 
 * Gestionamos la peticiones al servidor.
 * nos enfocaremos en guardar los datos de una sola persona 
 * y mostrarlos en una tabla para posteriormente monitorear o modificar estos datos. 
 * 
 */


@Controller
public class viviendaController {
    @Autowired
    private viviendaService ViviendaService;

    //ruta para el formulario

    //captura de datos y vista de los mismos
    
    //editar

    //eliminar

    @GetMapping("/demo")
    public String pruepaPost(){
        return "Hola bitches";
    }

    //registrar
    @GetMapping("/init")
	public String index(ModelMap model) {
        model.addAttribute("vivienda", new Vivienda()); 
		return "registro";
	}
    @PostMapping("/register")
    public String registroVivienda(@ModelAttribute("vivienda")Vivienda vivienda){
        ViviendaService.saveOrUpdate(vivienda);
        System.out.println("Se registro correctamente" + vivienda);
        return "check";
    }
    
    //consultar
    @GetMapping("/consultar")
    public String consultar(){
        return "consultar";
    }
    
    @GetMapping("/consultar/{viviendaId}")
    public String getById(@RequestParam("viviendaId") Long viviendaId, Model model){
        Optional<Vivienda>vivienda=ViviendaService.getVivienda(viviendaId);
        System.out.println("Se cargó correctamente = " + vivienda);
        model.addAttribute("vivienda", vivienda.orElse(null));
        return "mostrar";
    }
    @GetMapping("/mostrar")
    public String cargarMostrar(){
        return "mostrar";
    }
    //editar 
    @RequestMapping("/editar/{viviendaId}")
    public String editar(@PathVariable Long viviendaId, Model model){
        Optional<Vivienda>vivienda=ViviendaService.getVivienda(viviendaId);
        System.out.println("Se cargó correctamente = " + vivienda);
        model.addAttribute("vivienda", vivienda.orElse(null));
        return "registro";
    }

    @PostMapping("/editar/register")
    public String actulizarVivienda(@ModelAttribute("vivienda")Vivienda vivienda){
        ViviendaService.saveOrUpdate(vivienda);
        System.out.println("Se registro correctamente" + vivienda);
        return "check";
    }
   
    //eliminar
    @GetMapping("/eliminar")
	public String deleteCVV() {
		return "eliminar";
	}

    @RequestMapping("/delete/{viviendaId}")
    public String deleteViviendaString(@RequestParam Long viviendaId){
        System.out.println("cargo el id"+viviendaId);
        ViviendaService.delete(viviendaId);
        System.out.println("Se debio eliminar correctamente el hogar con id: " + viviendaId);
        return "consultar";
    }

}
