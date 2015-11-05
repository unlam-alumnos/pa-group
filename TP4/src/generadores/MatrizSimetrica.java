package generadores;

import java.io.*;


public class MatrizSimetrica {
	private int cantNodos;
	private int cantAristas;
	private int vector[];

	public MatrizSimetrica(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String[] datos = br.readLine().split(" ");
			cantNodos = Integer.parseInt(datos[0]);
			cantAristas = Integer.parseInt(datos[1]);

			int tamVector = (int) ((Math.pow(cantNodos, 2) - cantNodos) / 2);
			vector = new int[tamVector];

			for (int i = 0; i < cantAristas; i++) {
				datos = br.readLine().split(" ");
				setValueVector(Integer.parseInt(datos[0]),
						Integer.parseInt(datos[1]), 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public MatrizSimetrica(int nodos) {
		this.cantNodos = nodos;
		int tamVector = (int) ((Math.pow(cantNodos, 2) - cantNodos) / 2);
		vector = new int[tamVector];
	}

	
	
	public void setVector (int[][] matriz){
		cantNodos= matriz.length;
		int tamVector = (int) ((Math.pow(cantNodos, 2) - cantNodos) / 2);
		vector = new int[tamVector];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i; j < cantNodos; j++) {
				
				setValueVector(i,j,matriz[i][j]);
				
			}
		}
				
	}
	
	public int[][] getMatrizSimetrica (){
		int [][] matriz = new int[cantNodos][cantNodos];
		
		for (int i = 0; i < cantNodos-1; i++) {
			for (int j = (i+1); j < cantNodos; j++) {
				if(this.getValueVector(i, j)>0)
				matriz[i][j]= 1;
			}
		}
		return matriz;
		
		
		
		
	}
	
	
	
	public void setValueVector(int fila, int columna, int valor) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		
		
		if(fila!=columna){					//magia???
		int indice = (int) (fila * cantNodos + columna - (Math.pow(fila, 2) + 3	* fila + 2) / 2);
		vector[indice] = valor;
		}
	}

	
	public int getValueVector(int fila, int columna) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}

		int indice = (int) (fila * cantNodos + columna - (Math.pow(fila, 2) + 3
				* fila + 2) / 2);
		return vector[indice];
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}
/*
	public static void main(String[] arg) {
		MatrizSimetrica m1 = new MatrizSimetrica(4);
		m1.setValueVector(1, 2, 32);
		System.out.println(m1.getValueVector(1, 2));
	}
	*/

	public void setCantNodos(Integer cantidadNodos) {
		this.cantNodos= cantidadNodos;
		
	}
	public void setCantAristas(Integer cantidadAristas) {
		this.cantAristas= cantidadAristas;
		
	}
}