package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Grafo {

	protected Integer cantidadNodos;
	protected Integer cantidadAristas;
	protected Integer porcentajeAdyacencia;
	protected MatrizSimetrica matrizAdyacencia;
	protected Nodo[] nodos;
	protected Integer gradoMinimo;
	protected Integer gradoMaximo;
	protected Integer cantidadColores;

	public Grafo() {
	}

	public Grafo(Integer cantidadNodos, Nodo[] nodos, Integer cantidadAristas,
			Integer porcentajeAdyacencia, Integer gradoMinimo,
			Integer gradoMaximo, MatrizSimetrica matrizAdyacencia) {
		this.cantidadNodos = cantidadNodos;
		this.nodos = nodos;
		this.cantidadAristas = cantidadAristas;
		this.porcentajeAdyacencia = porcentajeAdyacencia;
		this.gradoMinimo = gradoMinimo;
		this.gradoMaximo = gradoMaximo;
		this.matrizAdyacencia = matrizAdyacencia;
		this.cantidadColores = cantidadNodos;		
	}

	public Grafo(Grafo otro) {
		this(otro.getCantidadNodos(), otro.getNodosArray(), otro
				.getCantidadAristas(), otro.getPorcentajeAdyacencia(), otro
				.getGradoMinimo(), otro.getGradoMaximo(), otro
				.getMatrizAdyacencia());
	}

	public Grafo(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			String[] data;
			
			linea = br.readLine();
			
			data = linea.split(" ");
			cantidadNodos = Integer.parseInt(data[0]);
			nodos = new Nodo[cantidadNodos];
			cantidadAristas = Integer.parseInt(data[1]);
			porcentajeAdyacencia = Integer.parseInt(data[2]);
			gradoMaximo = Integer.parseInt(data[3]);
			gradoMinimo = Integer.parseInt(data[4]);
			matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
			cantidadColores = cantidadNodos;

			while ((linea = br.readLine()) != null) {
				data = linea.split(" ");
				int nodoOrigen = Integer.parseInt(data[0]) - 1;
				int nodoDestino = Integer.parseInt(data[1]) - 1;

				if (nodos[nodoOrigen] == null) {
					nodos[nodoOrigen] = new Nodo(nodoOrigen);
				} else {
					nodos[nodoOrigen].addGrado();
				}

				if (nodos[nodoDestino] == null) {
					nodos[nodoDestino] = new Nodo(nodoDestino);
				} else {
					nodos[nodoDestino].addGrado();
				}

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

	public void exportar(String ruta) {
		File archivo = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		try {
			archivo = new File(ruta);
			pw = new PrintWriter(archivo);
			sb = new StringBuffer();
			pw.println(cantidadNodos + " " + cantidadAristas + " "
					+ porcentajeAdyacencia + " " + gradoMaximo + " "
					+ gradoMinimo);
			for (int i = 0; i < cantidadNodos; i++)
				for (int j = i + 1; j < cantidadNodos; j++) {
					if (matrizAdyacencia.isAdyacentes(i, j)) {
						sb.append((i+1) + " " + (j+1) + "\n");
					}
				}
			pw.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void generarArchivoSalida(String ruta) {
		File archivo = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		try {
			archivo = new File(ruta);
			pw = new PrintWriter(archivo);
			sb = new StringBuffer();

			pw.println(cantidadNodos + " " + cantidadColores + " "
					+ cantidadAristas + " " + porcentajeAdyacencia + " "
					+ gradoMaximo + " " + gradoMinimo);

			for (int i = 0; i < cantidadNodos; i++) {
				sb.append(nodos[i].getIndice()+1 + " " + nodos[i].getColor() + "\n");
			}

			pw.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
		}
	}

	public void colorear() {
		int color = 0;
		int nodosColoreados = 0;
		
		sort();
		cleanNodos();
		mix();

		while (nodosColoreados < cantidadNodos) {
			color++;
			for (int indice = 0; indice < cantidadNodos; indice++) {
				if (puedoColorear(indice, color)) {
					nodos[indice].setColor(color);
					nodosColoreados++;
				}
			}
		}

		cantidadColores = color;
	}
	
	protected void mix() {}

	protected void sort() {}

	public boolean isAdyacentes(int nodoOrigen, int nodoDestino) {
		return this.getMatrizAdyacencia().isAdyacentes(nodoOrigen, nodoDestino);
	}

	public void shuffle() {
		int inicio = 0;
		int fin = 0;
		int gradoActual = 0;

		while (fin < cantidadNodos) {
			gradoActual = nodos[inicio].getGrado();
			while (fin < cantidadNodos && nodos[fin].getGrado() == gradoActual) {
				fin++;
			}
			if (inicio != (fin - 1)) {
				this.shuffle(inicio, fin - 1);
			}
			inicio = fin;
		}
	}

	public void shuffle(int inicio, int fin) {
		int cantidad = (fin - inicio + 1);
		int random;
		Nodo aux;

		for (int i = inicio; i < fin; i++) {
			random = (int) (Math.random() * cantidad + inicio);
			aux = nodos[i];
			nodos[i] = nodos[random];
			nodos[random] = aux;
		}
	}

	public void cleanNodos() {
		for (int i = 0; i < nodos.length; i++) {
			nodos[i].clean();
		}
	}

	public boolean puedoColorear(int indice, int color) {
		if (nodos[indice].getColor() != 0) {
			return false;
		}

		for (int i = 0; i < cantidadNodos; i++) {
			if (i != indice && isAdyacentes(nodos[i].getIndice(), nodos[indice].getIndice())) {
				if (nodos[i].getColor() == color) {
					return false;
				}
			}
		}

		return true;
	}

	public Integer getCantidadNodos() {
		return cantidadNodos;
	}

	public Integer getCantidadAristas() {
		return cantidadAristas;
	}

	public Integer getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}

	public Integer getGradoMinimo() {
		return gradoMinimo;
	}

	public Integer getGradoMaximo() {
		return gradoMaximo;
	}

	public MatrizSimetrica getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public Nodo[] getNodosArray() {
		return nodos;
	}
}
