package com.arquitecturajava.repositories;

import java.util.List;

import com.arquitecturajava.models.Persona;

public interface PersonaRepository {

	List<Persona> buscarTodos();

	void insertar(Persona p);

	void borrar(Persona p);
	
	Persona buscarUno(String nombre);

}