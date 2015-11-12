package model;

import java.util.Arrays;
import java.util.Random;

public class Generador extends Grafo {

	public Generador() {
	}

	public void grafoDadoNYProbAristas(int cantidad, double probabilidadAristas) {
		
	}

	public void grafoDadoNYPorcentajeAdy(int cantNodos, int porcentajeAdy) {
		Random rand = new Random();
		this.cantidadNodos = cantNodos;
		this.porcentajeAdyacencia = porcentajeAdy;
		this.matrizAdyacencia = new MatrizSimetrica(this.cantidadNodos);
		this.cantidadAristas = (int) (Math.rint((cantNodos * cantNodos - cantNodos) * 0.5 * (porcentajeAdy / 100.0)));

		int[] vectorGrados = new int[this.cantidadNodos];
		Arrays.fill(vectorGrados, 0);
		int aristasAplicadas = 0;

		while (aristasAplicadas != this.cantidadAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (!this.matrizAdyacencia.isAdyacentes(i, j)) {
						if (rand.nextInt(2) == 1) {
							this.matrizAdyacencia.setNodo(i, j);
							aristasAplicadas++;
							vectorGrados[i]++;
							vectorGrados[j]++;
						}
					}
					if (aristasAplicadas == this.cantidadAristas){
						break;
					}
				}
				if (aristasAplicadas == this.cantidadAristas){
					break;
				}
			}
		}

		Arrays.sort(vectorGrados);
		this.gradoMaximo = vectorGrados[this.cantidadNodos - 1];
		this.gradoMinimo = vectorGrados[0];
	}

	public void grafoRegularDadoNYGrado(int cantNodos, int grado) {

	}

	public void grafoRegularDadoNYPorcentajeAdy(int cantNodos, int porcentajeAdy) {

	}

	public void grafoNPartito(int cantNodos, int partes) {

	}

	public static void main(String[] args) {
		Generador generador = new Generador();
		generador.grafoDadoNYPorcentajeAdy(4, 66);
		generador.exportar("GrafoPrueba.in");
	}
}
