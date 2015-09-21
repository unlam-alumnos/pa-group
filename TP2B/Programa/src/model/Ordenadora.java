package model;

import java.util.Comparator;

/**
 * Clase ordenadora padre
 *
 * @param <T> - tipo de elementos a ser manipulados
 */
public abstract class Ordenadora<T> {
    /**
     * Ordena un vector de elementos comparables
     *
     * @param elementos - elementos a ser ordenados
     */
    public abstract void ordenar(Comparable<T>[] elementos);

    /*
     * Helper methods
     */

    // elemento1 es menor elemento2 ?
    protected static boolean menor(Comparable elemento1, Comparable elemento2) {
        return elemento1.compareTo(elemento2) < 0;
    }

    // v es menor w ?
    protected static boolean menor(Object elemento1, Object elemento2, Comparator comparador) {
        return comparador.compare(elemento1, elemento2) < 0;
    }

    // intercambia a[i] y a[j]
    protected static void intercambiar(Object[] elementos, int indice1, int indice2) {
        Object swap = elementos[indice1];
        elementos[indice1] = elementos[indice2];
        elementos[indice2] = swap;
    }

/* No es necesaria, con la anterior se atiende cualquier intercambio
    // exchange a[i] and a[j]  (for indirect sort)
    protected static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
*/
    // esta ordenado ?
    protected static boolean estaOrdenado(Comparable[] elementos) {
        return estaOrdenado(elementos, 0, elementos.length - 1);
    }

    protected static boolean estaOrdenado(Object[] elementos, Comparator comparador) {
        return estaOrdenado(elementos, 0, elementos.length - 1, comparador);
    }

    // Consulta si esta ordenado el array desde array[ini] hasta array[fin]
    protected static boolean estaOrdenado(Comparable[] elementos, int ini, int fin) {
        for (int i = ini + 1; i <= fin; i++){
        	if (menor(elementos[i], elementos[i-1])){
            	return false;
            }
        }
        return true;
    }

    // Consulta si esta ordenado el array desde array[ini] hasta array[fin]
    protected static boolean estaOrdenado(Object[] elementos, int ini, int fin, Comparator comparador) {
        for (int i = ini + 1; i <= fin; i++){
            if (menor(elementos[i], elementos[i-1], comparador)){
            	return false;
            }
        }
        return true;
    }

    protected static void mostrar(Comparable[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            System.out.println(elementos[i]);
        }
    }
}