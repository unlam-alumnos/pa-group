package model.elementales;

import model.Ordenadora;

public class Insercion extends Ordenadora {
	
    @Override
    public void ordenar(Comparable[] elementos) {
        int tam = elementos.length;
        for (int i = 0; i < tam; i++) {
            for (int j = i; j > 0 && elementos[j].compareTo(elementos[j - 1]) < 0; j--) {
                intercambiar(elementos, j, j - 1);
            }
        }
    }
    
    public void ordenarConCentinela(Comparable[] elementos){
    	int tam = elementos.length;
    	for (int i = tam - 1; i > 0; i--) {
    		if (elementos[i].compareTo(elementos[i - 1]) < 0) {
    			intercambiar(elementos, i, i - 1);
    		}
    	}
    	for (int i = 2; i < tam; i++) {
    		for (int j = i; elementos[j].compareTo(elementos[j - 1]) < 0; j--) {
    			intercambiar(elementos, j, j - 1);
    		}
    	}
    }
}