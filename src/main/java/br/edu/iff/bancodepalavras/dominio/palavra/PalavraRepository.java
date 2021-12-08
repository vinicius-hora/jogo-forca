package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface PalavraRepository extends Repository {
	
	 public Palavra getPorId(long id);

	 public void atualizar(Palavra palavra) throws RepositoryException;

	 public void remover(Palavra palavra) throws RepositoryException;

	 public void inserir(Palavra palavra) throws RepositoryException;

	 public Palavra getPalavras(String palavra);

	 public List<Palavra> getTodas();

	 public List<Palavra> getPorTema(Tema tema);

	

}
