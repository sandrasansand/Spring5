package com.arquitecturajava.repositories;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.models.Persona;

@Repository
public class PersonaRepositoryJPA extends GenericRepositoryJPA<Persona, String> implements PersonaRepository {

}
