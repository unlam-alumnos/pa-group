package algoritmos;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Grafo;
import model.MatrizSimetrica;


public class WelshPowell extends Grafo{

	public WelshPowell(String ruta) {
		super(ruta);		
	}	
	/*
	public WelshPowell(Grafo grafo , MatrizSimetrica mat){ 
		super(grafo,mat);
	}
	*/
	
	public WelshPowell(Grafo grafo , MatrizSimetrica mat){ 
		this.gradoMinimo = grafo.getMaximoGrado();
		this.gradoMaximo = grafo.getMinimoGrado();
		this.cantidadNodos= grafo.getCantidadNodos();
		this.cantidadAristas = grafo.getCantidadAristas();
		this.nodos = grafo.getNodos();
		this.porcentajeAdyacencia = (int)grafo.getPorcentajeAdyacencia();
		
		matrizAdyacencia = mat;
				
		for(int x = 0; x < cantidadNodos; x++) { // cargo los nodos
			gradoNodo.add(0);
			//nodos.add(x);
			colorNodos.add(0);
		}

		for (int x = 0; x < cantidadNodos; x++)   // cargo los grados de los nodos
			for (int y = x + 1; y < cantidadNodos; y++) 
				if(matrizAdyacencia.getValueVector(x, y) == 1) {
					gradoNodo.set(x, gradoNodo.get(x) + 1);
					gradoNodo.set(y, gradoNodo.get(y) + 1);
				}

		for (int x = 0; x < cantidadNodos; x++)   // ordeno los nodos por grados de mayor a menor
			for (int y = x + 1; y < cantidadNodos; y++) 
				if (gradoNodo.get(x) < gradoNodo.get(y)) {
					Integer auxGrado = gradoNodo.get(x);
					gradoNodo.set(x, gradoNodo.get(y));
					gradoNodo.set(y, auxGrado);
					Integer auxNodo = nodos.get(x);
					nodos.set(x, nodos.get(y));
					nodos.set(y, auxNodo);
				}
		
		this.gradoMaximo = gradoNodo.get(0);
		this.gradoMinimo = gradoNodo.get(cantidadNodos - 1);
	}
	
	
	public void colorear() {
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
}
	
