package model.noelementales;

import model.Ordenadora;

public class Shell extends Ordenadora{
	
	@Override
	public void ordenar(Comparable[] elementos){
		int tam = elementos.length;
		int h = 1;
        
		// Defino el H a utilizar H = Hi - 1 * 3 + 1 --> 1, 4, 13, 40, 121, 364, 1093, ... 
        while (h < tam/3) {
        	h = 3*h + 1; 
        }

        while (h >= 1) {
        	for (int i = h; i < tam; i++) {
                for (int j = i; j >= h && menor(elementos[j], elementos[j-h]); j -= h) {
                    intercambiar(elementos, j, j-h);
                }
            }            
            h /= 3;
        }
	}

}
