package com.arquitecturajava.repositories;

/*vamos hacer que extienda del generico con todo lo q conlleva
*/
import java.util.List;

import com.arquitecturajava.models.Examen;

public interface ExamenRepository extends GenericRepository<Examen, Integer> {

	List<Examen> buscarTodosPorNombre(String nombre);

}