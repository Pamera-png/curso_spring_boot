package com.rozembra.pamera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import com.rozembra.pamera.domain.entity.Cliente;
import com.rozembra.pamera.domain.repositorios.Clientes;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Fulano"));
            clientes.save(new Cliente("Outro Cliente"));

            List<Cliente> result = clientes.encontrarPorNome("Dougllas");
            result.forEach(System.out::println);

        };

            	}
	
	    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
