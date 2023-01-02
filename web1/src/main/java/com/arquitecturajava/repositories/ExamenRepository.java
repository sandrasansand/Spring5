package com.arquitecturajava.repositories;

import java.util.List;

import com.arquitecturajava.models.Examen;

public interface ExamenRepository {

	List<Examen> buscarTodos();
	
	List<Examen> buscarTodosPorNombre(String nombre);

	void insertar(Examen examen);

	void borrar(Examen examen);

}