package com.example.practica.repository;

import com.example.practica.model.MovimientoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoBancarioRepository extends JpaRepository<MovimientoBancario, Long> {

}
