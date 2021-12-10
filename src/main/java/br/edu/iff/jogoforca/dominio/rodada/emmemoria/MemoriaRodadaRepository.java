package br.edu.iff.jogoforca.dominio.rodada.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.palavra.emmemoria.MemoriaPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.bancodepalavras.dominio.tema.emmemoria.MemoriaTemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.jogador.emmemoria.MemoriaJogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.emmemoria.MemoriaRepositoryFactory;
import br.edu.iff.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {
	
	private static MemoriaRepositoryFactory soleInstance = null;
	private List<Rodada> pool;
	
	//get set
	public static MemoriaRepositoryFactory getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new MemoriaRepositoryFactory();
		}
		
		return soleInstance;
	}
	
	
	@Override
	public long getProximoId() {
		int id = pool.size() +1;
		return id;
	}
	
	@Override
	public Rodada getPorId(Long id) {
		for(Rodada rodadaTemp: pool) {
			if(rodadaTemp.getId().equals(id)) {
				return rodadaTemp;
			}
		}
		throw new RuntimeException("Nenhuma rodada encontrada com esse ID: " + id);
	}
	
	@Override
	public List<Rodada> getPorJogador(Jogador jogador){
		List<Rodada> rodadasListTEmp = new ArrayList<Rodada>();
		
		for(Rodada rodadaTEmp: pool) {
			if(rodadaTEmp.getJogador() == jogador) {
				rodadasListTEmp.add(rodadaTEmp);
			}
		}
		
		return rodadasListTEmp;
	}
	//construtores
	private  MemoriaRodadaRepository() {
		pool = new ArrayList<Rodada>();
	}
	
	//metodos
	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		if(pool.contains(rodada)) {
			throw new RepositoryException("rodada j� salva");
		}
		
		pool.add(rodada);
		
	}

	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		if(pool.contains(rodada)) {
			pool.remove(rodada);
		} else {
			throw new RepositoryException("rodada n�o localizada, rodada: " + rodada);
			}
		}
		
		
	
	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		this.remover(rodada);
		this.atualizar(rodada);
		
	}

	

}
