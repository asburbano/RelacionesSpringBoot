package com.semana3.relaciones.repositories;


import com.semana3.relaciones.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {
}
