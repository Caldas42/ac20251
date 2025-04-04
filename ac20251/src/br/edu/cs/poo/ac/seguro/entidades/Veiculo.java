package br.edu.cs.poo.ac.seguro.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Veiculo {
	private String placa;
	private int ano;
	private SeguradoEmpresa proprietarioEmpresa;
	private SeguradoPessoa proprietarioPessoa;
	private CategoriaVeiculo categoria;
}