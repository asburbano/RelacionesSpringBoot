package com.semana3.relaciones.pruebas;

import com.semana3.relaciones.entities.HistoriaClinica;
import com.semana3.relaciones.entities.Paciente;
import com.semana3.relaciones.repositories.HistoriaClinicaRepository;
import com.semana3.relaciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba1 implements CommandLineRunner {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public void run(String... args)throws Exception{
        Paciente paciente = new Paciente();
        paciente.setNombre("Alex Erazo");
        paciente.setDireccion("Chillogallo");

        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setDiagnosticos("Dificultad para respirar");
        historiaClinica.setTratamientos("Salbutamol");
        historiaClinica.setPaciente(paciente);

        historiaClinicaRepository.save(historiaClinica);

        historiaClinica.setDiagnosticos("Dificultad para respirar actualizado");
        historiaClinicaRepository.save(historiaClinica);

        Iterable<HistoriaClinica> historiaClinicas = historiaClinicaRepository.findAll();
        for (HistoriaClinica h :historiaClinicas){
            System.out.println("Historia Clinica:"+h.getDiagnosticos() + " Tratamiento:"+h.getTratamientos());
        }
        historiaClinicaRepository.delete(historiaClinica);
    }
}
