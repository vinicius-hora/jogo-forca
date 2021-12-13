package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.dominio.ObjetoDominioImpl;

public class Jogador extends ObjetoDominioImpl {

	private String nome;
	
	private int pontuacao;

	
	//get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int putuacao) {
		this.pontuacao = putuacao;
	}
	
	
	public static Jogador criar(Long id, String nome) {
		Jogador jogador = new Jogador(id, nome);
		return jogador;
		
		
	}
	
	public static Jogador recostruir(Long id, String nome, int pontuacao) {
		Jogador jogador = new Jogador(id, nome, pontuacao);
		return jogador;
		
		
	}

	private Jogador(Long id, String nome, int putuacao) {
		super(id);
		this.nome = nome;
		this.pontuacao = putuacao;
	}
	
	private Jogador(Long id, String nome) {
		
		super(id);
		this.nome = nome;
	}
	
	
	
	
	

}
