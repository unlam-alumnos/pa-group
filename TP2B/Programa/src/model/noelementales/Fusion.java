package model.noelementales;

import model.Ordenadora;

public class Fusion extends Ordenadora {

	@Override
	public void ordenar(Comparable[] elementos) {
		Comparable[] tmpElementos = new Comparable[elementos.length];
		dividir(elementos, tmpElementos, 0, elementos.length - 1);
	}

	public void dividir(Comparable[] elementos, Comparable[] tmpElementos,
			int ini, int fin) {
		if (ini < fin) {
			int centro = (ini + fin) / 2;
			dividir(elementos, tmpElementos, ini, centro);
			dividir(elementos, tmpElementos, centro + 1, fin);
			fusionar(elementos, tmpElementos, ini, centro + 1, fin);
		}
	}

	public void fusionar(Comparable[] elementos, Comparable[] tmpElementos, int izquierda, int derecha, int fin) {
		int centro = derecha - 1;
		int tmpPos = izquierda;
		int tam = fin - izquierda + 1;

		while (izquierda <= centro && derecha <= fin) {
			if (elementos[izquierda].compareTo(elementos[derecha]) <= 0) {
				tmpElementos[tmpPos] = elementos[izquierda];
				izquierda++;
			} else {
				tmpElementos[tmpPos] = elementos[derecha];
				derecha++;
			}
			tmpPos++;
		}

		while (izquierda <= centro) {
			tmpElementos[tmpPos++] = elementos[izquierda++];
		}

		while (derecha <= fin) {
			tmpElementos[tmpPos++] = elementos[derecha++];
		}
		
		for (int i = 0; i < tam; i++, fin--) {
			elementos[fin] = tmpElementos[fin];
		}
	}
}
