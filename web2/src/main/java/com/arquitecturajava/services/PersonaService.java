package com.arquitecturajava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquitecturajava.models.Examen;
import com.arquitecturajava.models.Persona;
import com.arquitecturajava.repositories.ExamenRepository;
import com.arquitecturajava.repositories.PersonaRepository;

@Service
public class PersonaService {
	private ExamenRepository repositorioExamen;
	
	private PersonaRepository repositorioPersona;

	public PersonaService(ExamenRepository repositorioExamen, PersonaRepository repositorioPersona) {
		super();
		this.repositorioExamen = repositorioExamen;
		this.repositorioPersona = repositorioPersona;
	}

	public List<Examen> buscarTodosLosExamenes() {
		return repositorioExamen.buscarTodos();
	}

	public List<Examen> buscarTodosLosExamenesPorNombre(String nombre) {
		return repositorioExamen.buscarTodosPorNombre(nombre);
	}

	public void insertarExamen(Examen examen) {
		repositorioExamen.insertar(examen);
	}

	public void borrarExamen(Examen examen) {
		repositorioExamen.borrar(examen);
	}

	public List<Persona> buscarTodasLasPersonas() {
		return repositorioPersona.buscarTodos();
	}

	public void insertarPersona(Persona p) {
		repositorioPersona.insertar(p);
	}

	public void borrarPersona(Persona p) {
		repositorioPersona.borrar(p);
	}

	public Optional<Persona> buscarUnaPersona(String nombre) {
		return repositorioPersona.buscarUno(nombre);
	}
	
	
	
	

}
