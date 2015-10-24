package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Grafo {
	
	private MatrizSimetrica matrizAdyacencia;
	private int cantNodos;
	private int cantAristas;
	private double porcAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;
	
	public Grafo(){}
	
	public Grafo(String entrada){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(entrada);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String[] data;
			
			data = br.readLine().split(" ");
			cantNodos = Integer.parseInt(data[0]);
			cantAristas = Integer.parseInt(data[1]);
			porcAdyacencia = Double.parseDouble(data[2]);
			gradoMaximo = Integer.parseInt(data[3]);
			gradoMinimo = Integer.parseInt(data[4]);
			matrizAdyacencia = new MatrizSimetrica(cantNodos);
			
			while (( data = br.readLine().split(" ") ) != null) {
				int nodoOrigen = Integer.parseInt(data[0]);
				int nodoDestino = Integer.parseInt(data[1]);
				matrizAdyacencia.setNodo(nodoOrigen, nodoDestino);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void ordenarGrafoAscendente(){
		
	}
	

	private void ordenarGrafoDescendente(){
		
	}
	
	public void coloreoSecuencial(){
		
	}
	
	public void coloreoWelshPowell(){
		// Primero el de menor grado
		ordenarGrafoAscendente();
		coloreoSecuencial();
	}
	
	public void coloreoMatula(){
		// Primero el de mayor grado
		ordenarGrafoDescendente();
		coloreoSecuencial();		
	}
	
	//Generador de grafos aleatorios dados N y una probabilidad para cada arista.
	public static Grafo generador(int nodos, int probAristas){
		return new Grafo("");
	}
	
	//Generador de grafos aleatorios dados N y el porcentaje de adyacencia.
	public static Grafo generador(int nodos, double porcAdyacencia){
		return new Grafo("");
	}
	
	//Generador de grafos regulares dados N y el grado.
	public static Grafo generadorRegular(int nodos, int grado){
		return new Grafo("");		
	}
	
	//Generador de grafos regulares dados N y el porcentaje de adyacencia.
	public static Grafo generadorRegular(int nodos, double porcAdyacencia){
		return new Grafo("");		
	}
	
	//Generador de grafos n-partitos, dados N y n.
	public static Grafo generadorNPartito(int nodos, int n){
		return new Grafo("");		
	}
}
