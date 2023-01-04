package com.arquitecturajava.repositories;

/*interfaz que podemos utilizar como un tipo genérico 
para poder ser aplicado a todos los repos*/
import java.util.List;

public interface GenericRepository<T,K> {
	void inserrtar(T tipo);
	void borrar(T tipo);
	T buscarUno(K clave);
	void actualizar(T tipo);
	List<T> buscarTodos();
}
