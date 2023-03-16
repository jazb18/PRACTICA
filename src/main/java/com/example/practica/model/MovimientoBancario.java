package com.example.practica.model;

import java.util.Date;
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
@Table(name = "movimientos_bancarios")
public class MovimientoBancario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long movimientoId;
  private Date Fecha;
  private String tipoMovimiento;
  private Double saldo;
  private Double valor;

  /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_cuenta", referencedColumnName = "cuentaId")
  private Cuenta cuenta;*/

}
