package com.example.practica.controller;

import com.example.practica.model.Persona;
import com.example.practica.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonaController {

  @Autowired
  private PersonaRepository personaRepository;

  @GetMapping("")
  public List<Persona> findAll() {
    return personaRepository.findAll();
  }

  @GetMapping("/{id}")
  public Persona findById(@PathVariable Long id) {
    return personaRepository.findById(id).orElse(null);
  }

  @PostMapping("/save")
  public Persona save(@RequestBody Persona persona) {
    return personaRepository.save(persona);
  }

  @PutMapping("/{id}")
  public Persona update(@PathVariable Long id, @RequestBody Persona persona) {
    persona.setPersonaId(id);
    return personaRepository.save(persona);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    personaRepository.deleteById(id);
  }
}
