package test;

import algoritmos.Matula;

public class Test {

	public static void main(String[] args) {
		
		Matula grafo = new Matula("grafo.in");
		
		grafo.colorear();
		grafo.generarArchivoSalida("grafo.out");
		
	}
}
