package algoritmos;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import generadores.Grafo;
import generadores.MatrizSimetrica;

public class ColoreoSecuencialAleatorio {

	private MatrizSimetrica matrizAdyacencia;
	private Integer cantidadNodos;
	private Integer cantidadAristas;
	private Integer porcentajeAdyacencia;
	private ArrayList<Integer> nodos = new ArrayList<Integer>();
	private ArrayList<Integer> colorNodos = new ArrayList<Integer>();
	private Integer cantidadColores = 1;
	private Integer maximoGrado;
	private Integer minimoGrado;
	private ArrayList<Integer> gradoNodo = new ArrayList<Integer>();
	
	public ColoreoSecuencialAleatorio(String ruta) {
		matrizAdyacencia = new MatrizSimetrica(ruta);
		this.cantidadNodos = matrizAdyacencia.getCantNodos();
		this.cantidadAristas = matrizAdyacencia.getCantAristas();
		
		this.porcentajeAdyacencia = (int) ((cantidadAristas) * 100) / (((cantidadNodos -1) * cantidadNodos)/2);
		
		
		for(int x = 0; x < cantidadNodos; x++) {
			nodos.add(x);
			colorNodos.add(0);
			gradoNodo.add(0);
		}
		
		for(int x = 0; x < cantidadNodos; x++) 
			for (int y = x + 1; y < cantidadNodos; y++) 
			if(matrizAdyacencia.getValueVector(x, y) == 1) {
				gradoNodo.set(x, gradoNodo.get(x) + 1);
				gradoNodo.set(y, gradoNodo.get(y) + 1);
			}
		
		Collections.sort(gradoNodo);
		this.minimoGrado = gradoNodo.get(0);
		this.maximoGrado = gradoNodo.get(cantidadNodos - 1);
	}

	
	public ColoreoSecuencialAleatorio(Grafo grafo) {
		this.minimoGrado = grafo.getGradoMin();
		this.maximoGrado = grafo.getGradoMax();
		this.cantidadNodos= grafo.getCantNodos();
		this.cantidadAristas = grafo.getCantAristas();
		this.porcentajeAdyacencia = (int)grafo.getPorcentajeAdy();
		
		matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
		matrizAdyacencia.setCantAristas(cantidadAristas);
		matrizAdyacencia.setVector(grafo.getMatrizAdy());
		
	
		for(int x = 0; x < cantidadNodos; x++) {
			nodos.add(x);
			colorNodos.add(0);
			gradoNodo.add(0);
		}
		
		for(int x = 0; x < cantidadNodos; x++) 
			for (int y = x + 1; y < cantidadNodos; y++) 
			if(matrizAdyacencia.getValueVector(x, y) == 1) {
				gradoNodo.set(x, gradoNodo.get(x) + 1);
				gradoNodo.set(y, gradoNodo.get(y) + 1);
			}
		
		Collections.sort(gradoNodo);
		this.minimoGrado = gradoNodo.get(0);
		this.maximoGrado = gradoNodo.get(cantidadNodos - 1);
	
		
	}
	
	public ColoreoSecuencialAleatorio(Grafo grafo , MatrizSimetrica mat){ 
		this.minimoGrado = grafo.getGradoMin();
		this.maximoGrado = grafo.getGradoMax();
		this.cantidadNodos= grafo.getCantNodos();
		this.cantidadAristas = grafo.getCantAristas();
		this.porcentajeAdyacencia = (int)grafo.getPorcentajeAdy();
		
		matrizAdyacencia = mat;
	
		for(int x = 0; x < cantidadNodos; x++) {
			nodos.add(x);
			colorNodos.add(0);
			gradoNodo.add(0);
		}
		
		for(int x = 0; x < cantidadNodos; x++) 
			for (int y = x + 1; y < cantidadNodos; y++) 
			if(matrizAdyacencia.getValueVector(x, y) == 1) {
				gradoNodo.set(x, gradoNodo.get(x) + 1);
				gradoNodo.set(y, gradoNodo.get(y) + 1);
			}
		
		Collections.sort(gradoNodo);
		this.minimoGrado = gradoNodo.get(0);
		this.maximoGrado = gradoNodo.get(cantidadNodos - 1);
	}
	
	public void resolver() {
		for(int x = 0; x < cantidadNodos; x++){
			Integer nodo = nodos.get(x);
			colorNodos.set(nodo, 1);
			Boolean coincideColor = false;
			Boolean finWhile = false;
			 
			while(!finWhile) {
				for(int y = 0; y < cantidadNodos; y++) 
					if(nodo != y && matrizAdyacencia.getValueVector(nodo, y) == 1) 
						if(colorNodos.get(nodo).equals(colorNodos.get(y)))
							coincideColor = true;
				if(coincideColor) {
					colorNodos.set(nodo, colorNodos.get(nodo) + 1);
					coincideColor = false;
					finWhile = false;
				} else {
					finWhile = true;
				}
				if(colorNodos.get(nodo) > cantidadColores)
					cantidadColores = colorNodos.get(nodo);
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

	public static void main(String[] args) {
		ColoreoSecuencialAleatorio secuencialAleatorio = new ColoreoSecuencialAleatorio("grafo.in");
		secuencialAleatorio.resolver();
		secuencialAleatorio.generarArchivoSalida(new File("coloreoSecuencialAle.out"));
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
	
	
}