package br.edu.cs.poo.ac.seguro.mediators;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.daos.SeguradoEmpresaDAO;
import br.edu.cs.poo.ac.seguro.daos.SeguradoPessoaDAO;
import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import br.edu.cs.poo.ac.seguro.daos.VeiculoDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;
import br.edu.cs.poo.ac.seguro.entidades.CategoriaVeiculo;
import br.edu.cs.poo.ac.seguro.entidades.PrecoAno;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoEmpresa;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;
import br.edu.cs.poo.ac.seguro.entidades.Veiculo;

public class ApoliceMediator {
	private SeguradoPessoaDAO daoSegPes;
	private SeguradoEmpresaDAO daoSegEmp;
	private VeiculoDAO daoVel;
	private ApoliceDAO daoApo;
	private SinistroDAO daoSin;

	private ApoliceMediator() {}
	/*
	 * Algumas regras de valida��o e l�gicas devem ser inferidas atrav�s da leitura e 
	 * do entendimento dos testes automatizados. Seguem abaixo explica��es pertinentes
	 * e necess�rias ao entendimento completo de como este m�todo deve funcionar.
	 * 
	 *  Toda vez que um retorno contiver uma mensagem de erro n�o nula, significando
	 *  que a ap�lice n�o foi inclu�da, o numero da ap�lice no retorno deve ser nulo.
	 *  
	 *  Toda vez que um retorno contiver uma mensagem de erro n�o nula, significando
	 *  que a ap�lice n�o foi inclu�da, o numero da ap�lice no retorno deve ser nulo.
	 *  
	 *  Toda vez que um retorno contiver uma mensagem de erro nula, significando
	 *  que a ap�lice foi inclu�da com sucesso, o numero da ap�lice no retorno deve ser 
	 *  o n�mero da ap�lice inclu�da.
	 * 
	 * � clase Apolice, deve ser acrescentado (com seus respectivos get/set e presen�a
	 * dele no construtor) o atributo LocalDate dataInicioVigencia.
	 * 
	 * O n�mero da ap�lice � igual a:
	 * Se cpfOuCnpj de dados for um CPF
	 *     n�mero da ap�lice  = ano atual + "000" + cpfOuCnpj + placa  
	 * Se cpfOuCnpj de dados for um CNPJ
	 *     n�mero da ap�lice  = ano atual + cpfOuCnpj + placa  
	 *     
	 * O valor do pr�mio � calculado da seguinte forma
	 * (A) Calcula-se VPA = (3% do valor m�ximo segurado) 
	 * (B) Calcula-se VPB = 1.2*VPA, se segurado for empresa e indicador de locadora
	 *     for true; ou VPB = VPA, caso contr�rio.
	 * (C) Calcula-se VPC = VPB - bonus/10.
	 * (D) Calcula-se valor do pr�mio = VPC, se VPC > 0; ou valor do pr�mio = 0, se 
	 *     VPC <=0.  
	 *      
	 * O valor da franquia � igual a 130% do VPB.
	 * 
	 * Ap�s validar a nulidade de dados e da placa, fazer a busca do ve�culo por placa.
	 * Se o ve�culo n�o existir, realizar todas as valia��es pertinentes
	 * Se o ve�culo existir, realizar as valida��es de cpf/cnpj e de valor m�ximo, e a verifica��o
	 * de ap�lice j� existente (busca de ap�lice por n�mero).
	 * 
	 * ASSOCIA��O DE VEICULO COM SEGURADOS: buscar segurado empresa por CNPJ OU segura pessoa por CPF. 
	 * Se n�o for encontrado, retornar mensagem de erro, Se for encontrado, associar ao ve�culo. 
	 * 
	 * Se o ve�culo n�o existir (busca no dao de ve�culos por placa), ele deve ser inclu�do 
	 * no dao de ve�culos com as informa��es recebidas em dados
	 * Se o ve�culo existir, (busca no dao de ve�culos por placa), ele deve ser alterado no 
	 * dao de ve�culos, mudando-se apenas os segurado empresa e segurado pessoa, cujo cpf ou 
	 * cnpj foi recebido em dados. Estes devem ser atualizados em ve�culo ap�s valida��es
	 * de cpf/cnpj e busca deles a partir dos mediators de segurado empresa e de segurado
	 * pessoa.
	 * 
	 * Ap�s todos os dados validados, e o ve�culo inclu�do ou alterado, deve-se instanciar
	 * um objeto do tipo Apolice, e inclu�-lo no dao de apolice.
	 * 
	 * Ap�s a inclus�o bem sucedida da ap�lice, deve-se bonficar o segurado, se for o caso. 
	 * O segurado, pessoa ou empresa, a depender do cpf ou do cnpj recebido em dados, vai 
	 * ter direito a cr�dito no b�nus se seu cpf ou cnpj n�o tiver tido sinistro cadastrado
	 * no ano anterior � data de in�cio de vig�ncia da ap�lice. 
	 * Para inferir isto, deve-se usar um novo m�todo, a ser criado no SinistroDAO, 
	 * public Sinistro[] buscarTodos() e, com o resultado, verificar se existe pelos menos
	 * um sinistro cujo ve�culo est� associado ao cpf ou ao cnpj do segurado da ap�lice, 
	 * e o ano da data e hora do sinistro seja igual � data de in�cio de vig�ncia da ap�lice 
	 * menos um. Se existir, n�o haver� b�nus. Caso contr�rio, deve-se acrescer 30% do valor do
	 * pr�mio da ap�lice ao b�nus do segurado pessoa ou segurado empresa, e finalmente alterar o 
	 * segurado pessoa ou segurado empresa no seu respectivo DAO.
	 * 
	 * OBS: TODOS os atributos do tipo BigDecimal devem ser gravados com 02 casas decimais (usar
	 * o m�todo setScale). Se isto n�o ocorrer, alguns testes v�o quebrar.
	 */
	public RetornoInclusaoApolice incluirApolice(DadosVeiculo dados) {
		return null;
	}
	/*
	 * Ver os testes test19 e test20
	 */
	public Apolice buscarApolice(String numero) {
		return null;
	}
	/*
	 * A exclus�o n�o � permitida quando: 
	 * 1- O n�mero for nulo ou branco.
	 * 2- N�o existir ap�lice com o n�mero recebido.
	 * 3- Existir sinistro cadastrado no mesmo ano 
	 *    da ap�lice (comparar ano da data e hora do sinistro
	 *    com ano da data de in�cio de vig�ncia da ap�lice) 
	 *    para o mesmo ve�culo (comparar o ve�culo do sinistro
	 *    com o ve�culo da ap�lice usando equals na classe ve�culo,
	 *    que deve ser implementado). Para obter os sinistros 
	 *    cadastrados, usar o m�todo buscarTodos do dao de sinistro, 
	 *    implementado para contempar a quest�o da bonifica��o 
	 *    no m�todo de incluir ap�lice.
	 *    � poss�vel usar LOMBOK para implementa��o implicita do
	 *    equals na classe Veiculo.
	 */
	public String excluirApolice(String numero) {
		return null;
	}
	/*
	 * Daqui para baixo est�o SUGEST�ES de m�todos que propiciariam
	 * mais reuso e organiza��o de c�digo.
	 * Eles poderiam ser chamados pelo m�todo de inclus�o de ap�lice.
	 * Mas...� apenas uma sugest�o. Voc�s podem fazer o c�digo da 
	 * maneira que acharem pertinente. 
	 */
	private String validarTodosDadosVeiculo(DadosVeiculo dados) {
		return null;
	}
	private String validarCpfCnpjValorMaximo(DadosVeiculo dados) {
		return null;
	}
	private BigDecimal obterValorMaximoPermitido(int ano, int codigoCat) {
		return null;
	}
}
