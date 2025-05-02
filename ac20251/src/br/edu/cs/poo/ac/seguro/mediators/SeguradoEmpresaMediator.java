package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoEmpresaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoEmpresa;

public class SeguradoEmpresaMediator {
	private SeguradoMediator seguradoMediator;
	private SeguradoEmpresaDAO seguradoEmpresaDAO;
	private static SeguradoEmpresaMediator instancia = new SeguradoEmpresaMediator();

	private SeguradoEmpresaMediator() {}

	public static SeguradoEmpresaMediator getInstancia() {
	    return instancia;
	}
	
	public String validarCnpj(String cnpj) {
        if (!ValidadorCpfCnpj.ehCnpjValido(cnpj)) {
            return "CNPJ inválido";
        }
        return null;
	}
	public String validarFaturamento(double faturamento) {
		if (faturamento <= 0) {
            return "Faturamento deve ser maior que zero";
        }
        return null;
	}
	public String incluirSeguradoEmpresa(SeguradoEmpresa seg) {
		String msg = validarSeguradoEmpresa(seg);
		 
        if (msg != null) {
            return msg;
        }
        
        if (!seguradoEmpresaDAO.incluir(seg)) {
            return "CNPJ do segurado empresa já existente";
        }
        
        return null;
	}
	public String alterarSeguradoEmpresa(SeguradoEmpresa seg) {
		String msg = validarSeguradoEmpresa(seg);
		
        if (msg != null) {
            return msg;
        }
        
        if (!seguradoEmpresaDAO.alterar(seg)) {
            return "CNPJ do segurado empresa não existente";
        }
        
        return null;
	}
	public String excluirSeguradoEmpresa(String cnpj) {
		if (!seguradoEmpresaDAO.excluir(cnpj)) {
            return "CNPJ do segurado empresa não existente";
        }
		
        return null;
	}
	public SeguradoEmpresa buscarSeguradoEmpresa(String cnpj) {
		return seguradoEmpresaDAO.buscar(cnpj);
	}
	public String validarSeguradoEmpresa(SeguradoEmpresa seg) {
		String msg;

        msg = seguradoMediator.validarNome(seg.getNome());
        if (msg != null) {
            return msg;
        }

        msg = seguradoMediator.validarEndereco(seg.getEndereco());
        if (msg != null) {
            return msg;
        }

        if (seg.getDataAbertura() == null) {
            return "Data da abertura deve ser informada";
        }

        msg = validarCnpj(seg.getCnpj());
        if (msg != null) {
            return msg;
        }

        msg = validarFaturamento(seg.getFaturamento());
        if (msg != null) {
            return msg;
        }

        return null;
	}
}