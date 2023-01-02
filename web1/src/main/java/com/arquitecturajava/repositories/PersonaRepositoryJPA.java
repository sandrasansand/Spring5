package com.arquitecturajava.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.models.Persona;

@Repository
public class PersonaRepositoryJPA implements PersonaRepository {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Persona> buscarTodos() {
		// utilizamos jpa para la consulta, se pone la entidad no la tabla, es decir la
		// clase em
		TypedQuery<Persona> consulta = em.createQuery("Select p from Persona p", Persona.class);
		return consulta.getResultList();
	}

	@Transactional
	public void insertar(Persona p) {
		em.persist(p);
	}

	@Transactional
	public void borrar(Persona p) {
		em.remove(em.merge(p));
	}

	@Override
	public Persona buscarUno(String nombre) {
		return em.find(Persona.class, nombre);
	}
}
