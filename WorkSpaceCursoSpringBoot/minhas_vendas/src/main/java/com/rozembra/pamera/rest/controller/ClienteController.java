package com.rozembra.pamera.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.rozembra.pamera.domain.entity.Cliente;
import com.rozembra.pamera.domain.repositorios.Clientes;

@Controller
public class ClienteController {

	private Clientes clientes;
	
	public ClienteController(Clientes clientes) {
		this.clientes=clientes;
	}
	
	@GetMapping("/api/clientes/{id}")
		@ResponseBody
	public ResponseEntity getClienteById(@PathVariable Integer id ) {
		Optional<Cliente> cliente = clientes.findById(id);
		
		if(cliente.isPresent()){
            return ResponseEntity.ok( cliente.get() );
        }

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save( @RequestBody Cliente cliente ){
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

}
