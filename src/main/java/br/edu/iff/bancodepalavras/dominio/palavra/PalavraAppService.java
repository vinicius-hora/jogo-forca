package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.repository.RepositoryException;

public class PalavraAppService {
	
	private static PalavraAppService soleInstance;
	
	private PalavraRepository palavraRepository;
	
	private PalavraFactory palavraFactory;
	
	//get
	public static PalavraAppService getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new PalavraAppService(null, null);
		}
		
		return soleInstance;
	}
	//construtor
	private PalavraAppService(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
		this.palavraRepository = palavraRepository;
		this.palavraFactory = palavraFactory;
	}
	//metodos
	private static void createSoleInstance(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
		soleInstance = new PalavraAppService(palavraRepository, palavraFactory);
		
	}
	
	public boolean novaPalavra(String palavra)throws RepositoryException{
		Palavra palavraTemp = palavraRepository.getPalavras(palavra);
		Aplicacao aplicacaoTemp = Aplicacao.getSoleInstance();
		if(palavraTemp == null) {
			TemaFactory temaFactory = aplicacaoTemp.getTemaFactory();
			Tema tema = temaFactory.getTema("Todos");
			Palavra novaPalavraTemp = palavraFactory.getPalavra(palavra, tema);
			try {
				palavraRepository.inserir(novaPalavraTemp);
				return true;
			} catch (RepositoryException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		return true;
		
	}
	
	
	

}












