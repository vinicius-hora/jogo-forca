package br.edu.iff.jogoforca.dominio.boneco.texto;

import javax.management.ObjectInstance;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto<SoleInstance> implements Boneco {
	
	private SoleInstance  soleInstance;

	public SoleInstance getSoleInstance() {
		return soleInstance;
	}

	private BonecoTexto(SoleInstance soleInstance) {
		
		this.soleInstance = soleInstance;
	}
	
	public void Exibir(Object object, int partes) {
		if (partes == 1) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                       ");
			System.out.println("|                       ");
			System.out.println("|                       ");
			
		}
		
		if (partes == 2) {
			
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                      O");
			System.out.println("|                       ");
			System.out.println("|                       ");
					
		}
		
		if (partes == 3) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                      O");
			System.out.println("|                      |");
			System.out.println("|                       ");
		}
		
		if (partes == 4) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                      O");
			System.out.println("|                      |\\");
			System.out.println("|                       ");
		}
		
		
		if (partes == 5) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                      O");
			System.out.println("|                     /|\\");
			System.out.println("|                       ");
		}
		
		if (partes == 6) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                      O");
			System.out.println("|                     /|\\");
			System.out.println("|                       \\ ");
			
		}
		
		if (partes == 7) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|                      O");
			System.out.println("|                     /|\\");
			System.out.println("|                     / \\");
					
		}
		
		if (partes == 8) {
			
		}
		
		if (partes == 9) {
			
		}
		
		if (partes == 10) {
			
		}
	}
	
	
	
	
	
	
	
}
