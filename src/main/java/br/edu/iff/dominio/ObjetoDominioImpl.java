package br.edu.iff.dominio;

public abstract class ObjetoDominioImpl implements ObjetoDominio {
	
	private Long id;

	
	@Override
	public Long getId() {
		return this.id;
	}


	
	public ObjetoDominioImpl(Long id) {
		this.id = id;
	}
	
	
	

}
