package com.example.practica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "persona", schema = "prueba")
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long personaId;
  private String nombre;
  private String apellido;
  private String genero;
  private int edad;
  private int dni;
  private String direccion;
  private String telefono;

}
