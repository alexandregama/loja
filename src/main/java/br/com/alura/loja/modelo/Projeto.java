package br.com.alura.loja.modelo;

public class Projeto {

	private int id;
	
	private String nome;
	
	private int anoDeInicio;

	public Projeto(int id, String nome, int anoDeInicio) {
		this.id = id;
		this.nome = nome;
		this.anoDeInicio = anoDeInicio;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	
}
