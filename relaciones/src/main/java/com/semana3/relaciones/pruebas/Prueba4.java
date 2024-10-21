package com.semana3.relaciones.pruebas;

import com.semana3.relaciones.entities.Ingrediente;
import com.semana3.relaciones.entities.Receta;
import com.semana3.relaciones.repositories.IngredienteRepository;
import com.semana3.relaciones.repositories.RecetaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class Prueba4 implements CommandLineRunner {
    @Autowired
    private RecetaRepository recetaRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    public void run(String... args)throws Exception{
        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setNombre("Harina");

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setNombre("Tomate");

        Receta receta1 = new Receta();
        receta1.setNombre("Pasta al pomodoro");

        Receta receta2 = new Receta();
        receta2.setNombre("Ensalada César");

        ingrediente1.getRecetas().add(receta1);
        ingrediente2.getRecetas().add(receta2);

        ingrediente2.getRecetas().add(receta1);

        ingredienteRepository.save(ingrediente1);
        ingredienteRepository.save(ingrediente2);

        Ingrediente ingredienteRecuperado = ingredienteRepository.findById(2L).orElse(null);
        System.out.println("Ingrediente recuperado: "+ingredienteRecuperado.getNombre());

        Receta recetaRecuperada = recetaRepository.findById(2L).orElse(null);
        System.out.println("Receta recuperada: "+recetaRecuperada.getNombre());

        ingredienteRepository.deleteById(2L);
        recetaRepository.deleteById(2L);
    }
}
