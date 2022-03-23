package com.br.aep.OneOff.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ponto")
public class Ponto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date horarioEntrada;
	
	private Calendar ddMmYyyy;
	
	private Date horarioSaida;
	
	@ManyToOne
	private Usuario usuario;
	
	public Ponto() {
		// TODO Auto-generated constructor stub
	}

	public Date getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(Date horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public Date getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(Date horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getDdMmYyyy() {
		return ddMmYyyy;
	}

	public void setDdMmYyyy(Calendar ddMmYyyy) {
		this.ddMmYyyy = ddMmYyyy;
	}
	
	 
	
	
	
	
}
