package model.elementales;

import model.Ordenadora;

public class Seleccion extends Ordenadora {
	
    @Override
    public void ordenar(Comparable[] elementos) {
        int tam = elementos.length;
        for (int i = 0; i < tam; i++) {
            int min = i;
            for (int j = i+1; j < tam; j++) {
                if (menor(elementos[j], elementos[min])) min = j;
            }
            intercambiar(elementos, i, min);
            assert estaOrdenado(elementos, 0, i);
        }
        assert estaOrdenado(elementos);
    }
}