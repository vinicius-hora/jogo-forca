package br.edu.iff.bancodepalavras.dominio.letra;

import java.util.List;

public abstract class Letra {
	
	private char codigo;

	

	public char getCodigo() {
		return codigo;
	}
	
	protected Letra(char codigo) {
		this.codigo = codigo;
	}
	
	
	public abstract void exibir(Object object);

	@Override
	public final String toString() {
		return "Letra" + codigo ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letra other = (Letra) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
}
