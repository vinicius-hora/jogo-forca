package br.edu.iff.jogoforca.dominio.rodada.sorteio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaSorteioFactory extends RodadaFactoryImpl {
	
	private static RodadaSorteioFactory soleInstance = null;
	
	//get e set
	public static RodadaSorteioFactory getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("Sorteio de rodada não iniciado");
		}
		
		return soleInstance;
	}
	// construtores
	private RodadaSorteioFactory(RodadaRepository rodadaRepository, TemaRepository temaRepository,
			PalavraRepository palavraRepository) {
		super(rodadaRepository, temaRepository, palavraRepository);
		// TODO Auto-generated constructor stub
	}

	public static void createSoleInstance (RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		soleInstance = new RodadaSorteioFactory(rodadaRepository, temaRepository, palavraRepository);
	}
	@Override
	public Rodada getRodada(Jogador jogador) {
		// TODO Auto-generated method stub
		Random randomTemp = new Random();
		List<Tema> temasListTotal = getTemaRepository().getTodos();
		Tema temaEscolhido = temasListTotal.get(randomTemp.nextInt(temasListTotal.size()));
		List<Palavra> palavrasPorTema = getPalavraRepository().getPorTema(temaEscolhido);
		int palavrasMaximo = Rodada.getMaxPalavras();
		int palavrasMinimo = 1;
		int totalPalavras = randomTemp.nextInt((palavrasMaximo+1) - palavrasMinimo) + palavrasMinimo;
		List<Palavra> palavrasEscolhidas = new ArrayList<Palavra>();
		Palavra palavraTemp = null;
		
		
		while(palavrasEscolhidas.size() != totalPalavras) {
			palavraTemp = palavrasPorTema.get(randomTemp.nextInt(palavrasPorTema.size()));
			if(!palavrasEscolhidas.contains(palavraTemp) && palavrasEscolhidas.size() !=3) {
				palavrasEscolhidas.add(palavraTemp);
			}
		}
		
		Rodada rodada = Rodada.criar(getProximoId(), palavrasEscolhidas, jogador);
		palavrasEscolhidas.clear();
		try {
			getRodadaRepository().inserir(rodada);
		} catch (RepositoryException e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao tentar salvar a rodada");
		}
		return rodada;
	}
	
	
	//metodos

}
