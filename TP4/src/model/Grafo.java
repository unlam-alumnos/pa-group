package model;

import model.MatrizSimetrica;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Grafo {

	protected int inf = 100000;
	protected MatrizSimetrica matrizAdyacencia;
	protected Integer cantidadNodos;
	protected Integer cantidadAristas;
	protected Integer porcentajeAdyacencia;
	protected ArrayList<Integer> gradoNodo = new ArrayList<Integer>();
	protected ArrayList<Integer> nodos = new ArrayList<Integer>();
	protected ArrayList<Integer> colorNodos = new ArrayList<Integer>();
	protected Integer cantidadColores = 1;
	protected Integer maximoGrado;
	protected Integer minimoGrado;
	
	public Grafo(){}
	
	public Grafo(String ruta) {
		this.matrizAdyacencia = new MatrizSimetrica(ruta);
		this.cantidadNodos = matrizAdyacencia.getCantNodos();
		this.cantidadAristas = matrizAdyacencia.getCantAristas();
		this.porcentajeAdyacencia = (int) ((cantidadAristas - 1) * 100) / (((cantidadNodos -1) * cantidadNodos)/2);

		for(int x = 0; x < cantidadNodos; x++) {
			gradoNodo.add(0);
			nodos.add(x);
			colorNodos.add(0);
		}

		for (int x = 0; x < cantidadNodos; x++)
			for (int y = x + 1; y < cantidadNodos; y++) 
				if(matrizAdyacencia.getValueVector(x, y) == 1) {
					gradoNodo.set(x, gradoNodo.get(x) + 1);
					gradoNodo.set(y, gradoNodo.get(y) + 1);
				}

		for (int x = 0; x < cantidadNodos; x++) 
			for (int y = x + 1; y < cantidadNodos; y++) 
				if (gradoNodo.get(x) > gradoNodo.get(y)) {
					Integer auxGrado = gradoNodo.get(x);
					gradoNodo.set(x, gradoNodo.get(y));
					gradoNodo.set(y, auxGrado);
					Integer auxNodo = nodos.get(x);
					nodos.set(x, nodos.get(y));
					nodos.set(y, auxNodo);
				}
		
		this.minimoGrado = gradoNodo.get(0);
		this.maximoGrado = gradoNodo.get(cantidadNodos - 1);
	}
	/*
	public Grafo (Grafo grafo){ 
		this.minimoGrado = grafo.getMinimoGrado();
		this.maximoGrado = grafo.getMaximoGrado();
		this.cantidadNodos= grafo.getCantidadNodos();
		this.cantidadAristas = grafo.getCantidadAristas();
		this.porcentajeAdyacencia = (int)grafo.getPorcentajeAdyacencia();
		
		matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
		matrizAdyacencia.setCantAristas(cantidadAristas);
		matrizAdyacencia.setVector(grafo.getMatrizAdyacencia().getMatrizSimetrica());
				
		for(int x = 0; x < cantidadNodos; x++) {
			gradoNodo.add(0);
			nodos.add(x);
			colorNodos.add(0);
		}

		for (int x = 0; x < cantidadNodos; x++)
			for (int y = x + 1; y < cantidadNodos; y++) 
				if(matrizAdyacencia.getValueVector(x, y) == 1) {
					gradoNodo.set(x, gradoNodo.get(x) + 1);
					gradoNodo.set(y, gradoNodo.get(y) + 1);
				}

		for (int x = 0; x < cantidadNodos; x++) 
			for (int y = x + 1; y < cantidadNodos; y++) 
				if (gradoNodo.get(x) > gradoNodo.get(y)) {
					Integer auxGrado = gradoNodo.get(x);
					gradoNodo.set(x, gradoNodo.get(y));
					gradoNodo.set(y, auxGrado);
					Integer auxNodo = nodos.get(x);
					nodos.set(x, nodos.get(y));
					nodos.set(y, auxNodo);
				}
		
		this.minimoGrado = gradoNodo.get(0);
		this.maximoGrado = gradoNodo.get(cantidadNodos - 1);		
	}
	*/
	public Grafo (Grafo grafo , MatrizSimetrica mat){ 
		this.minimoGrado = grafo.getMinimoGrado();
		this.maximoGrado = grafo.getMaximoGrado();
		this.cantidadNodos= grafo.getCantidadNodos();
		this.cantidadAristas = grafo.getCantidadAristas();
		this.porcentajeAdyacencia = (int)grafo.getPorcentajeAdyacencia();
		
		matrizAdyacencia = mat;
				
		for(int x = 0; x < cantidadNodos; x++) {
			gradoNodo.add(0);
			nodos.add(x);
			colorNodos.add(0);
		}

		for (int x = 0; x < cantidadNodos; x++)
			for (int y = x + 1; y < cantidadNodos; y++) 
				if(matrizAdyacencia.getValueVector(x, y) == 1) {
					gradoNodo.set(x, gradoNodo.get(x) + 1);
					gradoNodo.set(y, gradoNodo.get(y) + 1);
				}

		for (int x = 0; x < cantidadNodos; x++) 
			for (int y = x + 1; y < cantidadNodos; y++) 
				if (gradoNodo.get(x) > gradoNodo.get(y)) {
					Integer auxGrado = gradoNodo.get(x);
					gradoNodo.set(x, gradoNodo.get(y));
					gradoNodo.set(y, auxGrado);
					Integer auxNodo = nodos.get(x);
					nodos.set(x, nodos.get(y));
					nodos.set(y, auxNodo);
				}
		
		this.minimoGrado = gradoNodo.get(0);
		this.maximoGrado = gradoNodo.get(cantidadNodos - 1);
		
	}
	
	public void guardarGrafo(String ruta) {

		File archivo = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		try {
			archivo = new File(ruta);
			pw = new PrintWriter(archivo);
			sb = new StringBuffer();
			
			porcentajeAdyacencia = (int) porcentajeAdyacencia;

			pw.println(cantidadNodos + " " + cantidadAristas + " "+ (int) porcentajeAdyacencia + " " + maximoGrado + " " + minimoGrado);
			for (int i = 0; i < cantidadNodos; i++)
				for (int j = i + 1; j < cantidadNodos; j++) {
					if (matrizAdyacencia.getValueVector(i,j) != inf) {
						sb.append(i + " " + j + " " + matrizAdyacencia.getValueVector(i,j));
						sb.append("\n");
						//pw.println(i + " " + j + " " + matrizAdyacencia.getMatrizSimetrica()[i][j]);
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
					+ maximoGrado + " " + minimoGrado);

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

	public void desordenarNodos(){
		Collections.shuffle(nodos);
	}
	
	public MatrizSimetrica getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
	
	public Integer getCantidadColores() {
		return cantidadColores;
	}	
	
	public Integer getCantidadNodos() {
		return cantidadNodos;
	}

	public Integer getCantidadAristas() {
		return cantidadAristas;
	}

	public Integer getMaximoGrado() {
		return maximoGrado;
	}

	public Integer getMinimoGrado() {
		return minimoGrado;
	}

	public Integer getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}

	public ArrayList<Integer> getNodos() {
		return nodos;
	}
	
}
