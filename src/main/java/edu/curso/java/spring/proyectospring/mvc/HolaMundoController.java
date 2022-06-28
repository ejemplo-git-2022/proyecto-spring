package edu.curso.java.spring.proyectospring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/holamundo")
public class HolaMundoController {

	private static  Logger log = LoggerFactory.getLogger(HolaMundoController.class);

	@GetMapping("/saludar")
	public String saludar(Model model) {
		log.info("ejecutando saludar...");
		model.addAttribute("texto", "hola a todos esto es un parametro que mando desde el controller");
		return "holamundo";
	}
	
	@GetMapping("/saludar2/{texto}")
	public String saludar2(Model model, @PathVariable String texto) {
		log.info("ejecutando saludar2...");
		model.addAttribute("texto", texto);
		return "holamundo";
	}
	
	@GetMapping("/saludar3") //    /holamundo/saludar3?texto=maria
	public String saludar3(Model model, @RequestParam String texto) {
		log.info("ejecutando saludar3...");
		model.addAttribute("texto", texto);
		return "holamundo";
	}
	
	
}
