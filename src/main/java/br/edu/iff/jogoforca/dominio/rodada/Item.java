package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Item extends ObjetoDominioImpl {
	
	

	private List<Boolean> posicoesDescobertas;
	
	private String palavraArriscada = null;
	
	private Palavra palavra;
	
	//set e get
	public List<Boolean> getPosicoesDescobertas() {
		return posicoesDescobertas;
	}

	public void setPosicoesDescobertas(List<Boolean> posicoesDescobertas) {
		this.posicoesDescobertas = posicoesDescobertas;
	}

	public String getPalavraArriscada() {
		return palavraArriscada;
	}

	public void setPalavraArriscada(String palavraArriscada) {
		this.palavraArriscada = palavraArriscada;
	}
	
	// construtores
	public static Item criar(int id, Palavra palavra) {
		Item item = new Item(id, palavra);
		return item;
		
	}
	
	public static Item reconstruir(int id, Palavra palavra, List<Integer> posicoesDescobertas, String palavraArriscada) {
		Item item = new Item(id, palavra, posicoesDescobertas, palavraArriscada);
		return item;
	}

	private Item(int id, Palavra palavra) {
		super(Long.valueOf(id));
		this.palavra = palavra;
		this.posicoesDescobertas = new ArrayList<>(palavra.getTamanho());
		for(int contador = 0; contador < palavra.getTamanho(); contador++) {
			this.posicoesDescobertas.add(false);
		}
		
	}

	private Item(int id, Palavra palavra, List<Integer> posicoesDescobertas, String palavraArriscada) {
		super(Long.valueOf(id));
		this.palavra = palavra;
		this.palavraArriscada = palavraArriscada;
		this.posicoesDescobertas = new ArrayList<>(palavra.getTamanho());
		for(Integer temp: posicoesDescobertas) {
			this.posicoesDescobertas.add(temp,true);
		}
	}
	//metodos
	public Palavra getPalavra() {
		return this.palavra;
	}
	
	public List<Letra> getLetraDescoberta() {
		List<Letra> descobertas = new ArrayList<>();
		for(int contador = 0; contador < posicoesDescobertas.size(); contador++) {
			if(posicoesDescobertas.get(contador)) {
				descobertas.add(palavra.getLetra(contador));
			}
		}
		
		return descobertas;
	}
	
	public List<Letra> getLetraEncoberta() {
		List<Letra> cobertas = new ArrayList<Letra>();
		for(int contador = 0; contador < posicoesDescobertas.size(); contador++) {
			if(!posicoesDescobertas.get(contador)) {
				cobertas.add(palavra.getLetra(contador));
			}
		}
		
		return cobertas;
	}
	
	public int qtdeLetrasEncobertas() {
		return getLetraEncoberta().size();
	}
	
	public int calcularPontosLetrasEncobertas(int valorPorLentraEncoberta) {
		return qtdeLetrasEncobertas() * valorPorLentraEncoberta;
	}
	
	public boolean descobriu() {
		return acertou() || qtdeLetrasEncobertas() == 0;
		
		
	}
	
	public void exibir(Object object) {
		palavra.exibir(object, posicoesDescobertas);
		
	}
	
	Boolean tentar(char codigo) {
		List<Integer> posicoes = palavra.tentar(codigo);
		
		if(posicoes.size() == 0) {
			return false;
		}
		for(Integer posicaoTemp: posicoes) {
			posicoesDescobertas.set(posicaoTemp, true);
		}
		
		return true;
	}
	
	public void arriscar(String palavra) {
		this.palavraArriscada = palavra;
		
	}
	
	public boolean arriscou() {
		return palavraArriscada != null;
	}
	
	public boolean acertou() {
		 return arriscou() ? palavra.comparar(palavraArriscada) : false;
		
	}
}
