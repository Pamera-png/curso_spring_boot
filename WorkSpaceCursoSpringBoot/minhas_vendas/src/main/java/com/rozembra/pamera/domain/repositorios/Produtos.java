package com.rozembra.pamera.domain.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rozembra.pamera.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
