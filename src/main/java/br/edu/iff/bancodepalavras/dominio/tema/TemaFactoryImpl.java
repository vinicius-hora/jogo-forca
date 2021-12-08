package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory {

	private static TemaFactory soleInstance = null;
	
	private TemaFactoryImpl(TemaRepository temaRepository) {
		super(temaRepository);
		// TODO Auto-generated constructor stub
	}
	
	private TemaRepository getTemaRepository() {
		
		return (TemaRepository) getRepository();
	}
	
	
	@Override
	public Tema getTema(String nome) {
		Tema temaTemp = Tema.Criar(getProximoId(), nome);
		try {
			getTemaRepository().inserir(temaTemp);
			
		}catch (RepositoryException e) {
			throw new RuntimeException("Erro ao tentar salvar o tema");
		}
		
		return temaTemp;
	}
	
	public static void createSoleInstance(TemaRepository temaRepository) {
		soleInstance = new TemaFactoryImpl(temaRepository);
	}


	public static TemaFactory getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("A fabricação de temas não foi iniciada");
		}
		else {
			return soleInstance;
		}
		
	}
	
	
	
	
	
	
	

}
