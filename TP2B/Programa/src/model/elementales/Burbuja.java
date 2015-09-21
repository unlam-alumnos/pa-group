package model.elementales;

import model.Ordenadora;

public class Burbuja extends Ordenadora {
	
    @Override
    public void ordenar(Comparable[] elementos) {
        int tam = elementos.length;
        for (int i = 0; i < (tam - 1); i++) {
            for (int j = 0; j < tam - i - 1; j++) {
                if (elementos[j].compareTo(elementos[j + 1]) > 0) {
                	intercambiar(elementos, j, j + 1);
                }
            }
        }
    }
}