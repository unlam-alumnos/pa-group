package model;

import java.util.Arrays;
import java.util.Random;

public class Generador extends Grafo {

	public Generador() {
	}

	private double factorial(int numero) {
		double factorial = 1;
		while (numero != 0) {
			factorial = factorial * numero;
			numero--;
		}
		return factorial;
	}

	public void grafoDadoNYProbAristas(int cantNodos, double probabilidadAristas) {
		this.cantidadNodos = cantNodos;
		this.nodos = new Nodo[cantNodos];
		initNodos();
		this.matrizAdyacencia = new MatrizSimetrica(this.cantidadNodos);
		this.cantidadAristas = 0;
		int[] vectorGrados = new int[this.cantidadNodos];
		Arrays.fill(vectorGrados, 0);
		
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (!this.matrizAdyacencia.isAdyacentes(i, j)) {
					if (Math.random() < probabilidadAristas) {
						nodos[i].addGrado();
						nodos[j].addGrado();
						matrizAdyacencia.setNodo(i, j);
						this.cantidadAristas++;
					}
				}
			}
		}
		
		Arrays.sort(nodos);
		this.gradoMaximo = nodos[this.cantidadNodos - 1].getGrado();
		this.gradoMinimo = nodos[0].getGrado();
		
		double aristasMaximas = factorial(cantNodos-1);
		this.porcentajeAdyacencia = (int) (Math.rint(this.cantidadAristas/aristasMaximas));
	}

	public void grafoDadoNYPorcentajeAdy(int cantNodos, int porcentajeAdy) {
		Random rand = new Random();
		this.cantidadNodos = cantNodos;
		this.nodos = new Nodo[cantNodos];
		initNodos();
		this.porcentajeAdyacencia = porcentajeAdy;
		this.matrizAdyacencia = new MatrizSimetrica(this.cantidadNodos);
		this.cantidadAristas = (int) (Math
				.rint((cantNodos * cantNodos - cantNodos) * 0.5
						* (porcentajeAdy / 100.0)));

		int aristasAplicadas = 0;
		while (aristasAplicadas != this.cantidadAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (!this.matrizAdyacencia.isAdyacentes(i, j)) {
						if (rand.nextInt(2) == 1) {
							nodos[i].addGrado();
							nodos[j].addGrado();
							matrizAdyacencia.setNodo(i, j);
							aristasAplicadas++;
						}
					}
					if (aristasAplicadas == this.cantidadAristas) {
						break;
					}
				}
				if (aristasAplicadas == this.cantidadAristas) {
					break;
				}
			}
		}

		Arrays.sort(nodos);
		this.gradoMaximo = nodos[this.cantidadNodos - 1].getGrado();
		this.gradoMinimo = nodos[0].getGrado();
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
		//generador.grafoDadoNYProbAristas(4,0.5);
		generador.exportar("GrafoPrueba.in");
	}
}
