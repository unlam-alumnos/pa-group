
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import model.GrafoNDNP;
import model.Nodo;

public class Probador {
	private GrafoNDNP grafo;
	
	private Integer cantNodosSal;
	private Integer cantidadColoresSal;
	private Integer cantidadAristasSal;
	private Integer porcentajeAdyacenciaSal;
	private Integer gradoMaximoSal;
	private Integer gradoMinimoSal;
	private Nodo[] nodosSal;
	
	
			
	public Probador(String grafoEntrada, String coloreado){
		
		File salida = new File(coloreado);
		FileReader fr = null;
		BufferedReader br = null;
		
		String linea = null;
		String [] lineaSplitted = null;
		
		
		
		try { 
			grafo = new GrafoNDNP (grafoEntrada);
			fr = new FileReader(salida);
			br = new BufferedReader(fr);
			linea = br.readLine();
			lineaSplitted = linea.split(" ");
				
			cantNodosSal = Integer.parseInt(lineaSplitted[0]);
			cantidadColoresSal= Integer.parseInt(lineaSplitted[1]);
			cantidadAristasSal= Integer.parseInt(lineaSplitted[2]);
			porcentajeAdyacenciaSal= Integer.parseInt(lineaSplitted[3]);
			gradoMaximoSal= Integer.parseInt(lineaSplitted[4]);
			gradoMinimoSal= Integer.parseInt(lineaSplitted[5]);
			nodosSal = new Nodo[cantNodosSal];
			
			
			for (int i = 0; i < cantNodosSal; i++) {
				linea = br.readLine();
				lineaSplitted = linea.split(" ");
				
				//Al leer los nodos de salida, les pongo grado -1, ya que no lo conozco
				nodosSal[i] = new Nodo(Integer.parseInt(lineaSplitted[0]),Integer.parseInt(lineaSplitted[1]),-1);
			}
			
			try { fr.close();
					
			} catch (Exception e) {
					e.printStackTrace();
			}
				
				
									
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

	public boolean pruebaOK(){
		//Verificar que los datos de entrada y de salida son los mismos
		
		if(!cantNodosSal.equals(grafo.getCantidadNodos())){
			System.out.println(cantNodosSal + " " + grafo.getCantidadNodos());
			System.out.println("No concuerda la cantidad de nodos de la entrada con la Salida");
			return false;
		}
		if(!cantidadAristasSal.equals(grafo.getCantidadAristas())){
			System.out.println("No concuerda la cantidad de aristas de la entrada con la Salida");
			return false;
		}
		
		if(!porcentajeAdyacenciaSal.equals(grafo.getPorcentajeAdyacencia())){
			System.out.println("No concuerda el porcentaje de adyacencia de la entrada con la Salida");
			return false;
		}
		
		if(!gradoMaximoSal.equals(grafo.getGradoMaximo())){
			System.out.println("No concuerda el grado maximo de la entrada con la Salida");
			return false;
		
		}
		if(!gradoMinimoSal.equals(grafo.getGradoMinimo())){
			System.out.println("No concuerda el grado minimo de la entrada con la Salida");
			return false;
		}
		
		
		//Verificar que la cantidad de colores de la salida, sea la misma que se uso y verificar que no existen nodos sin colorear
		int [] vectorColores = new int [cantidadColoresSal+1];
		vectorColores[0] =  1;
		
			
		for (int i = 0; i < cantNodosSal; i++) {
			
			vectorColores[nodosSal[i].getColor()] = 1;
			
			
			if(nodosSal[i].getColor()==0){
				System.out.println("Existen nodos sin colorear:" + nodosSal[i].getIndice());
				return false;
			}
			
				
			
		}
		
		for (int i = 0; i < cantidadColoresSal; i++)
			if(vectorColores[i] !=1){
				System.out.println("No se han usado la cantidad de colores que se indican en la salida");
				return false;	
				
			}
		
		// Verificar que los nodos del mismo color, no tienen aristas que los unan
		for (int i = 0; i < (cantNodosSal-1); i++) {
			int aux = i;
			while (aux < (cantNodosSal-1) && nodosSal[aux+1].getColor()==nodosSal[i].getColor() ) {
				
				aux++;
				
				
				//Hay que decrementar los indices siguientes para adaptarlos a la matriz de adyacencia (nuestro indices no toman en cuenta los ceros, pero MatrizSimetrica si)
				if (grafo.getMatrizAdyacencia().isAdyacentes(nodosSal[i].getIndice()-1, nodosSal[aux].getIndice()-1)){
					System.out.println("Existen nodos del mismo color, conectados por una arista");
					return false;
				}
											
			}
						
		}
				
		return true;
	}
	
	
}