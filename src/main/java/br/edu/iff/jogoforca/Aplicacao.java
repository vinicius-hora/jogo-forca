package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactoryImpl;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.sorteio.RodadaSorteioFactory;
import br.edu.iff.jogoforca.embdr.BDRRepositoryFactory;
import br.edu.iff.jogoforca.emmemoria.MemoriaRepositoryFactory;
import br.edu.iff.jogoforca.imagem.ElementoGraficoImagemFactory;
import br.edu.iff.jogoforca.texto.ElementoGraficoTextoFactory;

public class Aplicacao {
	
	private final static String[] TIPOS_RODADA_FACTORY = {"sorteio"};
	
	private final static String[] TIPOS_REPOSITORY_FACTORY = {"relacional", "memoria"};
	
	private final static String[] TIPOS_ELEMENTO_GRAFICO_FACTORY = {"imagem", "texto"};
	
	private static Aplicacao soleInstance = null;
	
	private String tipoRodadaFactory = TIPOS_RODADA_FACTORY[0];
	
	private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[0];
	
	private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO_FACTORY[0];
	
	private RepositoryFactory repositoryFactory;
	
	private ElementoGraficoFactory elementoGraficoFactory;
	
	private RodadaFactory rodadaFactory;
	
	//get
	public static Aplicacao getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new Aplicacao();
		}
		
		return soleInstance;
	}
	
	
	public String getTipoRodadaFactory() {
		return tipoRodadaFactory;
	}



	public void setTipoRodadaFactory(String tipoRodadaFactory) {
		this.tipoRodadaFactory = tipoRodadaFactory;
	}



	public String getTipoRepositoryFactory() {
		return tipoRepositoryFactory;
	}



	public void setTipoRepositoryFactory(String tipoRepositoryFactory) {
		this.tipoRepositoryFactory = tipoRepositoryFactory;
	}



	public String getTipoElementoGraficoFactory() {
		return tipoElementoGraficoFactory;
	}



	public void setTipoElementoGraficoFactory(String tipoElementoGraficoFactory) {
		this.tipoElementoGraficoFactory = tipoElementoGraficoFactory;
	}



	public RepositoryFactory getRepositoryFactory() {
		return repositoryFactory;
	}



	public void setRepositoryFactory(RepositoryFactory repositoryFactory) {
		this.repositoryFactory = repositoryFactory;
	}



	public ElementoGraficoFactory getElementoGraficoFactory() {
		return elementoGraficoFactory;
	}



	public void setElementoGraficoFactory(ElementoGraficoFactory elementoGraficoFactory) {
		this.elementoGraficoFactory = elementoGraficoFactory;
	}



	public RodadaFactory getRodadaFactory() {
		return rodadaFactory;
	}



	public void setRodadaFactory(RodadaFactory rodadaFactory) {
		this.rodadaFactory = rodadaFactory;
	}



	//construtor
	private Aplicacao() {
		
	}
	
	//metodos
	// retorna o repositorio escolhido
	public void setup() {
		if(tipoRepositoryFactory.equalsIgnoreCase(TIPOS_REPOSITORY_FACTORY[1])) {
			repositoryFactory = MemoriaRepositoryFactory.getSoleInstance();
		}else if(tipoRepositoryFactory.equalsIgnoreCase(TIPOS_REPOSITORY_FACTORY[0])) {
			repositoryFactory = BDRRepositoryFactory.getSoleInstance();
			
		}
		//retorna a rodada escolhida, obs: somente sorteio
		if(tipoRodadaFactory.equalsIgnoreCase(TIPOS_RODADA_FACTORY[0])) {
			RodadaSorteioFactory.createSoleInstance(repositoryFactory.getPalavraRepository());
			rodadaFactory = RodadaSorteioFactory.getSoleInstance();
		}
		
		//retorna o elemento grafico escolhido
		if(tipoElementoGraficoFactory.equalsIgnoreCase(TIPOS_ELEMENTO_GRAFICO_FACTORY[1])) {
			elementoGraficoFactory = ElementoGraficoTextoFactory.getSoleInstance();
		}else if(tipoElementoGraficoFactory.equalsIgnoreCase(TIPOS_ELEMENTO_GRAFICO_FACTORY[0])) {
			elementoGraficoFactory = ElementoGraficoImagemFactory.getSoleInstance();
			
		}
		//seta os facotres e elementos
		TemaFactoryImpl.createSoleInstance(repositoryFactory.getTemaRepository());
		PalavraFactoryImpl.createSoleInstance(repositoryFactory.getPalavraRepository());
		JogadorFactoryImpl.createSoleInstance(repositoryFactory.getJogadorRepository());
		RodadaFactoryImpl.createSoleInstance(repositoryFactory.getRodadaRepository());
	}
	
	
	

}
