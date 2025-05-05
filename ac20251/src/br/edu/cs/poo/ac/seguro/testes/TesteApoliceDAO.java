package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.daos.VeiculoDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;
import br.edu.cs.poo.ac.seguro.entidades.CategoriaVeiculo;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;

public class TesteApoliceDAO extends TesteDAO {
	private ApoliceDAO dao = new ApoliceDAO();
	
	protected Class getClasse() {
		return Apolice.class;
	}
	
	@Test
	public void teste01() {
		String numero = "1";
		cadastro.incluir(new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);
		Apolice ap = dao.buscar(numero);
		Assertions.assertNotNull(ap); 
	}
	
	@Test
	public void teste02() {
		String numero = "2";
		cadastro.incluir(new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);
		Apolice ap = dao.buscar("1");
		Assertions.assertNull(ap);
	}
	
	@Test
	public void teste03() {
		String numero = "3";
		cadastro.incluir(new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);
		boolean ret = dao.excluir(numero);
		Assertions.assertTrue(ret);
	}
	
	@Test
	public void teste04() {
		String numero = "4";
		cadastro.incluir(new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);
		boolean ret = dao.excluir("1");
		Assertions.assertFalse(ret);
	}
	
	@Test
	public void teste05() {
		String numero = "5";		
		boolean ret = dao.incluir(new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);		
		Assertions.assertTrue(ret);
		Apolice ap = dao.buscar(numero);
		Assertions.assertNotNull(ap);		
	}
	
	@Test
	public void teste06() {
		String numero = "1";		
		Apolice ap = new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);
		cadastro.incluir(ap, numero);
		boolean ret = dao.incluir(ap);
		Assertions.assertFalse(ret);
	}
	
	@Test
	public void teste07() {
		String numero = "2";			
		boolean ret = dao.alterar(new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now()), numero);	
		Assertions.assertFalse(ret);
		Apolice ap = dao.buscar(numero);
		Assertions.assertNull(ap);		
	}
	
	@Test
	public void teste08() {
		String numero = "3";			
		Apolice ap = new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now());
		cadastro.incluir(ap, numero);
		ap = new Apolice(numero, null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now());
		boolean ret = dao.alterar(ap);
		Assertions.assertTrue(ret);
	}
}