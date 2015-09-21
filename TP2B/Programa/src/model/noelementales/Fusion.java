package model.noelementales;

import model.Ordenadora;

public class Fusion extends Ordenadora{

	@Override
	public void ordenar(Comparable[] elementos){
		Comparable[] tmpElementos = new Comparable[elementos.length];
		fusion(elementos, tmpElementos, 0, elementos.length - 1 );
	}
	
	public void fusion(Comparable[] elements, Comparable[] tmpElements, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			fusion( elements, tmpElements, left, center );
			fusion( elements, tmpElements, center + 1, right );
			fusionar( elements, tmpElements, left, center + 1, right );
		}
	}
	
	public void fusionar( Comparable[] elementos, Comparable[] tmpElementos, int izquierda, int derecha, int fin ) {
		int ini = derecha - 1;
		int tmpPos = izquierda;
		int tam = fin - izquierda + 1;
		
		// Main loop
		while( izquierda <= ini && derecha <= fin ){
			if( elementos[izquierda].compareTo(elementos[derecha]) <= 0 ){
				tmpElementos[tmpPos++] = elementos[izquierda++];
			}else { 
				tmpElementos[tmpPos++] = elementos[derecha++];
			}
		}
		
		while( izquierda <= ini ) {
			tmpElementos[tmpPos++] = elementos[izquierda++];
		}
		
		while( derecha <= fin ) {
			tmpElementos[tmpPos++] = elementos[derecha++];
		}
		
		// Copy tmpArray back
	    for( int i = 0; i < tam; i++, fin-- ){
	    	elementos[fin] = tmpElementos[fin];
	    }
		
	}
}
