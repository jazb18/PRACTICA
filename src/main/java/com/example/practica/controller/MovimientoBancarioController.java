package com.example.practica.controller;

import com.example.practica.model.Cuenta;
import com.example.practica.model.MovimientoBancario;
import com.example.practica.repository.CuentaRepository;
import com.example.practica.repository.MovimientoBancarioRepository;
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
@RequestMapping("/movimientos")
public class MovimientoBancarioController {

  @Autowired
  private MovimientoBancarioRepository movimientoRepository;

  @Autowired
  private CuentaRepository cuentaRepository;

  @GetMapping("")
  public List<MovimientoBancario> findAll() {
    return movimientoRepository.findAll();
  }

  @GetMapping("/{id}")
  public MovimientoBancario findById(@PathVariable Long id) {
    return movimientoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontró el movimiento con ID " + id));
  }

  @PostMapping("/{cuentaId}")
  public MovimientoBancario save(@PathVariable Long cuentaId, @RequestBody MovimientoBancario movimiento) {
    Cuenta cuenta = cuentaRepository.findById(cuentaId)
        .orElseThrow(() -> new EntityNotFoundException("No se encontró la cuenta con ID " + cuentaId));
    //movimiento.setCuenta(cuenta);
    return movimientoRepository.save(movimiento);
  }

  @PutMapping("/{id}/{cuentaId}")
  public MovimientoBancario update(@PathVariable Long id, @PathVariable Long cuentaId, @RequestBody MovimientoBancario movimiento) {
    Cuenta cuenta = cuentaRepository.findById(cuentaId)
        .orElseThrow(() -> new EntityNotFoundException("No se encontró la cuenta con ID " + cuentaId));
    //movimiento.setCuenta(cuenta);
    movimiento.setMovimientoId(id);
    return movimientoRepository.save(movimiento);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    movimientoRepository.deleteById(id);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleEntityNotFound(EntityNotFoundException ex) {
    return ex.getMessage();
  }
}
