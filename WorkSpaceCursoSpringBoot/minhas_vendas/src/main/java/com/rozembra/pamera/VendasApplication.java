package com.rozembra.pamera;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rozembra.pamera.domain.entity.Cliente;
import com.rozembra.pamera.domain.entity.Pedido;
import com.rozembra.pamera.domain.repositorios.Clientes;
import com.rozembra.pamera.domain.repositorios.Pedidos;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos) {
		return args -> {
            
            Cliente fulano = new Cliente("Fulano");
            clientes.save(fulano);
            
            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            //Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//System.out.println(cliente);
//System.out.println(cliente.getPedidos());

            
            pedidos.findByCliente(fulano).forEach(System.out::println);
           
        };

            	}
	
	    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
