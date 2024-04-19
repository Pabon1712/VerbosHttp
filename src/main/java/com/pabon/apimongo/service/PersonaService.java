package com.pabon.apimongo.service;

import com.pabon.apimongo.model.Persona;
import com.pabon.apimongo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(String id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(String id) {
        personaRepository.deleteById(id);
    }

    public Persona update(String id, Persona updatedPersona) {
        Optional<Persona> optionalPersona = personaRepository.findById(id);
        if (optionalPersona.isPresent()) {
            Persona persona = optionalPersona.get();
            persona.setNombres(updatedPersona.getNombres());
            persona.setApellidos(updatedPersona.getApellidos());
            persona.setCorreo(updatedPersona.getCorreo());
            persona.setEdad(updatedPersona.getEdad());
            return personaRepository.save(persona);
        } else {
            
            return null;
        }
    }

	public String optionsUpdate() {
		return null;
	}
}


