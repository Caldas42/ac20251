package br.edu.cs.poo.ac.seguro.mediators;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.edu.cs.poo.ac.seguro.entidades.Endereco;

public class SeguradoMediator {
	private static SeguradoMediator instancia = new SeguradoMediator();

	private SeguradoMediator() {}

	public static SeguradoMediator getInstancia() {
	    return instancia;
	}
	
	public String validarNome(String nome) {
		if (StringUtils.ehNuloOuBranco(nome)) {
			return "Nome deve ser informado";
		} else if (nome.length() > 100) {
			return "Tamanho do nome deve ser no máximo 100 caracteres";
		}
		
		return null;
	}
	
	public String validarEndereco(Endereco endereco) {
		if (endereco == null) {
			return "Endereço deve ser informado";
		} else {
			if (StringUtils.ehNuloOuBranco(endereco.getLogradouro())) {
				return "Logradouro deve ser informado";
			}
			
			if (StringUtils.ehNuloOuBranco(endereco.getCep())) {
				return "CEP deve ser informado";
			} else {
				if (!StringUtils.temSomenteNumeros(endereco.getCep())) {
					return "CEP deve ter formato NNNNNNNN";
				} else if (endereco.getCep().length() != 8) {
					return "Tamanho do CEP deve ser 8 caracteres";
				}
			}
			
			if (endereco.getNumero() != null && endereco.getNumero().trim().length() > 20) {
				return "Tamanho do número deve ser no máximo 20 caracteres";
			}
			
			if (endereco.getComplemento() != null && endereco.getComplemento().trim().length() > 30) {
				return "Tamanho do complemento deve ser no máximo 30 caracteres";
			}
			
			if (StringUtils.ehNuloOuBranco(endereco.getPais())) {
				return "País deve ser informado";
			} else if (endereco.getPais().length() > 40) {
				return "Tamanho do país deve ser no máximo 40 caracteres";
			}
			
			if (StringUtils.ehNuloOuBranco(endereco.getEstado())) {
				return "Estado deve ser informado";
			} if (endereco.getEstado().length() != 2) {
				return "Tamanho do estado deve ser 2 caracteres";
			}
			
			if (StringUtils.ehNuloOuBranco(endereco.getCidade())) {
				return "Cidade deve ser informada";
			} else if (endereco.getCidade().length() > 100) {
				return "Tamanho da cidade deve ser no máximo 100 caracteres";
			}
		}	

		return null;
	}
	
	public String validarDataCriacao(LocalDate dataCriacao) {
		if (dataCriacao == null) {
			return "Data da criação deve ser informada";
		} else if (dataCriacao.isAfter(LocalDate.now())) {
			return "Data da criação deve ser menor ou igual à data atual";
		}
		
		return null;
	}
	
	public BigDecimal ajustarDebitoBonus(BigDecimal bonus, BigDecimal valorDebito) {
		if (bonus.compareTo(valorDebito) >= 0) {
			return valorDebito;
		}
		
		return bonus;
	}
}