package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.dominio.ObjetoDominioImpl;

public class Tema extends ObjetoDominioImpl {
	
	

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private Tema(Long id, String nome) {
		super(id);
		this.nome = nome;
		
	}
	
	public static Tema Criar(Long id, String nome) {
		Tema tema = new Tema(id, nome);
		return tema;
		
	}
	
	public static Tema Recostruir(Long id, String nome) {
		Tema tema = new Tema(id, nome);
		return tema;
		
	}

}
