package com.semana3.relaciones.repositories;

import com.semana3.relaciones.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.biblioteca.id = :bibliotecaId")
    List<Libro> findLibrosByBibliotecaId(@Param("bibliotecaId") Long bibliotecaId);

    @Query("SELECT l FROM Libro l JOIN l.biblioteca b WHERE b.nombre = ?1")
    List<Libro> findLibrosByNombreBiblioteca(String nombreBiblioteca);

}
