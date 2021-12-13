package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Palavra extends ObjetoDominioImpl {
	
	

	private static LetraFactory letraFactory;
	
	private List<Letra> palavras;
	
	private Tema tema;

	public static LetraFactory getLetraFactory() {
		return letraFactory;
	}

	public static void setLetraFactory(LetraFactory factory) {
		letraFactory = factory;
	}
	
	public List<Letra> getPalavras() {
		return Collections.unmodifiableList(this.palavras);
	}

	public Tema getTema() {
		return this.tema;
	}
	//construtor
	private Palavra(Long id, String palavra, Tema tema) {
		super(id);
		LetraFactory letraFactory = getLetraFactory();
		if(letraFactory == null) {
			throw new RuntimeException("Letra não iniciada");
			
		}
		this.tema = tema;
		this.palavras = new ArrayList<>();
		for(int contador = 0; contador < palavra.length(); contador++ ) {
			this.palavras.add(letraFactory.getLetra(palavra.charAt(contador)));
		}
	}
	
	public static Palavra criar(Long id, String palavra, Tema tema) {
		Palavra criarPalavra = new Palavra(id, palavra, tema);
		return criarPalavra;
	}
	
	public static Palavra reconstruir(Long id, String palavra, Tema tema) {
		Palavra criarPalavra = new Palavra(id, palavra, tema);
		return criarPalavra;
	}
	
	public List<Letra> getLetras(){
		return Collections.unmodifiableList(this.palavras);
	}
	
	public Letra getLetra(int posicao) {
		return this.palavras.get(posicao);
		
	}
	
	public void exibir(Object object) {
		for(Letra letraTemp: palavras) {
			letraTemp.exibir(null);
		}
	}
	
	public void exibir(Object object, List<Boolean> posicoes) {
		if(posicoes.size() != palavras.size()) {
			throw new RuntimeException("Ocorreu um erro na exibição da palavra");
			
		}
		LetraFactory letraFactory = getLetraFactory();
		Letra letraEncoberta = letraFactory.getLetraEncoberta();
		
		for(int contador = 0; contador < palavras.size(); contador++) {
			if(posicoes.get(contador)) {
				palavras.get(contador).exibir(null);
			}else {
				letraEncoberta.exibir(null);
			}
		}
	}
	
	public List<Integer> tentar(char codigo){
		List<Integer> posicoesEncotradas = new ArrayList<>();
		for(int contador = 0; contador < palavras.size(); contador++) {
			if(palavras.get(contador).equals(codigo)) {
				posicoesEncotradas.add(contador);
			}
		}
		return posicoesEncotradas;
	}
	
	public boolean comparar(String palavra) {
		for(int contador = 0; contador < this.palavras.size(); contador++) {
			if(this.palavras.get(contador).getCodigo() != palavra.charAt(contador)) {
				return false;
			}
		}
		
		return true;
	}
	
	public int getTamanho() {
		return this.palavras.size();
	}

	@Override
	public String toString() {
		return "Palavra [palavras=" + palavras + ", tema=" + tema + "]";
	}
	
	
	
	
	
	
	
	

	

}
