package model;

public class Seleccion extends Ordenadora {
	
    @Override
    public void sort(Comparable[] elements) {
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(elements[j], elements[min])) min = j;
            }
            exch(elements, i, min);
            assert isSorted(elements, 0, i);
        }
        assert isSorted(elements);
    }
}