package model;

public class Fusion extends Ordenadora{

	@Override
	public void sort(Comparable[] elements){
		Comparable [ ] tmpElements = new Comparable[ elements.length ];
		mergeSort( elements, tmpElements, 0, elements.length - 1 );
	}
	
	public void mergeSort(Comparable[] elements, Comparable[] tmpElements, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort( elements, tmpElements, left, center );
			mergeSort( elements, tmpElements, center + 1, right );
			merge( elements, tmpElements, left, center + 1, right );
		}
	}
	
	public void merge( Comparable [ ] elements, Comparable [ ] tmpElements, int leftPos, int rightPos, int rightEnd ) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		// Main loop
		while( leftPos <= leftEnd && rightPos <= rightEnd ){
			if( elements[leftPos].compareTo(elements[rightPos]) <= 0 ){
				tmpElements[tmpPos++] = elements[leftPos++];
			}else { 
				tmpElements[tmpPos++] = elements[rightPos++];
			}
		}
		
		while( leftPos <= leftEnd ) {
			tmpElements[ tmpPos++ ] = elements[ leftPos++ ];
		}
		
		while( rightPos <= rightEnd ) {
			tmpElements[ tmpPos++ ] = elements[ rightPos++ ];
		}
		
		// Copy tmpArray back
	    for( int i = 0; i < numElements; i++, rightEnd-- ){
	    	elements[rightEnd] = tmpElements[rightEnd];
	    }
		
	}
}
