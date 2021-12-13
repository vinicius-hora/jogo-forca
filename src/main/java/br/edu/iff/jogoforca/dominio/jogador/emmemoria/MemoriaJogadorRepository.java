package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;


public class MemoriaJogadorRepository implements JogadorRepository {
	
	private static MemoriaJogadorRepository soleInstance = null;
	
	private List<Jogador> pool;
	
	public static MemoriaJogadorRepository getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new MemoriaJogadorRepository();
		}
		return soleInstance;
	}
	
	private MemoriaJogadorRepository() {
		pool = new ArrayList<>();
	}
	
	
	 @Override
	  public long getProximoId() {
	    return pool.size() + 1;
	  }
	
	
	@Override
	public Jogador getPorId(Long id) {
		for(Jogador jogadorTemp: pool) {
			if(jogadorTemp.getId().equals(id)) {
				return jogadorTemp;
			}
		}
		throw new RuntimeException("Jogador não encontrado pelo id: " + id);
	}
	
	
	@Override
	public Jogador getPorNome(String nome) {
		for(Jogador jogadorTemp: pool) {
			if(jogadorTemp.getNome().equals(nome)) {
				return jogadorTemp;
			}
		}
		
		throw new RuntimeException("Jogador não encontrado pelo nome: " + nome);
	}
	
	
	@Override
	public void inserir( Jogador jogador) throws RepositoryException {
		if(pool.contains(jogador)) {
			throw new RepositoryException("Jogador já existe");
		}
		else {
			pool.add(jogador);
		}
	}
	
	@Override
	public void atualizar(Jogador jogador) throws RepositoryException{
		this.remover(jogador);
		this.inserir(jogador);
	}
	
	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		if(pool.contains(jogador)) {
			pool.remove(jogador);
		}
		else {
			throw new RepositoryException(jogador +" não encontrado");
			
		}
		
	}
	
	
	

}
