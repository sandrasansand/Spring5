package com.arquitecturajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arquitecturajava.models.Persona;
import com.arquitecturajava.services.PersonaService;

@Controller
@RequestMapping(path = "/personas") // anotación q nos permite ubicar todas las acciones en la url "/personas"
public class PersonaController {

	private PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	// devuelvo un string para ir a un html a montar la lista
	@GetMapping("/lista")
	public String lista(Model modelo) {
		modelo.addAttribute("lista", personaService.buscarTodasLasPersonas());
		return "lista";
	}

	// devuelvo un string para ir a un html a montar la lista
	@GetMapping("/examenes")
	public String examenes(Model modelo, String nombre) {
		modelo.addAttribute("lista", personaService.buscarTodosLosExamenesPorNombre(nombre));
		return "listaexamenes";
	}

	// formulario
	@GetMapping
	public String formulario() {
		return "formulario";
	}

	// insertar
	@PostMapping("/insertar")
	public String insertar(Model modelo, Persona persona) {
		// lista.add(persona);
		personaService.insertarPersona(persona);
		modelo.addAttribute("lista", personaService.buscarTodasLasPersonas());
		return "lista";
	}

	@RequestMapping("/borrar")
	public String borrar(Model modelo, @RequestParam String nombre) {
		// eliminamos por nombre como si fuera una PK un id, un nif etc.
		// lista.remove(new Persona(nombre));
		personaService.borrarPersona(new Persona(nombre));
		modelo.addAttribute("lista", personaService.buscarTodasLasPersonas());
		return "lista";
	}

}
