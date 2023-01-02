package com.arquitecturajava.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.models.Examen;

@Repository
public class ExamenRepositoryJPA implements ExamenRepository {
	@PersistenceContext
	EntityManager em;


	@Override
	public List<Examen> buscarTodos() {
		// utilizamos jpa para la consulta, se pone la entidad no la tabla, es decir la
		// clase em
		TypedQuery<Examen> consulta = em.createQuery("Select e from Examen e", Examen.class);
		return consulta.getResultList();
	}
	
	@Override
	public List<Examen> buscarTodosPorNombre(String nombre) {
		// utilizamos jpa para la consulta, se pone la entidad(Clase) no la tabla de la bd, es decir la
		// clase em
		TypedQuery<Examen> consulta = em.createQuery("Select e from Examen e where e.persona.nombre=:nombre", Examen.class);
		consulta.setParameter("nombre", nombre);
		return consulta.getResultList();
	}

	@Override
	@Transactional
	public void insertar(Examen examen) {
		em.persist(examen);
	}

	@Override
	@Transactional
	public void borrar(Examen examen) {
		em.remove(em.merge(examen));
	}
}
