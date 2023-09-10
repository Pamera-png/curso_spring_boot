package com.rozembra.pamera.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rozembra.pamera.domain.entity.Cliente;

@Controller
public class ClienteController {

	//mapeia o endpoint ou rota que será acessada no navegador, que pode ser mais de uma
	//define o método http
	//o nome entre chaves também será passado no parametro PathVariable
	@RequestMapping(
			value = {"/api/clientes/hello/{nome}", "/api/hello"},
			method = RequestMethod.POST,
			consumes = {"application/json", "application/xml"},
					produces = { "application/json", "application/xml" }
			)

	@ResponseBody
	public String helloCliente (@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente) {
		return String.format("Hello %s ", nomeCliente);
	}
}
