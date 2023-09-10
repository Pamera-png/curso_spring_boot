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


	    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
