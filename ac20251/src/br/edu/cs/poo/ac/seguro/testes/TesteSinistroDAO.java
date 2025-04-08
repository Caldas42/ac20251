package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import br.edu.cs.poo.ac.seguro.entidades.CategoriaVeiculo;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;

public class TesteSinistroDAO extends TesteDAO {
	private SinistroDAO dao = new SinistroDAO();
	protected Class getClasse() {
		return Sinistro.class;
	}
	
	@Test
	public void teste01() {
		String numero = "1";
		cadastro.incluir(new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null), numero);
		Sinistro si = dao.buscar(numero);
		Assertions.assertNotNull(si); 
	}
	@Test
	public void teste02() {
		String numero = "2";
		cadastro.incluir(new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null), numero);
		Sinistro si = dao.buscar("1");
		Assertions.assertNotNull(si);
	}
	@Test
	public void teste03() {
		String numero = "2";
		cadastro.incluir(new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null), numero);
		boolean ret = dao.excluir(numero);
		Assertions.assertTrue(ret);
	}
	@Test
	public void teste04() {
		String numero = "3";
		cadastro.incluir(new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null), numero);
		boolean ret = dao.excluir("2");
		Assertions.assertFalse(ret);
	}
	@Test
	public void teste05() {
		String numero = "4";		
		boolean ret = dao.incluir(new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null));
		Assertions.assertTrue(ret);
		Sinistro si = dao.buscar(numero);
		Assertions.assertNotNull(si);		
	}
	
	@Test
	public void teste06() {
		String numero = "5";		
		Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null);
		cadastro.incluir(si, numero);
		boolean ret = dao.incluir(si);
		Assertions.assertFalse(ret);
	}
	@Test
	public void teste07() {
		String numero = "3";			
		boolean ret = dao.alterar(new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null));		
		Assertions.assertFalse(ret);
		Sinistro si = dao.buscar(numero);
		Assertions.assertNull(si);		
	}
	
	@Test
	public void teste08() {
		String numero = "2";			
		Sinistro si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null);
		cadastro.incluir(si, numero);
		si = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "Registro", BigDecimal.ZERO, null);
		boolean ret = dao.alterar(si);
		Assertions.assertTrue(ret);
	}
	
}