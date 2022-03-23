package com.br.aep.OneOff.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")

public class Usuario {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long cpf;
	private String senha;
	
	@OneToMany
	private List<Ponto> ponto;
	
	//construtor
	public Usuario() {
		
	}


	public Usuario(Long id, Long cpf, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//CPF
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	//Senha
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Ponto> getPonto() {
		return ponto;
	}
	
	public void setPonto(List<Ponto> ponto) {
		this.ponto = ponto;
	}
	
}
