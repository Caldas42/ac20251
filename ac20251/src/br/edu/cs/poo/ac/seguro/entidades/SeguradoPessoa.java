package br.edu.cs.poo.ac.seguro.entidades;

import java.time.LocalDate;
import java.math.BigDecimal;

public class SeguradoPessoa extends Segurado{
	private String cpf;
	private double renda;
	
	public SeguradoPessoa(String nome, Endereco endereco, LocalDate dataNascimento, BigDecimal bonus, String cpf, double renda) {
		super(nome, endereco, dataNascimento, bonus);
		this.cpf = cpf;
		this.renda = renda;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public double getRenda() {
		return renda;
	}
	
	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	public LocalDate getDataNascimento() {
		return getDataCriacao();
	}
	
	public void setDataNascimento(LocalDate dataAbertura) {
		setDataCriacao(dataAbertura);
	}
}
