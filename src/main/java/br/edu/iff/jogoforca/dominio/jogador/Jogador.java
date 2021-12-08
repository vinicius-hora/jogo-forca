package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.dominio.ObjetoDominioImpl;

public class Jogador extends ObjetoDominioImpl {
	

	public Jogador(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private String nome;
	
	private int putuacao = 0;

	
	//get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPutuacao() {
		return putuacao;
	}

	public void setPutuacao(int putuacao) {
		this.putuacao = putuacao;
	}
	
	public static Jogador Criar(Long id, String nome) {
		Jogador jogador = new Jogador(id, nome);
		return jogador;
		
		
	}
	
	public static Jogador Recostruir(Long id, String nome, int pontuacao) {
		Jogador jogador = new Jogador(id, nome, pontuacao);
		return jogador;
		
		
	}

	private Jogador(Long id, String nome, int putuacao) {
		super(id);
		this.nome = nome;
		this.putuacao = putuacao;
	}
	
	public Jogador(Long id, String nome) {
		
		super(id);
		this.nome = nome;
	}
	
	
	
	
	

}
