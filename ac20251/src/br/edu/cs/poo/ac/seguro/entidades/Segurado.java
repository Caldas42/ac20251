package br.edu.cs.poo.ac.seguro.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.Period;

public class Segurado implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Endereco endereco;
	private LocalDate dataCriacao;
	private BigDecimal bonus;
	
	public Segurado(String nome, Endereco endereco, LocalDate dataCriacao, BigDecimal bonus) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataCriacao = dataCriacao;
		this.bonus = bonus;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	protected LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
	protected void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public BigDecimal getbonus() {
		return bonus;
	}
	
	public int getIdade() {
	    return Period.between(dataCriacao, LocalDate.now()).getYears();
	}
	
	public void creditarBonus(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && this.bonus.compareTo(valor) >= 0) {
        	this.bonus = this.bonus.add(valor);
        }
	}
	
	public void debitarBonus(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && this.bonus.compareTo(valor) >= 0) {
        	this.bonus = this.bonus.subtract(valor);
        }
	}
}
