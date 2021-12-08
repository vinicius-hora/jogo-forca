package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface JogadorRepository extends Repository {

	Jogador getPorId(Long id);

	Jogador getPorNome(String nome);
	
	void inserir(Jogador jogador) throws RepositoryException;

	void atualizar(Jogador jogador) throws RepositoryException;
	
	void remover(Jogador jogador) throws RepositoryException;

	

}
