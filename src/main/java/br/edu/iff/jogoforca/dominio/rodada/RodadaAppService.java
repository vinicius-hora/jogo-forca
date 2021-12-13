package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.JogadorNaoEncontradoException;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaAppService {
	
	private static RodadaAppService soleInstance = null;
	
	private RodadaRepository rodadaRepository;
	
	private RodadaFactory rodadaFactory;
	
	private JogadorRepository jogadorRepository;
	
	
	//construtor
	private RodadaAppService(RodadaRepository rodadaRepository, RodadaFactory rodadaFactory,
			JogadorRepository jogadorRepository) {
		
		this.rodadaRepository = rodadaRepository;
		this.rodadaFactory = rodadaFactory;
		this.jogadorRepository = jogadorRepository;
	}
	//metodos
	public void createSoleInstance(RodadaRepository rodadaRepository, RodadaFactory rodadaFactory,
			JogadorRepository jogadorRepository) {
		
	}
	
	public static RodadaAppService getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new RodadaAppService(null, null, null);
		}
		
		return soleInstance;
	}
	
	public Rodada novaRodada(Long idJogador) throws JogadorNaoEncontradoException{
		
		try {
			Jogador jogador = jogadorRepository.getPorId(idJogador);
			return rodadaFactory.getRodada(jogador);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		throw new JogadorNaoEncontradoException("Jogador não encontrado");
	}
	
	public Rodada novaRodadaNome(String nomeJogador) throws JogadorNaoEncontradoException{
		
		try {
			Jogador jogador = jogadorRepository.getPorNome(nomeJogador);
			return rodadaFactory.getRodada(jogador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		throw new JogadorNaoEncontradoException("Jogador não encontrado");

	}
	
	public Rodada novaRodada(Jogador jogador) {
		try {
			jogadorRepository.inserir(jogador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rodadaFactory.getRodada(jogador);
	}
	
	public boolean salvarRodada(Rodada rodada) throws RepositoryException{
		try {
			rodadaRepository.inserir(rodada);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	
}















