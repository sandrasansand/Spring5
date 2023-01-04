package com.arquitecturajava.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;
	private Class<T> tipo;

	@Override
	public void inserrtar(T tipo) {

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

	@Override
	public void borrar(T tipo) {
		entityManager.remove(entityManager.merge(tipo));

	}

	@Override
	public T buscarUno(K clave) {
		// TODO Auto-generated method stub
		return entityManager.find(tipo, clave);
	}

	@Override
	public void actualizar(T tipo) {

		entityManager.merge(tipo);
	}

	@Override
	public List<T> buscarTodos() {
		// contruido con el api de criteria de JPA

		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(tipo);
		Root<T> root = cq.from(tipo);
		cq.select(root);
		TypedQuery<T> query = entityManager.createQuery(cq);
		return query.getResultList();
	}

}
