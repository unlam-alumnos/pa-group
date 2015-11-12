package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (!isAdyacentes(i, j)) {
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

		double aristasMaximas = factorial(cantNodos - 1);
		this.porcentajeAdyacencia = (int) (Math.rint((this.cantidadAristas/ aristasMaximas) * 100.0));
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
					if (!isAdyacentes(i, j)) {
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

	public void grafoRegularDadoNYGrado(int cantNodos, int gradoRegular) {
		Random random = new Random();
		this.cantidadNodos = cantNodos;
		this.nodos = new Nodo[cantNodos];
		initNodos();
		this.matrizAdyacencia = new MatrizSimetrica(cantNodos);
		this.gradoMaximo = gradoRegular;
		this.gradoMinimo = gradoRegular;
		this.cantidadAristas = 0;

		// Condiciones para que G(N, k) sea k-regular:
        // 1. k + 1 <= N.
        // 2. N * k par.
		if (gradoRegular + 1 > cantNodos) {
			System.err.println("No se puede generar un grafor " + gradoRegular + "-regular de " + cantNodos + " nodos.");
			System.exit(-1);
		}
		if (cantNodos * gradoRegular % 2 != 0) {
			System.err.println("No se puede generar un grafor " + gradoRegular + "-regular de " + cantNodos + " nodos.");
			System.exit(-1);
		}
		if (gradoRegular != 0) {
			
			// Por las dudas chequeo que el grafo que me quedo formado sea Regular
			while (!esKRegular(gradoRegular)) {
				
				Map<Integer, Nodo> nodosAux = new HashMap<Integer, Nodo>();
				
				for (int i = 0; i < nodos.length; i++) {
					nodosAux.put(nodos[i].getIndice(), new Nodo(nodos[i].getIndice(),0,0));
				}
				
				// Mientras tenga nodos por analizar en el Map
				while (!nodosAux.isEmpty()) {
					
					// Tomamos dos indices distintos al azar de dicha lista
					int indice1 = random.nextInt(nodos.length);
					int indice2 = random.nextInt(nodos.length);
					while (indice1 == indice2) {
						indice1 = random.nextInt(nodos.length);
						indice2 = random.nextInt(nodos.length);
					}

					// Con dichos indices obtenemos un par de nodos
					Nodo nodoOrigen = nodos[indice1];
					Nodo nodoDestino = nodos[indice2];

					if (nodoOrigen.getIndice() != nodoDestino.getIndice()) {
						// Si esos nodos todavia tienen grado menor a regular los analizo
						if (nodoOrigen.getGrado() < gradoRegular && nodoDestino.getGrado() < gradoRegular) {
							if (!isAdyacentes(nodoOrigen.getIndice(), nodoDestino.getIndice())) {

								this.matrizAdyacencia.setNodo(nodoOrigen.getIndice(), nodoDestino.getIndice());
								this.cantidadAristas++;
								nodos[nodoOrigen.getIndice()].addGrado();
								nodos[nodoDestino.getIndice()].addGrado();
								nodosAux.get(indice1).addGrado();
								nodosAux.get(indice2).addGrado();
								
								// Chequeo si alguno de los nodos llego al grado maximo y en ese caso lo quito del Map
								if (nodosAux.get(indice1).getGrado() == gradoRegular) {
									nodosAux.remove(indice1);
								}
								if (nodosAux.get(indice2).getGrado() == gradoRegular) {
									nodosAux.remove(indice2);
								}	
							}
						}
					}
				}
			}
		}		

		double aristasMaximas = factorial(cantNodos - 1);
		this.porcentajeAdyacencia = (int) (Math.rint((this.cantidadAristas/ aristasMaximas) * 100.0));
	}

	public void grafoRegularDadoNYPorcentajeAdy(int cantNodos, int porcentajeAdy) {
		int aux = (int) ((Math.rint((cantNodos * cantNodos - cantNodos) * 0.5* (porcentajeAdy / 100.0))) / 2);
		grafoRegularDadoNYGrado(cantNodos,aux);
	}

	public void grafoNPartito(int cantNodos, int partes) {

	}

	public static void main(String[] args) {
		Generador generador = new Generador();
		//generador.grafoDadoNYPorcentajeAdy(4, 66);
		//generador.grafoDadoNYProbAristas(4,0.5);
		//generador.grafoRegularDadoNYGrado(6, 3);
		//generador.grafoRegularDadoNYPorcentajeAdy(6, 50);
		generador.exportar("GrafoPrueba.in");
	}
}
