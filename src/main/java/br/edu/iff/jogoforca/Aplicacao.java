package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactoryImpl;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
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
	
	private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[1];
	
	private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO_FACTORY[1];
	
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
	
	
	public String[] getTipoRodadaFactory() {
		return TIPOS_RODADA_FACTORY;
	}



	public void setTipoRodadaFactory(String tipoRF) {
		tipoRodadaFactory = tipoRF;
		setup();
	}



	public String[] getTipoRepositoryFactory() {
		return TIPOS_REPOSITORY_FACTORY;
	}



	public void setTipoRepositoryFactory(String tipoRF) {
		tipoRepositoryFactory = tipoRF;
		setup();
	}



	public String[] getTipoElementoGraficoFactory() {
		return TIPOS_ELEMENTO_GRAFICO_FACTORY;
	}



	public void setTipoElementoGraficoFactory(String tipoEF) {
		tipoElementoGraficoFactory = tipoEF;
		setup();
	}



	public RepositoryFactory getRepositoryFactory() {
		return repositoryFactory;
	}

	public ElementoGraficoFactory getElementoGraficoFactory() {
		return elementoGraficoFactory;
	}

	public RodadaFactory getRodadaFactory() {
		return rodadaFactory;
	}
	
	public TemaFactory getTemaFactory() {
		return TemaFactoryImpl.getSoleInstance();
	}
	
	public PalavraFactory getPalavraFactory() {
		return PalavraFactoryImpl.getSoleInstance();
	}
	
	public JogadorFactory getJogadorFactory(){
		return JogadorFactoryImpl.getSoleInstance();
	}
	
	

	//construtor
	private Aplicacao() {
		setup();
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
			RodadaSorteioFactory.createSoleInstance(repositoryFactory.getRodadaRepository(), repositoryFactory.getTemaRepository(), repositoryFactory.getPalavraRepository());
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
		Palavra.setLetraFactory(elementoGraficoFactory);
		Rodada.setBonecoFactory(elementoGraficoFactory);
		
	}
	
	
	
	
	

}
