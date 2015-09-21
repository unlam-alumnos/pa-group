package model;

public class Burbuja extends Ordenadora {
	
    @Override
    public void sort(Comparable[] elements) {
        int n = elements.length;
        for (int i = 0; i < (n - 1); i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    Comparable swap = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = swap;
                }
            }
        }
    }
}