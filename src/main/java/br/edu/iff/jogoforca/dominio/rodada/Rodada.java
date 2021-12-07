package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends ObjetoDominioImpl {
	
	

	

	private int maxPalavras = 3;
	
	private int maxErros = 10;
	
	private int pontosQuandoDescobreTodasAsPalavras  = 100;
	
	private int pontosPorLetraEncoberta = 15;

	public int getMaxPalavras() {
		return maxPalavras;
	}

	public void setMaxPalavras(int maxPalavras) {
		this.maxPalavras = maxPalavras;
	}

	public int getMaxErros() {
		return maxErros;
	}

	public void setMaxErros(int maxErros) {
		this.maxErros = maxErros;
	}

	public int getPontosQuandoDescobreTodasAsPalavras() {
		return pontosQuandoDescobreTodasAsPalavras;
	}

	public void setPontosQuandoDescobreTodasAsPalavras(int pontosQuandoDescobreTodasAsPalavras) {
		this.pontosQuandoDescobreTodasAsPalavras = pontosQuandoDescobreTodasAsPalavras;
	}

	public int getPontosPorLetraEncoberta() {
		return pontosPorLetraEncoberta;
	}

	public void setPontosPorLetraEncoberta(int pontosPorLetraEncoberta) {
		this.pontosPorLetraEncoberta = pontosPorLetraEncoberta;
	}
	
	// construtor
	private Rodada (Long id, Item[] itens, Letra[] erradas, Jogador jogador) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private Rodada(Long id, Palavra[] palavra, Jogador jogador) {
		super(id);
		
	}
	//metodos
	public Rodada criar(Long id, Palavra palavra[], Jogador jogador){
		Rodada rodada = new Rodada(id, palavra, jogador);
		return rodada;
		
	}
	
	public Rodada recostruir(Long id, Item[] itens, Letra[] erradas, Jogador jogador) {
		Rodada rodada = new Rodada(id, itens, erradas, jogador);
		return rodada;
	}
	
	
	public Jogador getJogador() {
		return null;
		
	}
	
	public Tema getTema() {
		return null;
	}
	
	public Palavra[] getPalavras() {
		return null;
		
	}
	
	public int getNumPalavras() {
		return 0;
	}
	
	public void tentar(char codigo) {
		System.out.println(codigo);
	}
	
	public void arriscar(String[] palavras) {
		System.out.println(palavras);
	}
	
	public void exibirItens(Object object) {
		
	}
	
	public void exibirBoneco(Object object) {
		
	}
	
	public void exibirPalavras(Object object) {
		
	}
	
	public void exibirLetraserradas(Object object) {
		
	}
	
	public Letra[] getTentativas() {
		return null;
	}
	
	public Letra[] getCertas() {
		return null;
	}
	
	public Letra[] getErradas() {
		return null;
	}
	
	public int calcularPontos() {
		return 0;
	}
	
	public Boolean encerrou() {
		return null;
	}
	
	public Boolean descobriu() {
		return null;
	}
	
	public Boolean arriscou() {
		return null;
	}
	
	public int getQtdeTentativasRestantes() {
		return 0;
	}
	
	public int getQtdeErros() {
		return 0;
	}
	
	public int getQtdeAcertos() {
		return 0;
	}
	
	public int getQtdeTentativas() {
		return 0;
	}

}
