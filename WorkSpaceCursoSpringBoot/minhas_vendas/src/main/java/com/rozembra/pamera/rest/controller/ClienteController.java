package com.rozembra.pamera.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rozembra.pamera.domain.entity.Cliente;
import com.rozembra.pamera.domain.repositorios.Clientes;

@Controller
public class ClienteController {

	private Clientes clientes;

	public ClienteController(Clientes clientes) {
		this.clientes = clientes;
	}

	@GetMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity getClienteById(@PathVariable Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/api/clientes")
	@ResponseBody
	public ResponseEntity save(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clientes.save(cliente);
		return ResponseEntity.ok(clienteSalvo);
	}

	@DeleteMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity delete(@PathVariable Integer id) {
		Optional<Cliente> cliente = clientes.findById(id);

		if (cliente.isPresent()) {
			clientes.delete(cliente.get());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		//O método map é usado para executar uma ação quando o cliente é encontrado.
		return clientes.findById(id).map(
				//crio uma expressão lambda com o tipo do parametro clienteExistente sendo inferido pelo compilador. Esse lambda está sendo criado dentro da chamada do metodo map e tem um bloco de código com return
				clienteExistente -> {
			//O ID do cliente existente é copiado para o cliente que está sendo atualizado. Isso é feito para garantir que o ID do cliente a ser atualizado seja o mesmo que o cliente existente.
			cliente.setId(clienteExistente.getId());
			//O cliente atualizado é salvo no repositório de clientes. Isso efetua a atualização do cliente existente com as novas informações.
			clientes.save(cliente);
			return ResponseEntity.noContent().build();
		} //fim do lambda
				).orElseGet(
						//crio um segundo lambda sem parametro dentro da chamada do metodo orElseGet. Esse lambda tem apenas uma expressão
						() -> ResponseEntity.notFound().build());
		//O método orElseGet é usado quando o cliente com o ID especificado não é encontrado. Nesse caso, um erro 404 é retornado, indicando que o cliente não foi encontrado no sistema.
	} //do metodo update

	@GetMapping("/api/clientes")
    public ResponseEntity find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher.matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }


}