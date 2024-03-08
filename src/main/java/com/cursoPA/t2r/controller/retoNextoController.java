package com.cursoPA.t2r.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.cursoPA.t2r.entity.Departamento;
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
    // departamento
    @Autowired
    private departamentoService DepartamentoService;
    // Empleado
    @Autowired
    private empleadoService EmpleadoService;

    // hompage
    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    // rutas del departamento
    @GetMapping("/departamento")
    public String index() {
        return "indexDepartamento";
    }

    // rutas del empleado
    @GetMapping("/empleado")
    public String indexEmpleado(ModelMap model) {
        model.addAttribute("empleado", new Empleado());
        List<Departamento> departamento = DepartamentoService.getDepaList();
        System.out.println("a ver" + departamento);
        model.addAttribute("departamento", departamento);
        return "indexEmpleado";
    }

    // registrar datos en empleado
    @PostMapping("/registroEmpleado")
    public String registroEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        EmpleadoService.saveOrUpdate(empleado); // guardamos en la DB si estan todos los datos
        System.out.println("Se registro correctamente" + empleado);
        return "redirect:/consultarEmpleado";
    }
                
    // redireccion para cargar los datos insertados
    @RequestMapping(value = "/consultarEmpleado", method = RequestMethod.GET)
    public String consultarEmpleado(ModelMap model) {
        List<Empleado> empleado = EmpleadoService.getEmpleadoList();
        model.addAttribute("empleado", empleado);
        return "consultaEmple";
    }

    // editar datos
    @GetMapping("/editEmpleado/{idEmpleado}")
    public String editarEmpleado(@PathVariable Long idEmpleado, ModelMap model) {
        // le pasamos el objeto a editar(para que sepa donde guardarlo)
        model.addAttribute("empleado", new Empleado()); // enviamos la entidad por defecto a la ruta
        Optional<Empleado> empleado = EmpleadoService.getEmpleado(idEmpleado);
        model.addAttribute("empleado", empleado.orElse(null));
        //cargamos los datos del entity de departamento
        List<Departamento> departamento = DepartamentoService.getDepaList();
        model.addAttribute("departamento",departamento);
        //salidas
        System.out.println("se cargo el objeto: " + empleado);
        return "editEmpleado";
    }

    // guardar cambios
    @PostMapping("/editEmpleado/cambios")
    public String postMethodEdit(@ModelAttribute("empleado") Empleado empleado) { // identificamos la entidad del objeto
                                                                                  // al actualizar
        EmpleadoService.saveOrUpdate(empleado); // guardamos en la DB si estan todos los datos
        System.out.println("Se actualizo correctamente" + empleado.getIdEmpleado().toString());
        return "redirect:/consultarEmpleado";
    }

    // delete empleado
    @RequestMapping("/deleteEmpleado/{idEmpleado}")
    public String deleteUser(@PathVariable Long idEmpleado, ModelMap model) {
        EmpleadoService.delete(idEmpleado);
        System.out.println("se elimino el id: " + idEmpleado);
        return "redirect:/consultarEmpleado";
        
    }

    //async
    @GetMapping("/consultaAsync")
    public String nuevaConsulta(ModelMap model){
        model.addAttribute("empleado", new Empleado());
        return "consultaAsync";
    }

    @GetMapping("/DempleadoD")
    public String cargarConsulta(@RequestParam Long idEmpleado, ModelMap model){
        CompletableFuture<Empleado> empleado = EmpleadoService.getEmpleadoByIdAsync(idEmpleado);//el objeto esperara a que se complete la acion para rellenar el objeto
        if(empleado!=null && idEmpleado!=0){
            Empleado empleadoC = empleado.join();// esperamos a que se llene
            model.addAttribute("empleadoC", empleadoC);
            return "consultaAsync";
        }else{
            return "redirect:/";
        }
        //System.out.println(""+empleadoC); //error al tratar de mostrar un objeto sin esperar a quese complete
        
    }
}
