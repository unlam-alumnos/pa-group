package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Grafo {

	protected Integer cantidadNodos;
	protected Integer cantidadAristas;
	protected Integer porcentajeAdyacencia;
	protected Integer gradoMinimo;
	protected Integer gradoMaximo;
	protected MatrizSimetrica matrizAdyacencia;
	protected Nodo[] nodos;

	//protected ArrayList<Integer> nodos = new ArrayList<Integer>();
	protected ArrayList<Integer> gradoNodo = new ArrayList<Integer>();
	protected ArrayList<Integer> colorNodos = new ArrayList<Integer>();
	protected Integer cantidadColores;

	public Grafo() {
	}

	public Grafo(Integer cantidadNodos, Integer cantidadAristas,
			Integer porcentajeAdyacencia, Integer gradoMinimo,
			Integer gradoMaximo, MatrizSimetrica matrizAdyacencia) {
		this.cantidadNodos = cantidadNodos;
		this.cantidadAristas = cantidadAristas;
		this.porcentajeAdyacencia = porcentajeAdyacencia;
		this.gradoMinimo = gradoMinimo;
		this.gradoMaximo = gradoMaximo;
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public Grafo(Grafo otro) {
		this(otro.getCantidadNodos(), otro.getCantidadAristas(), otro
				.getPorcentajeAdyacencia(), otro.getGradoMinimo(), otro
				.getGradoMaximo(), otro.getMatrizAdyacencia());
	}

	public Grafo(String entrada) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(entrada);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String[] data;

			data = br.readLine().split(" ");
			cantidadNodos = Integer.parseInt(data[0]);
			cantidadAristas = Integer.parseInt(data[1]);
			porcentajeAdyacencia = Integer.parseInt(data[2]);
			gradoMaximo = Integer.parseInt(data[3]);
			gradoMinimo = Integer.parseInt(data[4]);
			matrizAdyacencia = new MatrizSimetrica(cantidadNodos);

			while ((data = br.readLine().split(" ")) != null) {
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

	public void guardarGrafo(String ruta) {
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
						sb.append(i + " " + j + "\n");
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

	public void generarArchivoSalida(File archivo) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(archivo);
			pw.println(cantidadNodos + " " + cantidadColores + " "
					+ cantidadAristas + " " + porcentajeAdyacencia + " "
					+ gradoMaximo + " " + gradoMinimo);

			for (int x = 0; x < cantidadNodos; x++) {
				Integer nodo = nodos.get(x);
				pw.println(nodo + " " + colorNodos.get(nodo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
		}
	}

	public void desordenarNodos() {
		Collections.shuffle(nodos);
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

}
