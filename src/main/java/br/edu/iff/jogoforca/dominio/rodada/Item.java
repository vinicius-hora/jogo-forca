package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Item extends ObjetoDominioImpl {
	
	

	private Boolean posicoesDescobertas = null;
	
	private String palavraArriscada = null;
	
	//set e get
	public Boolean getPosicoesDescobertas() {
		return posicoesDescobertas;
	}

	public void setPosicoesDescobertas(Boolean posicoesDescobertas) {
		this.posicoesDescobertas = posicoesDescobertas;
	}

	public String getPalavraArriscada() {
		return palavraArriscada;
	}

	public void setPalavraArriscada(String palavraArriscada) {
		this.palavraArriscada = palavraArriscada;
	}
	
	// construtores
	private Item criar(Long id, Palavra palavra) {
		Item item = new Item(id, palavra);
		return item;
		
	}
	
	public Item reconstruir(Long id, Palavra palavra, int posicoesDescobertas, String palavraArriscada) {
		Item item = new Item(id, palavra, posicoesDescobertas, palavraArriscada);
		return item;
	}

	private Item(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private Item(Long id, Palavra palavra) {
		super(id);
	}
	
	private Item(Long id, Palavra palavra, int posicoesDescobertas, String palavraArriscada) {
		super(id);
	}
	//metodos
	public Palavra getPalavra() {
		return null;
	}
	
	public Letra[] getLetraDescoberta() {
		return null;
	}
	
	public Letra[] getLetraEncoberta() {
		return null;
	}
	
	public int qtdeLetrasEncobertas() {
		return 0;
	}
	
	public int calcularPontosLetrasEncobertas(int valorPorLentraEncoberta) {
		return 0;
	}
	
	public Boolean descobriu() {
		return null;
	}
	
	public void exibir(Object object) {
		
	}
	
	public Boolean tentar(char codigo) {
		return null;
	}
	
	public void arriscar(String palavra) {
		
	}
	
	public Boolean arriscou() {
		return null;
	}
	
	public Boolean Acertou() {
		return null;
	}
}
