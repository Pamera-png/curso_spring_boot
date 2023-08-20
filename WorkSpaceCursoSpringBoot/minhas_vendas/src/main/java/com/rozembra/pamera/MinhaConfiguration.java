package com.rozembra.pamera;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration

//essa anotacao diz que a configuracao / metodo dessa classe somente funciona para ambiente development
@Profile("development")
public class MinhaConfiguration {

	@Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }
}
