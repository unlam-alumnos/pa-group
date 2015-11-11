package test;

import algoritmos.Matula;

public class Test {

	public static void main(String[] args) {
		
		Matula grafo = new Matula("LoteDePruebas\\IN\\pentagonoCompleto.in");
		
		grafo.colorear();
		grafo.generarArchivoSalida("LoteDePruebas\\OUT\\pentagonoCompleto.out");
		
	}
}
