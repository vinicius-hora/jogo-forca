package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;


public class MemoriaJogadorRepository implements JogadorRepository {
	
	public static MemoriaJogadorRepository soleInstance = null;
	
	private List<Jogador> pool;
	
	public static MemoriaJogadorRepository getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new MemoriaJogadorRepository();
		}
		return soleInstance;
	}
	
	private MemoriaJogadorRepository() {
		pool = new ArrayList<Jogador>();
	}
	
	
	@Override
	public long getProximoId() {
		int contador = pool.size() + 1;
		return contador;
	}
	
	
	
	@Override
	public Jogador getPorId(Long id) {
		for(Jogador jogadorTemp: pool) {
			if(jogadorTemp.getId() == id) {
				return jogadorTemp;
			}
		}
		throw new RuntimeException("Jogador não encontrado pelo id: " + id);
	}
	
	
	@Override
	public Jogador getPorNome(String nome) {
		for(Jogador jogadorTemp: pool) {
			if(jogadorTemp.getNome() == nome) {
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
	private void remover(Jogador jogador) throws RepositoryException {
		if(pool.contains(jogador)) {
			pool.remove(jogador);
		}
		else {
			throw new RepositoryException(jogador +" não encontrado");
			
		}
		
	}
	
	
	

}
