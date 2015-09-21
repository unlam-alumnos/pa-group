package model;

public class Insersion extends Ordenadora {
	
    @Override
    public void sort(Comparable[] elements) {
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && elements[j].compareTo(elements[j - 1]) < 0; j--) {
                exch(elements, j, j - 1);
            }
            assert isSorted(elements, 0, i);
        }
        assert isSorted(elements);
    }
    
    public void sortWithSentinal(Comparable[] elements){
    	int n = elements.length;
    	for (int i = n - 1; i > 0; i--) {
    		if (elements[i].compareTo(elements[i - 1]) < 0) {
    			exch(elements, i, i - 1);
    		}
    	}
    	for (int i = 2; i < n; i++) {
    		for (int j = i; elements[j].compareTo(elements[j - 1]) < 0; j--) {
    			exch(elements, j, j - 1);
    		}
    	}
        assert isSorted(elements);
    }
}