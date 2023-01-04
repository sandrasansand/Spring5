package com.arquitecturajava.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="examenes")
public class Examen {
	@Id
	private int id;
	private String asignatura;
	//rel n:1 mientras que a un examen le pertenece a una persona
	@ManyToOne 
	@JoinColumn(name="personas_nombre")
	private Persona persona;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public Examen(int id, String asignatura) {
		super();
		this.id = id;
		this.asignatura = asignatura;
	}
	public Examen() {
		super();
	}
	//lo utilizamos para eliminar por id
	public Examen(int id) {
		super();
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
}
