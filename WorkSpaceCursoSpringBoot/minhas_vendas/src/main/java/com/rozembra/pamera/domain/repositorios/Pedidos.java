package com.rozembra.pamera.domain.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Set;
import com.rozembra.pamera.domain.entity.Cliente;
import com.rozembra.pamera.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

	List<Pedido> findByCliente(Cliente cliente);
}
