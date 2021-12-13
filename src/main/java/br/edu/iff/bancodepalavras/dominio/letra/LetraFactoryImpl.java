package br.edu.iff.bancodepalavras.dominio.letra;

public abstract class LetraFactoryImpl {
	
	private Letra[] pool;
	
	private Letra encoberta;
	
	protected LetraFactoryImpl() {
		this.pool = new Letra[26];
		this.encoberta = null;
	}
	
	public final Letra getLetra(char codigo) {
		int i = codigo - 'a';
		Letra result = this.pool[i];
		if(result == null) {
			result = this.criarLetra(codigo);
			this.pool[i] = result;
		}
		return result;
	}

	protected abstract Letra criarLetra(char codigo);
	
	public final Letra getLetraEncoberta() {
		if(encoberta == null) {
			char codigo = '*';
			this.encoberta = criarLetra(codigo);
		}
		return this.encoberta;
	}
	
	
	

}
