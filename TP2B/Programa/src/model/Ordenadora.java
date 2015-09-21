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
     * @param elements - elementos a ser ordenados
     */
    public abstract void sort(Comparable<T>[] elements);

    /*
     * Helper methods
     */

    // is v < w ?
    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    protected static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]
    protected static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    protected static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

 // is the array h-sorted?
    protected static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++){
        	if (less(a[i], a[i-h])){
            	return false;
            }
        }
        return true;
    }
    
    protected static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    protected static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++){
        	if (less(a[i], a[i-1])){
            	return false;
            }
        }
        return true;
    }

    protected static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length - 1, comparator);
    }

    // is the array sorted from a[lo] to a[hi]
    protected static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i <= hi; i++){
            if (less(a[i], a[i-1], comparator)){
            	return false;
            }
        }
        return true;
    }

    // print array to standard output
    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}