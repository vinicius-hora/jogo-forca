package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {
	
	private static JogadorFactory solInstance = null;
	
	public void CreateSolInstance(JogadorRepository jogadorRepository) {
		solInstance = new JogadorFactoryImpl(jogadorRepository);
	}
	
	public static JogadorFactory getSolInstance() {
		if(solInstance == null) {
			 throw new RuntimeException(" jogador não inicializado");
		}
		else {
			return solInstance;
		}
	}
	
	protected JogadorFactoryImpl(JogadorRepository jogadorRepository) {
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
