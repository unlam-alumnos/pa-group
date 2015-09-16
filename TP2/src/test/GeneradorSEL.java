package test;

import model.SEL;

public class GeneradorSEL {

	public static void main(String[] args) {
		
		// Genero Sistemas de Ecuaciones para evaluar el rendimiento
		// Por "Simple" entendemos coeficientes enteros entre 1 y 11 por ejemplo
		
		SEL.generadorAleatorioSEL_Simples(2);
		SEL.generadorAleatorioSEL_Simples(4);
		SEL.generadorAleatorioSEL_Simples(6);
		SEL.generadorAleatorioSEL_Simples(10);
		SEL.generadorAleatorioSEL_Simples(100);
		SEL.generadorAleatorioSEL_Simples(300);
		SEL.generadorAleatorioSEL_Simples(500);
		SEL.generadorAleatorioSEL_Simples(700);
		SEL.generadorAleatorioSEL_Simples(1000);
	}
}
