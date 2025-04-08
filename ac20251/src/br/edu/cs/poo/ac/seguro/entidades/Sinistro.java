package br.edu.cs.poo.ac.seguro.entidades;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

@RequiredArgsConstructor
@Getter
@Setter

public class Sinistro {
	private String numero;
	@NonNull
	private Veiculo veiculo;
	@NonNull
	private LocalDateTime dataHoraSinistro;
	@NonNull
	private LocalDateTime dataHoraRegistro;
	@NonNull
	private String usuarioRegistro;
	@NonNull
	private BigDecimal valorSinistro;
	@NonNull
	private TipoSinistro tipo;
}