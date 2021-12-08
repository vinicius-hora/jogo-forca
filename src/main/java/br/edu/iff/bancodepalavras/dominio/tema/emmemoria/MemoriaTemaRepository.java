package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.jogoforca.RepositoryFactory;

public class MemoriaTemaRepository implements RepositoryFactory {
	
	private static MemoriaTemaRepository solInstance = null;
	
	private MemoriaTemaRepository() {
		
	}

	public static MemoriaTemaRepository getSolInstance() {
		if(solInstance == null) {
			solInstance = new MemoriaTemaRepository();
		}
		return solInstance;
	}
	
	
	@Override
	public PalavraRepository getPalavraRepository() {
		return MemoriaTemaRepository.getSolInstance();
	}
	


}
