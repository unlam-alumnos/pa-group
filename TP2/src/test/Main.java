package test;

import model.SEL;

public class Main {

	public static void main(String[] args) throws Exception {
		
		SEL sistema = new SEL("entrada.in");
		sistema.resolver();
		sistema.escribirSalida("solucion.out");
		//System.out.println(sistema.getSolucion().toString());
	}

}
