package com.semana3.relaciones.pruebas;

import com.semana3.relaciones.entities.Cliente;
import com.semana3.relaciones.entities.Pedido;
import com.semana3.relaciones.repositories.ClienteRepositoy;
import com.semana3.relaciones.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Prueba2 implements CommandLineRunner {
    @Autowired
    private ClienteRepositoy clienteRepositoy;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Override
    public void run(String... args)throws Exception{
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Chavez");
        Pedido pedido1 = new Pedido();
        pedido1.setDescripcion("Manzana Roja");
        Pedido pedido2 = new Pedido();
        pedido2.setDescripcion("Café Arábica");

        cliente.getPedidos().add(pedido1);
        cliente.getPedidos().add(pedido2);

        clienteRepositoy.save(cliente);

        Optional<Cliente> clienteGuardado = clienteRepositoy.findById(cliente.getId());
        clienteGuardado.ifPresent(c -> {
            System.out.println("Cliente leido por ID: "+ c.getNombre());
            c.setNombre("Maria Chavez");
            clienteRepositoy.save(c);
            System.out.println("Cliente actualizado: "+c.getNombre());
        });
        List<Cliente> clientes = clienteRepositoy.findAll();
        System.out.println("Lista de clientes: ");
        for(Cliente c:clientes){
            System.out.println(" "+c.getNombre());
        }
        clienteRepositoy.delete(cliente);

        System.out.println("Cliente eliminado");
    }
}
