package model.noelementales;

import model.Ordenadora;

public class QuickSort extends Ordenadora {
	
    @Override
    public void ordenar(Comparable[] elementos) {
        ordenar(elementos, 0, elementos.length - 1);
    }

    private static void ordenar(Comparable[] elementos, int ini, int fin) {
        if (fin <= ini) {
            return;
        }
        int pivote = particion(elementos, ini, fin);
        ordenar(elementos, ini, pivote - 1);
        ordenar(elementos, pivote + 1, fin);
    }

    private static int particion(Comparable[] elementos, int ini, int fin) {
        int indice = ini;
        int pivote = fin + 1;
        Comparable elementoInicial = elementos[ini];
       
        while (true) {

            while (menor(elementos[++indice], elementoInicial)) {
                if (indice == fin) {
                    break;
                }
            }

            while (menor(elementoInicial, elementos[--pivote])) {
                if (pivote == ini) {
                    break;
                }
            }

            if (indice >= pivote) {
                break;
            }

            intercambiar(elementos, indice, pivote);
        }

        intercambiar(elementos, ini, pivote);

        return pivote;
    }
}