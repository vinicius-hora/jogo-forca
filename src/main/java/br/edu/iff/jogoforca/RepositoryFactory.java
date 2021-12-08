package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;

public interface RepositoryFactory {

	PalavraRepository getPalavraRepository();

}
