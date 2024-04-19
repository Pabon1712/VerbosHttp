package com.pabon.apimongo.controller;

import com.pabon.apimongo.model.Persona;
import com.pabon.apimongo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/getAll")
    public List<Persona> getAll() {
        return personaService.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<Persona> insert(@RequestBody Persona persona) {
        Persona savedPersona = personaService.save(persona);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(savedPersona, headers, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> update(@PathVariable String id, @RequestBody Persona persona) {
        Persona updatedPersona = personaService.update(id, persona);
        if (updatedPersona != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(updatedPersona, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        personaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/updateData/{id}")
    public ResponseEntity<Persona> updateData(@PathVariable String id, @RequestBody Persona persona) {
        Persona updatedPersona = personaService.update(id, persona);
        if (updatedPersona != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(updatedPersona, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.OPTIONS)
    public String optionsUpdate() {
        return personaService.optionsUpdate();
    }
}
