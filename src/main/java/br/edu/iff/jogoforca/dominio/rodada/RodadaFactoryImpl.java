package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;

public abstract class RodadaFactoryImpl extends EntityFactory implements RodadaFactory {
	
	

	

	private TemaRepository temaRepository;
	
	private PalavraRepository palavraRepository;
	
	private RodadaRepository rodadaRepository;
	
	//get e set
	protected TemaRepository getTemaRepository() {
		return temaRepository;
	}

	protected PalavraRepository getPalavraRepository() {
		return palavraRepository;
	}
	
	protected RodadaRepository getRodadaRepository() {
		return rodadaRepository;
	}
	
	//construtor
	protected RodadaFactoryImpl(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository);
		this.temaRepository = temaRepository;
		this.palavraRepository = palavraRepository;
	}
	

}
