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
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			
		}
		
		if (partes == 2) {
			
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
					
		}
		
		if (partes == 3) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
		}
		
		if (partes == 4) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
		}
		
		
		if (partes == 5) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
			System.out.println("|                        boca");
		}
		
		if (partes == 6) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
			System.out.println("|                        boca");
			System.out.println("|                      tronco");
		}
		
		if (partes == 7) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
			System.out.println("|                        boca");
			System.out.println("|                      tronco");
			System.out.println("|               braço direito");
					
		}
		
		if (partes == 8) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
			System.out.println("|                        boca");
			System.out.println("|                      tronco");
			System.out.println("|               braço direito");
			System.out.println("|               braço esquerdo");
		}
		
		if (partes == 9) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
			System.out.println("|                        boca");
			System.out.println("|                      tronco");
			System.out.println("|               braço direito");
			System.out.println("|               braço esquerdo");
			System.out.println("|               perna direita");
		}
		
		if (partes == 10) {
			System.out.println("------------------------");
			System.out.println("|----------------------|");
			System.out.println("|----------------------|");
			System.out.println("|                      cabeca");
			System.out.println("|                olho direito");
			System.out.println("|               olho esquerdo");
			System.out.println("|                       nariz");
			System.out.println("|                        boca");
			System.out.println("|                      tronco");
			System.out.println("|               braço direito");
			System.out.println("|               braço esquerdo");
			System.out.println("|               perna direita");
			System.out.println("|               perna esquerda");
		}
	}


	

	
	
	
	
}
