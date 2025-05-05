package br.edu.cs.poo.ac.seguro.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Sinistro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private Veiculo veiculo;
	private LocalDateTime dataHoraSinistro;
	private LocalDateTime dataHoraRegistro;
	private String usuarioRegistro;
	private BigDecimal valorSinistro;
	private TipoSinistro tipo;
}