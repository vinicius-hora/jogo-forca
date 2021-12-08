package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {
	
	private static BonecoTexto  soleInstance = null;

	public static BonecoTexto getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BonecoTexto();
        }

        return soleInstance;
    }
	
	
	private BonecoTexto() {
		
	}
	
	@Override
	public void exibir(Object object, int partes) {
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
