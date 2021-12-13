package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {
	
	private static MemoriaTemaRepository soleInstance = null;
	
	private List<Tema> pool;
	
	private MemoriaTemaRepository() {
		pool = new ArrayList<>();
	}

	public static MemoriaTemaRepository getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new MemoriaTemaRepository();
		}
		return soleInstance;
	}
	
	@Override
	public long getProximoId() {
		return pool.size() + 1;
	}
	@Override
	public Tema getPorId(Long id) {
		for(Tema temaTemp: pool) {
			if(temaTemp.getId().equals(id)) {
				return temaTemp;
			}
		}
		throw new RuntimeException("nenhum tema encontrado o ID: " + id);
	}
	
	
	@Override
	public List<Tema> getPorNome(String nome){
		List<Tema> temaList = new ArrayList<>();
		for(Tema temaTemp: pool) {
			//deixa as strings maiuscula para comparação
			String temaUp = temaTemp.getNome().toUpperCase();
			String nomeUp = nome.toUpperCase();
			if(temaUp.contains(nomeUp)) {
				temaList.add(temaTemp);
			}
		}
		
		return temaList;
	}
	
	
	@Override
	public void inserir(Tema tema) throws RepositoryException{
		if(pool.contains(tema)) {
			throw new RepositoryException("O tema já se encontra no repositório, tema: " + tema);
		}
		else {
			pool.add(tema);
		}
	}
	
	
	@Override
	public void remover(Tema tema) throws RepositoryException{
		if(pool.contains(tema)) {
			pool.remove(tema);
		}
		else {
			throw new RepositoryException("O Tema não se encontra no repositório, tema: " + tema);
		}
	}
	
	
	@Override
	public void atualizar(Tema tema) throws RepositoryException{
		this.remover(tema);
		this.inserir(tema);
	}

	@Override
	public List<Tema> getTodos() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(pool);
	}

	
	
	
	
	


}
