package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter

public class Apolice {
	@NonNull
	private Veiculo veiculo;
	@NonNull
	private BigDecimal valorFranquia;
	@NonNull
	private BigDecimal valorPremio;
	@NonNull
	private BigDecimal valorMaximoSegurado;
	private String numero;
}