package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends ObjetoDominioImpl {
	
	

	

	private static int maxPalavras = 1;
	
	private static int maxErros = 10;
	
	private static int pontosQuandoDescobreTodasAsPalavras  = 100;
	
	private static int pontosPorLetraEncoberta = 15;
	
	private static BonecoFactory bonecoFactory = null;
	
	private List<Item> itens;
	
	private Jogador jogador;
	
	private Boneco boneco;
	
	private Set<Letra> letrasCertas;
	
	private Set<Letra> erradas;
	

	public static int getMaxPalavras() {
		return maxPalavras;
	}

	public static void setMaxPalavras(int maxPalavrasTemp) {
		maxPalavras = maxPalavrasTemp;
	}

	public static int getMaxErros() {
		return maxErros;
	}

	public static void setMaxErros(int maxErrosTemp) {
		maxErros = maxErrosTemp;
	}

	public static int getPontosQuandoDescobreTodasAsPalavras() {
		return pontosQuandoDescobreTodasAsPalavras;
	}

	public static void setPontosQuandoDescobreTodasAsPalavras(int pontosQDTP) {
		pontosQuandoDescobreTodasAsPalavras = pontosQDTP;
	}

	public static int getPontosPorLetraEncoberta() {
		return pontosPorLetraEncoberta;
	}

	public static void setPontosPorLetraEncoberta(int pontosPE) {
		pontosPorLetraEncoberta = pontosPE;
	}
	
	public static BonecoFactory getBonecoFactory() {
		return bonecoFactory;
	}

	public static void setBonecoFactory(BonecoFactory bonecoFactory) {
		Rodada.bonecoFactory = bonecoFactory;
	}
	
	// construtor
	private Rodada (Long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
		super(id);
		if(getBonecoFactory() == null) {
			throw new RuntimeException("Boneco não iniciado");
		}
		
		boneco = getBonecoFactory().getBoneco();
		
		this.jogador = jogador;
		this.letrasCertas = new HashSet<Letra>();
		this.erradas = new HashSet<Letra>();
		this.itens = new ArrayList<Item>(itens.size());
		
		for(int contador = 0; contador < itens.size(); contador++) {
			Item itemTemp = itens.get(contador);
			this.itens.add(itemTemp);
			
			for(Letra corretaTemp: itemTemp.getLetraDescoberta()) {
				this.letrasCertas.add(corretaTemp);
			}
		}
		
		for(Letra erradaTemp: erradas ) {
			this.erradas.add(erradaTemp);
		}
	}
	
	

	private Rodada(Long id, List<Palavra> palavras, Jogador jogador) {
		super(id);
		
		if(getBonecoFactory() == null) {
			throw new RuntimeException("Boneco não iniciado");
			
		}
		
		boneco = getBonecoFactory().getBoneco();
		
		this.jogador = jogador;
		this.letrasCertas = new HashSet<Letra>();
		this.erradas = new HashSet<Letra>();
		this.itens = new ArrayList<Item>(palavras.size());
		
		for(int contador = 0; contador < palavras.size(); contador++) {
			this.itens.add(Item.criar(contador, palavras.get(contador)));
		}
		
	}
	//metodos
	public static Rodada criar(Long id, List<Palavra> palavras, Jogador jogador){
		Rodada rodada = new Rodada(id, palavras, jogador);
		return rodada;
		
	}
	
	public static Rodada recostruir(Long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
		Rodada rodada = new Rodada(id, itens, erradas, jogador);
		return rodada;
	}
	
	
	public Jogador getJogador() {
		return this.jogador;
		
	}
	
	public Tema getTema() {
		return this.itens.get(0).getPalavra().getTema();
	}
	
	public List<Palavra> getPalavras() {
		List<Palavra> palavraList = new ArrayList<Palavra>();
		for(Item itemTemp: itens) {
			palavraList.add(itemTemp.getPalavra());
		}
		
		return palavraList;
		
		
	}
	
	public int getNumPalavras() {
		return itens.size();
	}
	
	public void tentar(char codigo) {
		if(encerrou()) {
			return;
		}
		Map<Item, Boolean> itensCertos = new HashMap<Item, Boolean>();
		LetraFactory letraFactory = Palavra.getLetraFactory();
		
		for(Item itemTemp: itens) {
			if(itemTemp.tentar(codigo)) {
				letrasCertas.add(letraFactory.getLetra(codigo));
				itensCertos.put(itemTemp, true);
			}else {
				itensCertos.put(itemTemp, false);
			}
		}
		if(!itensCertos.containsValue(true)) {
			erradas.add(letraFactory.getLetra(codigo));
		}
		if(encerrou()) {
			this.jogador.setPontuacao(this.calcularPontos());
		}
		
	}
	
	public void arriscar(List<String> palavras) {
		if(encerrou()) {
			return;
		}
		
		for(int contador = 0; contador < palavras.size(); contador++) {
			itens.get(contador).arriscar(palavras.get(contador));
		}
		if(encerrou()) {
			this.jogador.setPontuacao(this.calcularPontos());
		}
	}
	
	public void exibirItens(Object object) {
		for(Item itemTemp: itens) {
			itemTemp.exibir(object);
			System.out.println();
		}
		
	}
	
	public void exibirBoneco(Object object) {
		boneco.exibir(object, getQtdeErros());
		
	}
	
	public void exibirPalavras(Object object) {
		for(Palavra palavraTemp: getPalavras()) {
			palavraTemp.exibir(object);
			System.out.println();
		}
		
	}
	
	public void exibirLetraserradas(Object object) {
		
	}
	
	public Set<Letra> getTentativas() {
		Set<Letra> tentativasTemp = new HashSet<Letra>();
		tentativasTemp.addAll(letrasCertas);
		tentativasTemp.addAll(erradas);
		return tentativasTemp;
	}
	
	public Set<Letra> getCertas() {
		Set<Letra> certasTemp = new HashSet<Letra>();
		certasTemp.addAll(letrasCertas);
		return certasTemp;
	}
	
	public Set<Letra> getErradas() {
		Set<Letra> erradasTemp = new HashSet<Letra>();
		erradasTemp.addAll(erradas);
		return erradasTemp;
	}
	
	public int calcularPontos() {
		if(!descobriu()) {
			return 0;
		}
		
		int pontosTemp = getPontosQuandoDescobreTodasAsPalavras();
		for(Item itemTemp: itens) {
			pontosTemp = pontosTemp + itemTemp.calcularPontosLetrasEncobertas(getPontosPorLetraEncoberta());
		}
		return pontosTemp;
		
	}
	
	public Boolean encerrou() {
		if(arriscou()) {
			return true;
		}
		if(descobriu()){
			return true;
		}
		if(getQtdeTentativaRestantes() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean descobriu() {
	    for (Item item: itens) {
	      if (!item.descobriu()) {
	        return false;
	      }
	    }
	      
	    return true;
	  }
		
	public boolean arriscou() {
		for(Item itemTemp: itens) {
			if(!itemTemp.arriscou()) {
				return false;
			}
		}
		return true;
	}
	
	public int getQtdeTentativaRestantes(){
		return getMaxErros() - erradas.size();
	}
	
	public int getQtdeErros() {
		return erradas.size();
	}
	
	public int getQtdeAcertos() {
		return letrasCertas.size();
	}
	
	public int getQtdeTentativas() {
		return getQtdeErros() + getQtdeAcertos();
	}
	
	

}
