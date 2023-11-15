package com.siifo.siifo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siifo.siifo.service.ProductoService;

// import com.siifo.siifo.model.producto;

import com.siifo.siifo.entity.Producto;

@Controller
public class rutas {

	@Autowired
    private ProductoService productoService;

	//landing site
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
	
	//catagories site
	@RequestMapping("/sonido")
	public String sonido() {
		return "sonido";
	}

	@RequestMapping("/banquetes")
	public String banquetes() {
		return "banquetes";
	}

	@RequestMapping("/recreacion")
	public String recreacion() {
		return "recreacion";
	}

	@RequestMapping("/colegios")
	public String colegios() {
		return "colegios";
	}

	//sub-categories-recreacion
	@RequestMapping("/recreacion/ferias")
	public String ferias() {
		return "ferias";
	} 

	@RequestMapping("/recreacion/decoraciones")
	public String decoraciones() {
		return "decoraciones";
	} 

	@RequestMapping("/recreacion/baby_shower")
	public String babyShower() {
		return "baby_showers";
	}

	@RequestMapping("/recreacion/recreacion_infantil")
	public String recreacion_infantil() {
		return "recreacion_infantil";
	}

	@RequestMapping("/recreacion/minitks")
	public String minitks() {
		return "minitks";
	}

	@RequestMapping("/recreacion/refrigerios")
	public String refrigerios() {
		return "refrigerios";
	}

	@RequestMapping("/recreacion/talleres_ludicos")
	public String talleresLudicos() {
		return "talleres_ludicos";
	}

	@RequestMapping("/recreacion/saltarines")
	public String saltarines() {
		return "saltarines";
	}

	//sub-categories-colegios
	@RequestMapping("/colegios/chaquetas_prom")
	public String chaquetasProm() {
		return "chaquetas_prom";
	}

	@RequestMapping("/colegios/jean_day")
	public String jeanDay() {
		return "jean_day";
	}

	@RequestMapping("/colegios/dia_del_nino")
	public String diaDelNino() {
		return "dia_del_nino";
	}

	@RequestMapping("/colegios/fiestas_prom")
	public String fiestas_prom() {
		return "fiestas_prom";
	}

	
	//rol site
	@RequestMapping("/admin")
	public String admin(ModelMap model) {
		model.addAttribute("producto", new Producto());   
		return "administrador";										 
	}																  												
	
	@PostMapping("/register")
	public String registroProducto(@ModelAttribute("producto") Producto producto) {
		productoService.saveOrUpdate(producto);
		System.out.println("Supon que: " + producto);
		return "index";
	}
}
