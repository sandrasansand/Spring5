package com.arquitecturajava.repositories;

/*lo hacemos extender del GenericJPA con todo lo que conlleva, no necesitamos el
contexto em, lo tenemos protected de la clase superior
como los metds insertar() borrar()buscarUno() actualiza()
*/

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.models.Examen;

@Repository
public class ExamenRepositoryJPA extends GenericRepositoryJPA<Examen, Integer> implements ExamenRepository {

	@Override
	public List<Examen> buscarTodosPorNombre(String nombre) {
		// utilizamos jpa para la consulta, se pone la entidad(Clase) no la tabla de la
		// bd, es decir la
		// clase em
		TypedQuery<Examen> consulta = entityManager.createQuery("Select e from Examen e where e.persona.nombre=:nombre",
				Examen.class);
		consulta.setParameter("nombre", nombre);
		return consulta.getResultList();
	}

}
