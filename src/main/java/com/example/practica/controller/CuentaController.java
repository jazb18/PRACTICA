package com.example.practica.controller;

import com.example.practica.model.Cuenta;
import com.example.practica.repository.CuentaRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

  @Autowired
  private CuentaRepository cuentaRepository;

  @GetMapping("/list")
  public List<Cuenta> findAll() {
    return cuentaRepository.findAll();
  }

  @GetMapping("/{id}")
  public Cuenta findById(@PathVariable Long id) {
    return cuentaRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontró la cuenta con ID " + id));
  }

  @PostMapping("/save")
  public Cuenta save(@RequestBody Cuenta cuenta) {
    return cuentaRepository.save(cuenta);
  }

  @PutMapping("/{id}")
  public Cuenta update(@PathVariable Long id, @RequestBody Cuenta cuenta) {
    cuenta.setCuentaId(id);
    return cuentaRepository.save(cuenta);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    cuentaRepository.deleteById(id);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleEntityNotFound(EntityNotFoundException ex) {
    return ex.getMessage();
  }
}
