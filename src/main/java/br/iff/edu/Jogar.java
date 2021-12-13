package br.iff.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;

public class Jogar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Aplicacao aplicacao = Aplicacao.getSoleInstance();
		int escolha = 0 ;
		
		JogadorFactory jogadorFactory = aplicacao.getJogadorFactory();
		TemaFactory temaFactory = aplicacao.getTemaFactory();
		RodadaFactory rodadaFactory = aplicacao.getRodadaFactory();
		
		//cadastro de tema
		Tema temaNomes = temaFactory.getTema("Nome de Pessoas");
		PalavraFactory palavraNomesFactory = aplicacao.getPalavraFactory();
		palavraNomesFactory.getPalavra("vinicius", temaNomes);
		palavraNomesFactory.getPalavra("gerson", temaNomes);
		palavraNomesFactory.getPalavra("brendo", temaNomes);
		palavraNomesFactory.getPalavra("lucas", temaNomes);
		
		Tema temaPaisCidade = temaFactory.getTema("Nome de Pises e Cidades");
		PalavraFactory palavraPaisCidadeFactory = aplicacao.getPalavraFactory();
		palavraPaisCidadeFactory.getPalavra("brasil", temaPaisCidade);
		palavraPaisCidadeFactory.getPalavra("franca", temaPaisCidade);
		palavraPaisCidadeFactory.getPalavra("argentina", temaPaisCidade);
		palavraPaisCidadeFactory.getPalavra("salvador", temaPaisCidade);
		palavraPaisCidadeFactory.getPalavra("paris", temaPaisCidade);
		palavraPaisCidadeFactory.getPalavra("buenosaires", temaPaisCidade);
		
		//PalavraFactory palavraUsuarioFactory = aplicacao.getPalavraFactory();
		
		do {
			System.out.println("MENU DO JOGO");
			System.out.println("1 - jogar");
			System.out.println("0 - sair");
			System.out.println("digite uma opção: ");
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				System.out.println("Entre com o nome: ");
				System.out.println();
				String nomeJogador = sc.next();
				Jogador jogador = jogadorFactory.getJogador(nomeJogador);
				Rodada rodada = rodadaFactory.getRodada(jogador);
				jogar(rodada, jogador);
				
				break;

			default:
				break;
			}
			
		}while(escolha!= 0);
		
		sc.close();
		
		
		
		

	}
	private static void jogar(Rodada rodada, Jogador jogador) {
		Scanner sc = new Scanner(System.in);
		
		while(rodada.encerrou() != false) {
			System.out.println("Tema: " + rodada.getTema().getNome());
			System.out.println("Jogador: " + jogador.getNome());
			
			System.out.println("Numero de tentativas: ");
			for(Letra letraTentativa: rodada.getTentativas()) {
				letraTentativa.exibir(null);
				System.out.println("");
			}
			System.out.println();
            
            System.out.println("Palavras:");
            rodada.exibirItens(null);
            System.out.println();
            System.out.println("Erros: " + rodada.getQtdeErros() + "/" + Rodada.getMaxErros());
            System.out.println("Corpo: ");
            rodada.exibirBoneco(null);
            System.out.println();

            System.out.println("Selecione a opção desejada: ");
            System.out.println("(1) Digitar uma letra");
            System.out.println("(2) Já sabe todas as palavras? Arriscar");

            String escolha = sc.next();
            
            if (escolha.equalsIgnoreCase("1")) {
                System.out.print("Digite uma letra: ");
                char codigo = sc.next().charAt(0);

                if (codigo >= 'A' && codigo <= 'Z') {
                    codigo = (char)(codigo+32);
                } 
                
                rodada.tentar(codigo); 

                System.out.println("");
            } else if (escolha.equalsIgnoreCase("2")) {
                List<String> palavras = new ArrayList<>();

                for (int i = 1; i <= rodada.getNumPalavras(); i++) {
                    System.out.println("Qual a " + i + "ª palavra? ");
                    String palavra = sc.next();
                    palavras.add(palavra);
                }

                rodada.arriscar(palavras);
                System.out.println("");
            }
            sc.close();
            
            
        }

        if (rodada.descobriu()) {
            System.out.println("Parabéns, você descobriu todas as palavras!");
            rodada.exibirPalavras(null);
        } else {
            System.out.println("ERROU!! Você não descobriu as palavras.");
        }

        System.out.println("Sua pontuação nessa rodada foi: " + rodada.calcularPontos());
        
		}
	
		
	

}
