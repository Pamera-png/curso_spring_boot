package com.rozembra.pamera.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity

//essa anotation é obrigatoria quando o nome da tabela no banco de dados é diferente do nome da entidade no java. Entao deve-se colocar na anotation o nome da tabela do banco
@Table(name="cliente")
public class Cliente {

	//essa anotation é obrigatoria e define qual é a primary key da entidade
	@Id
	//essa anotation define o auto increment da propriedade
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="nome", length = 100)
	private String nome;

	//mapeia uma collection para pedido
	//o FetchType.LAZY é uma propriedade que trás os clientes junto com seus pedidos, mas também pode trazer somente os clientes
	@OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    private Set<Pedido> pedidos;

	public Cliente() {
		
	}

	public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}


	
}
