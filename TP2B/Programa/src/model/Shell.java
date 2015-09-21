package model;

public class Shell extends Ordenadora{
	
	@Override
	public void sort(Comparable[] elements){
		int n = elements.length;
		int h = 1;
        
		// Defino el H a utilizar H = Hi - 1 * 3 + 1 --> 1, 4, 13, 40, 121, 364, 1093, ... 
        while (h < n/3) {
        	h = 3*h + 1; 
        }

        while (h >= 1) {
        	// h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(elements[j], elements[j-h]); j -= h) {
                    exch(elements, j, j-h);
                }
            }
            assert isHsorted(elements, h); 
            
            h /= 3;
        }
        assert isSorted(elements);
	}

}
