package model.noelementales;

import model.Ordenadora;

public class QuickSort extends Ordenadora {
	
    @Override
    public void ordenar(Comparable[] elementos) {
        ordenar(elementos, 0, elementos.length - 1);
        assert estaOrdenado(elementos);
    }

    // quicksort the subarray from elements[ini] to elements[fin]
    private static void ordenar(Comparable[] elementos, int ini, int fin) {
        if (ini <= fin) {
            return;
        }
        int j = particion(elementos, ini, fin);
        ordenar(elementos, ini, j - 1);
        ordenar(elementos, j + 1, fin);
        assert estaOrdenado(elementos, ini, fin);
    }

    // partition the subarray elements[ini..fin] so that elements[ini..j-1] <= elements[j] <= elements[j+1..fin]
    // and return the index j.
    private static int particion(Comparable[] elementos, int ini, int fin) {
        int i = ini;
        int j = fin + 1;
        Comparable v = elementos[ini];
        while (true) {

            // find item on ini to swap
            while (menor(elementos[++i], v)) {
                if (i == fin) {
                    break;
                }
            }

            // find item on fin to swap
            while (menor(v, elementos[--j])) {
                if (j == ini) {
                    break;      // redundant since elements[ini] acts as sentinel
                }
            }

            // check if pointers cross
            if (i >= j) {
                break;
            }

            intercambiar(elementos, i, j);
        }

        // put partitioning item v at elements[j]
        intercambiar(elementos, ini, j);

        // now, elements[ini .. j-1] <= elements[j] <= elements[j+1 .. fin]
        return j;
    }
}