package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ordenadora {

	private int[] vector;
	
	public int[] getVector() {
		return vector;
	}

	public Ordenadora(int[] vector) {
		super();
		this.vector = vector;
	}

	public Ordenadora(String pathFile) {
		super();
		FileReader fr = null;
		try {
			File archivo = new File(pathFile);
			fr = new FileReader(archivo);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			int dim = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < dim; i++){
				this.vector[i] = Integer.parseInt(br.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	// ELEMENTALES
	public void seleccion(){
		int menor;
		int posicion;
		int aux;
        for (int i = 0; i < vector.length - 1; i++) { 	// Tomamos como menor el primero
          menor = vector[i]; 							// de los elementos que quedan por ordenar
          posicion = i; 								// y guardamos su posicion.
          for (int j = i + 1; j < vector.length; j++){ 	// Buscamos en el resto
                if (vector[j] < menor) {				// del array algun elemento
                    menor = vector[j]; 					// menor que el actual.
                    posicion = j;
                }
          }
          if (posicion != i){ 							// Si hay alguno menor se intercambia.
              aux = vector[i];
              vector[i] = vector[posicion];
              vector[posicion] = aux;
          }
        }
	}

	public void burbujeo(){
		int aux;
		for(int i = 0; i < vector.length - 1; i++){
			for(int j = 0; j < vector.length - i - 1; j++){	
				if(vector[j+1] < vector[j]){				// Compara pares de elementos adyacentes  
					aux = vector[j+1];						// si estan desordenanos los intercambia
					vector[j+1] = vector[j];
					vector[j] = aux;
				}
			}
		}
	}
	
	public void insercionSinCentinela(){
		int i;
		int j;
		int aux;
	    for (i = 1; i < vector.length; i++){ 		// Desde el segundo elemento hasta
	    	aux = vector[i]; 						// el final, guardamos el elemento y
            j = i - 1; 								// empezamos a comprobar con el anterior.
            while ((j >= 0) && (aux < vector[j])){	// Mientras queden posiciones y el valor de aux sea menor que los
            	vector[j + 1] = vector[j];   		// de la izquierda, se desplaza a la derecha
                j--;                   			
            }
            vector[j + 1] = aux; 					// Colocamos aux en su sitio
	    }
	}
	
	public void insercionConCentinela(){
		// TODO algoritmo de ordenamiento
	}
	
	// NO ELEMENTALES
	public void shell(){
		// TODO algoritmo de ordenamiento
	}
	
	public void quickSort(){
		// TODO algoritmo de ordenamiento
	}
	
	public void fusion(){
		// TODO algoritmo de ordenamiento
	}
	
	static public int[] generarVectorOrdenado(int dimension){
		
		int[] aux = new int[dimension];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = i;
		}
		return aux;
	}	

	static public int[] generarVectorOrdenInverso(int dimension){
		
		int[] aux = new int[dimension];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = aux.length - i;
		}
		return aux;
	}

	static public int[] generarVectorOrdenAleatorio(int dimension){
		
		int[] aux = new int[dimension];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = (int)(Math.random() * dimension + 1);
		}
		return aux;
	}
}
