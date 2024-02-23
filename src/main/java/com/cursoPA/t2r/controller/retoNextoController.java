package com.cursoPA.t2r.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.cursoPA.t2r.entity.Empleado;
import com.cursoPA.t2r.service.departamentoService;
import com.cursoPA.t2r.service.empleadoService;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 1. hacer entidades, revisar anotaciones(de muchos a uno 'empleados')
 * 2. actualizar la fecha de modificacion (trigers se puede)
 * 
 * 3. mostrar tabla o vista de los datos (con modificaion)
 * 4. 
 */
@Controller
public class retoNextoController {  
    //departamento
    @Autowired
    private departamentoService DepartamentoService;
    //Empleado
    @Autowired
    private empleadoService EmpleadoService;

    //hompage
    @GetMapping("/")
    public String homepage(){
        return "index";
    }

    //rutas del departamento
    @GetMapping("/departamento")
    public String index() {
        return "indexDepa";
    }

    //rutas del empleado
    @GetMapping("/empleado")
    public String indexEmpleado(ModelMap model) {
        model.addAttribute("empleado", new Empleado());
        return "indexEmpleado";
    }
    //registrar datos en empleado
    @PostMapping("/registroEmpleado")
    public String registroEmpleado(@ModelAttribute("empleado")Empleado empleado){
        EmpleadoService.saveOrUpdate(empleado);                            //guardamos en la DB si estan todos los datos
        System.out.println("Se registro correctamente" + empleado);
        return "redirect:/consultarEmpleado"; 
    }
    //redireccion para cargar los datos insertados
    @RequestMapping(value="/consultarEmpleado", method = RequestMethod.GET)
    public String consultarEmpleado(ModelMap model){
        List<Empleado> empleado = EmpleadoService.getEmpleadoList();
        model.addAttribute("empleado", empleado);
        return "consultaEmple";
    }
    //editar datos
    @GetMapping("/editEmpleado/{idEmpleado}")
    public String editarEmpleado(@PathVariable Long idEmpleado, ModelMap model){
        //le pasamos el objeto a editar(para que sepa donde guardarlo)
        model.addAttribute("empleado", new Empleado());    //enviamos la entidad por defecto a la ruta
        Optional<Empleado> empleado = EmpleadoService.getEmpleado(idEmpleado);
        model.addAttribute("empleado", empleado.orElse(null));
        System.out.println("se cargo el objeto: " + empleado);
        return "editEmpleado";
    }

    //guardar cambios
    @PostMapping("/editEmpleado/cambios")
    public String postMethodEdit(@ModelAttribute("empleado")Empleado empleado) {       //identificamos la entidad del objeto al actualizar
        EmpleadoService.saveOrUpdate(empleado);                                       //guardamos en la DB si estan todos los datos
        System.out.println("Se actualizo correctamente" + empleado.getIdEmpleado().toString());
        return "redirect:/consultarEmpleado";
    }

    //delete empleado
    @RequestMapping("/deleteEmpleado/{idEmpleado}")
    public String deleteUser(@PathVariable Long idEmpleado, ModelMap model) {
        EmpleadoService.delete(idEmpleado);
        System.out.println("se elimino el id: " + idEmpleado);
        return "redirect:/consultarEmpleado";
    }
    













    //ruta para el formulario de ususarioController
    @GetMapping("/editUser/{idUsuario}")
    public String enrutar() {
        return "redirect:/api/user/editUser/{idUsuario}";
    }

    @GetMapping("/deleteUser/{idUsuario}")
    public String postMethodName() {
        return "redirect:/api/user/deleteUser/{idUsuario}";
    }
    
    @GetMapping("/nomina")
    public String nomindaReturn() {
        return "redirect:/api/user/nomina";
    }
    


} 