package br.edu.iff.bancodepalavras.dominio.letra.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraImagemFactory  extends LetraFactoryImpl{
	private static LetraImagemFactory soleInstance = null;
	
	public static LetraImagemFactory getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new LetraImagemFactory();
		}
		
		return soleInstance;
	}
	
	private LetraImagemFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Letra criarLetra(char codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
