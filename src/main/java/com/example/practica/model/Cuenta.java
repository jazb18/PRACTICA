package com.example.practica.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cuenta", schema = "prueba")
public class Cuenta {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long cuentaId;
  private String numeroCuenta;
  private String tipoCuenta;
  private Double saldoInicial;
  private Boolean estado;
  private String tipoTarjeta;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_cliente", referencedColumnName = "clienteId")
  private Cliente cliente;

  @OneToMany(targetEntity = MovimientoBancario.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "fk_cuenta", referencedColumnName = "cuentaId")
  private List<MovimientoBancario> movimientos;
}
