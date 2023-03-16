package com.example.practica.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "cliente", schema = "prueba")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long clienteId;
  private String password;
  private Boolean estado;

  @OneToOne(targetEntity = Persona.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "fk_persona", referencedColumnName = "personaId")
  private Persona persona;

}
