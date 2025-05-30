package br.edu.cs.poo.ac.seguro.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Apolice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private Veiculo veiculo;
	private BigDecimal valorFranquia;
	private BigDecimal valorPremio;
	private BigDecimal valorMaximoSegurado;
	private LocalDate dataInicioVigencia;
}