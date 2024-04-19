package com.pabon.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pabon.apimongo.model.Persona;

@Repository
public interface PersonaRepository extends MongoRepository<Persona,String> {

}
