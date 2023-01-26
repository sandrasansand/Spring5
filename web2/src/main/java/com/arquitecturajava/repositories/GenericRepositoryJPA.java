package com.arquitecturajava.repositories;

/*Utilizando la clase Optional de Java8 para manejar las excepciones*/
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;


public class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;
	private Class<T> tipo;

	@Transactional
	public void insertar(T tipo) {

		entityManager.persist(tipo);
	}

//constructor generico atrib Private Class<T> type;	
	public GenericRepositoryJPA() {
		// api de reflection cuando se construya un repo del tipo
		// q sea accede al primer parametro q usaremos para por ej métdo buscarUno
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		tipo = (Class) pt.getActualTypeArguments()[0];
	}

	@Transactional
	public void borrar(T tipo) {
		entityManager.remove(entityManager.merge(tipo));

	}

	@Override
	public Optional<T> buscarUno(K clave) {
		
		return Optional.ofNullable(entityManager.find(tipo, clave));
	}

	@Transactional
	public void actualizar(T tipo) {

		entityManager.merge(tipo);
	}

	@Override
	public List<T> buscarTodos() {
		// construido con el api de criteria de JPA

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(tipo);
		Root<T> root = cq.from(tipo);
		cq.select(root);
		TypedQuery<T> query = entityManager.createQuery(cq);
		return query.getResultList();
	}

}
