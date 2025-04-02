package br.edu.cs.poo.ac.seguro.entidades;

public enum TipoSinistro {
	COLISAO(1,"Colisão"),
	INCENDIO(2,"Incêndio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depredação");
	
	private int codigo;
	private String nome;
	
	private TipoSinistro(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static TipoSinistro getTipoSinistro(int codigo) {
		switch (codigo) {
			case 1:
				return COLISAO;
			case 2:
				return INCENDIO;
			case 3:
				return FURTO;
			case 4:
				return ENCHENTE;
			case 5:
				return DEPREDACAO;
			default:
				throw new IllegalArgumentException("Código inválido: " + codigo);
		}
	}
}