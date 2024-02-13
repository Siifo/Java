package com.siifo.siifo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siifo.siifo.model.Credenciales;


@Controller
public class LoginController {
    @GetMapping("/")
    public String redirectLogin() {
       return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model,@RequestParam(name = "error", defaultValue = "", required = false) String error){
        model.addAttribute("credencial", new Credenciales());
        return "login";
    }

    @PostMapping("/admin")
    public String validarLogin(@ModelAttribute(name = "Credenciales") Credenciales credencial) {
        if (credencial.getCorreo().equals("admin@gmail.com") && credencial.getPass().equals("pass")) {
            return "admin";
        }
        return "redirect:/index";
    }
}
