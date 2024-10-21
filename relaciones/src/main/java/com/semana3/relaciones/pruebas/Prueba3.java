package com.semana3.relaciones.pruebas;

import com.semana3.relaciones.entities.Biblioteca;
import com.semana3.relaciones.entities.Libro;
import com.semana3.relaciones.repositories.BibliotecaRepository;
import com.semana3.relaciones.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Prueba3 implements CommandLineRunner {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public void run(String... args)throws Exception {
        // Creación de la biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNombre("Biblioteca Central");
        biblioteca.setDireccion("Sector La Alameda");
        // Creación de los libros
        Libro libro1 = new Libro();
        libro1.setAutor("Miguel de Cervantes");
        libro1.setTitulo("Don Quijote de la Mancha");
        libro1.setBiblioteca(biblioteca);
        Libro libro2 = new Libro();
        libro2.setTitulo("Cien años de soledad");
        libro2.setAutor("Gabriel García Márquez");
        libro2.setBiblioteca(biblioteca);
        // Asociar los libros a la biblioteca
        biblioteca.getLibros().add(libro1);
        biblioteca.getLibros().add(libro2);
        // Guardar la biblioteca
        bibliotecaRepository.save(biblioteca);
        Optional<Biblioteca> bibliotecaGuardada = bibliotecaRepository.findById(biblioteca.getId());
        // Recuperar la biblioteca guardada
        if (bibliotecaGuardada.isPresent()) {
            Biblioteca bibliotecaObtenida = bibliotecaGuardada.get();
            System.out.println("Biblioteca obtenida: " + bibliotecaObtenida.getNombre());
            bibliotecaObtenida.getLibros().size();
            bibliotecaObtenida.setNombre("Biblioteca 2");
            bibliotecaRepository.save(bibliotecaObtenida);
            System.out.println("Biblioteca actualizada: "+bibliotecaObtenida.getNombre());
            Libro libro3 = new Libro();
            libro3.setTitulo("El nombre de la rosa");
            libro3.setAutor("autorObtenido");
            libroRepository.save(libro3);
            System.out.println("Libro creado: " + libro3.getTitulo());
            Optional<Libro> libroOptional = libroRepository.findById(libro1.getId());
            // Eliminar libro1
            if(libroOptional.isPresent()) {
                Libro libroEliminar = libroOptional.get();
                libroRepository.delete(libroEliminar);
                System.out.println("Libro eliminado: " + libroEliminar.getTitulo());
            }else{
                System.out.println("Libro no encontrado");
            }
        }else{
            System.out.println("Libro no encontrado");
        }
        }

    }
