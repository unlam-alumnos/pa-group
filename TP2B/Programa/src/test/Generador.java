package test;

public class Generador {
	
	static public Integer[] elementosOrdenados(int dimension){
		
		Integer[] aux = new Integer[dimension];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = i;
		}
		return aux;
	}	

	static public Integer[] elementosOrdenInverso(int dimension){
		
		Integer[] aux = new Integer[dimension];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = aux.length - i;
		}
		return aux;
	}

	static public Integer[] elementosRandom(int dimension){
		
		Integer[] aux = new Integer[dimension];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = (int)(Math.random() * dimension + 1);
		}
		return aux;
	}
}
