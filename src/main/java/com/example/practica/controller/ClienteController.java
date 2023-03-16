package com.example.practica.controller;

import com.example.practica.model.Cliente;
import com.example.practica.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("")
  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  @GetMapping("/{id}")
  public Cliente findById(@PathVariable Long id) {
    return clienteRepository.findById(id).orElse(null);
  }

  @PostMapping("/save")
  public Cliente save(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @PutMapping("/{id}")
  public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
    cliente.setClienteId(id);
    return clienteRepository.save(cliente);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    clienteRepository.deleteById(id);
  }
}
