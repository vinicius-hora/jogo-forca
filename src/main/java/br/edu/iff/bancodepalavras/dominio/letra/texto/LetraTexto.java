package br.edu.iff.bancodepalavras.dominio.letra.texto;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra {
	
	

	protected LetraTexto(char codigo) {
		super(codigo);
		
	}
	
	@Override
	public void exibir(Object object) {
		System.out.print(this.getCodigo());
	}

	
	
	

}
