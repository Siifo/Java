package com.cursoPA.t2r.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.cursoPA.t2r.entity.Usuario;
import com.cursoPA.t2r.entity.Vivienda;
import com.cursoPA.t2r.service.usuarioService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
 * Gestionamos la peticiones al servidor.
 * nos enfocaremos en guardar los datos de una sola persona 
 * y mostrarlos en una tabla para posteriormente modificarlos. 
 * 
 */

@Controller
@RequestMapping(path = "api/user")
public class usuarioController {

    @Autowired
    private usuarioService UsuarioService;

    //ruta para el formulario
    @GetMapping("/index")
    public String homepage(ModelMap model){
        model.addAttribute("usuario", new Usuario()); //enviamos la entidad por defecto a la ruta
        return "index";
    }
    //captura de datos y vista de los mismos
    @PostMapping("/save")
    public String submitData(@ModelAttribute("usuario")Usuario usuario){ //leeemos la entidad a pasar
        UsuarioService.saveOrUpdate(usuario);                            //guardamos en la DB si estan todos los datos
        System.out.println("Se registro correctamente" + usuario);
        return "redirect:/api/user/usersData";                                    //redirigimoas a otra ruta para formular la carga de datos 
    }
    
    @RequestMapping(value = "/usersData", method=RequestMethod.GET)     //recibimos la peticion y enviamos el objeto del mdoelo a la plantilla
    public String getData(ModelMap model) {
        List<Usuario> usuario = UsuarioService.getUsuarioList();
        model.addAttribute("usuario", usuario);
        return "usersData";
    }


    //editar
    @GetMapping("/editUser/{idUsuario}")
    public String editarUsusario(@PathVariable Long idUsuario, Model model){
        Optional<Usuario> usuario = UsuarioService.getUsuario(idUsuario);
        model.addAttribute("usuario", usuario);
        System.out.println("se cargo el objeto: " + usuario);
        return "editUser";
    }

    //eliminar
    
}