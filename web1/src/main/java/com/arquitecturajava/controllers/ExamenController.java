package com.arquitecturajava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arquitecturajava.models.Examen;
import com.arquitecturajava.models.Persona;
import com.arquitecturajava.services.PersonaService;

@Controller
@RequestMapping("/examenes") // anotación q nos permite ubicar todas las acciones en la url "/personas"
public class ExamenController {

	private PersonaService personaService;

	public ExamenController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	// devuelvo un string para ir a un html a montar la lista
	@GetMapping("/lista")
	public String lista(Model modelo) {
		modelo.addAttribute("lista", personaService.buscarTodosLosExamenes());
		return "listaexamen";
	}

	// formulario
	@GetMapping
	public String formulario() {
		return "formularioexamenes";
	}

	// insertar
	@PostMapping("/insertar")
	public String insertar(Model modelo, Examen examen, String nombrePersona) {

		System.out.println(nombrePersona);
		Persona persona = personaService.buscarUnaPersona(nombrePersona);
		examen.setPersona(persona);

		personaService.insertarExamen(examen);
		modelo.addAttribute("lista", personaService.buscarTodosLosExamenes());
		return "listaexamenes";
	}

	@RequestMapping("/borrar")
	public String borrar(Model modelo, @RequestParam int id) {
		personaService.borrarExamen(new Examen(id));
		modelo.addAttribute("lista", personaService.buscarTodosLosExamenes());
		return "listaexamenes";
	}

}
