package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {
	
	private static JogadorFactory soleInstance = null;
	
	public static void createSoleInstance(JogadorRepository jogadorRepository) {
		soleInstance = new JogadorFactoryImpl(jogadorRepository);
	}
	
	public static JogadorFactory getSoleInstance() {
		if(soleInstance == null) {
			 throw new RuntimeException(" jogador não inicializado");
		}
		else {
			return soleInstance;
		}
	}
	
	private JogadorFactoryImpl(JogadorRepository jogadorRepository) {
		super(jogadorRepository);
		// TODO Auto-generated constructor stub
	}
	
	private JogadorRepository getJogadorRepository() {
		return (JogadorRepository) getRepository();
	}
	

	@Override
	public Jogador getJogador(String nome) {
		
		Jogador jogador = new Jogador(null, nome);
		Jogador.Criar(getProximoId(), nome);
		try {
			getJogadorRepository().inserir(jogador);
		} catch ( RepositoryException repositoryException) {
			throw new RuntimeException ("Ocorreu um erro ao tentar salvar o jogador");
			
		}
		
		return jogador;
	}

}
