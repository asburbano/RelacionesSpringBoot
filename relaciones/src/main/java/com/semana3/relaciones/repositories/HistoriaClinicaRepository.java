package com.semana3.relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.semana3.relaciones.entities.HistoriaClinica;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    @Query("SELECT h FROM HistoriaClinica h WHERE h.paciente.id = :pacienteId ORDER BY h.fecha DESC")
    HistoriaClinica findUltimaHistoriaClinica(@Param("pacienteId") Long pacienteId);

}
