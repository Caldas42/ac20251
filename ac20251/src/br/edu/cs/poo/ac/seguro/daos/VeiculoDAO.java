package br.edu.cs.poo.ac.seguro.daos;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;

public class VeiculoDAO {
	public VeiculoDAO() {
		cadastro = new CadastroObjetos(Veiculo.class);
	}
	
    public Veiculo buscar(String placa) {
		return (SeguradoEmpresa)cadastro.buscar(placa);
    }
    
    public boolean incluir(Veiculo veiculo) {
		if (buscar(segurado.getPlaca()) != null) {
			return false;
		} else {
			cadastro.incluir(segurado, segurado.getPlaca());
			return true;
		}    
	}
    
    public boolean alterar(Veiculo veiculo) {
		if (buscar(segurado.getPlaca()) == null) {
			return false;
		} else {
			cadastro.alterar(segurado, segurado.getPlaca());
			return true;
		} 
	}
    
    public boolean excluir(String placa) {
		if (buscar(placa) == null) {
			return false;
		} else {
			cadastro.excluir(placa);
			return true;
		}
	}
}