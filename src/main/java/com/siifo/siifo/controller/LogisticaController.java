package com.siifo.siifo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.service.EmpleadoService;

@Controller
public class LogisticaController {
    @Autowired
    EmpleadoService serviceEmpleado;

    
    public String admin(Model model){
        model.addAttribute("empleado", new Usuario());

        return "administrador";
    }
    
    @PostMapping("/registerEmpleado")
    public String registroEmpleado(@Validated Usuario empleado, Model model){
        serviceEmpleado.saveOrUpdate(empleado);

        return "redirect:/admin";
    }
    

}
