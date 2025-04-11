package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoPessoaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;
import java.time.LocalDate;

public class SeguradoPessoaMediator {
	private SeguradoMediator seguradoMediator;
	private SeguradoPessoaDAO seguradoPessoaDAO;
	private static SeguradoPessoaMediator instancia = new SeguradoPessoaMediator();

	private SeguradoPessoaMediator() {}

	public static SeguradoPessoaMediator getInstancia() {
	    return instancia;
	}
	
	public String validarCpf(String cpf) {
		if (StringUtils.ehNuloOuBranco(cpf)) {
            return "CPF deve ser informado";
        } else if (!ValidadorCpfCnpj.ehCpfValido(cpf)) {
            return "CPF inválido";
        }
        return null;
	}
	
	public String validarRenda(double renda) {
		 if (renda < 0) {
			 return "Renda deve ser maior ou igual à zero";
		 }
		 
		 return null;
	}
	
	public String incluirSeguradoPessoa(SeguradoPessoa seg) {
		String msg = validarSeguradoPessoa(seg);
		
        if (msg != null) {
        	return msg;
        }

        if (!seguradoPessoaDAO.incluir(seg)) {
            return "CPF do segurado pessoa já existente";
        }
        
        return null;
	}
	
	public String alterarSeguradoPessoa(SeguradoPessoa seg) {
		String msg = validarSeguradoPessoa(seg);
		
        if (msg != null) {
        	return msg;
        }

        if (!seguradoPessoaDAO.alterar(seg)) {
            return "CPF do segurado pessoa não existente";
        }
        
        return null;
	}
	
	public String excluirSeguradoPessoa(String cpf) {
		if (seguradoPessoaDAO.buscar(cpf) == null) {
            return "CPF do segurado pessoa não existente";
        }

        seguradoPessoaDAO.excluir(cpf);
        
        return null;
	}
	
	public SeguradoPessoa buscarSeguradoPessoa(String cpf) {
		 return seguradoPessoaDAO.buscar(cpf);
	}
	
	public String validarSeguradoPessoa(SeguradoPessoa seg) {
		String msg;

        msg = seguradoMediator.validarNome(seg.getNome());
        if (msg != null) {
        	return msg;
        }

        msg = seguradoMediator.validarEndereco(seg.getEndereco());
        if (msg != null) {
        	return msg;
        }

        LocalDate dataCriacao = seg.getDataNascimento();
        
        if (dataCriacao == null) {
            return "Data do nascimento deve ser informada";
        }

        msg = validarCpf(seg.getCpf());
        
        if (msg != null) {
        	return msg;
        }

        msg = validarRenda(seg.getRenda());
        
        if (msg != null) {
        	return msg;
        }

        return null;
	}
}

