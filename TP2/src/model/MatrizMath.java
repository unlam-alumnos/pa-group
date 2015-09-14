package model;

import java.util.Arrays;

import exception.DistDimException;

public class MatrizMath {
	
	private int filas;
	private int columnas;
	private double[][] matriz;
	

	public MatrizMath(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new double[filas][columnas];
	}
	
	public void add(int fila, int columna, double valor){
		this.matriz[fila][columna] = valor;
	}
	
	public MatrizMath sumar(MatrizMath mat) throws DistDimException{
		if(this.filas != mat.filas || this.columnas != mat.columnas){
			throw new DistDimException("Distintas dimensiones");
		}
		
		MatrizMath aux = new MatrizMath(this.filas,this.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			
			for (int c = 0; c < this.columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c] + mat.matriz[f][c];
			}
		}
		return aux;
	}
	
	public MatrizMath restar(MatrizMath mat) throws DistDimException{
		if(this.filas != mat.filas || this.columnas != mat.columnas){
			throw new DistDimException("Distintas dimensiones");
		}
		
		MatrizMath aux = new MatrizMath(this.filas,this.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			
			for (int c = 0; c < this.columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c] - mat.matriz[f][c];
			}
		}
		return aux;
	}

	public MatrizMath multiplicar(MatrizMath mat) throws DistDimException{
		if(this.filas != mat.columnas || this.columnas != mat.filas){
			throw new DistDimException("Distintas dimensiones");
		}
		
		MatrizMath aux = new MatrizMath(this.filas,mat.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < mat.columnas; c++) {
				for (int i = 0; i < this.columnas; i++) {
					aux.matriz[f][c] += this.matriz[f][i] * mat.matriz[i][c];
				}
			}
		}
		return aux;
	}
	
	public MatrizMath multiplicar(float flotante) throws DistDimException{
		
		MatrizMath aux = new MatrizMath(this.filas,this.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			
			for (int c = 0; c < this.columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c] * flotante;
			}
		}
		return aux;
	}
	
	public VectorMath multiplicar(VectorMath vec) {
		if (vec.getDim() != this.columnas)
			throw new DistDimException(" Distinta Dimension ");
		
		return vec.multiplicar(this);
	}

	public double getDeterminante(){
		MatrizMath aux = this.clone();
		
        for(int k=0; k<filas-1; k++){
            for(int i=k+1; i<filas; i++){
                for(int j=k+1; j<filas; j++){
                    aux.matriz[i][j]-=aux.matriz[i][k]*aux.matriz[k][j]/aux.matriz[k][k];
                }
            }
        }
        
        double determinante = 1.0;
        for(int i=0; i<filas; i++){
        	determinante *= aux.matriz[i][i];
        }
        return determinante;		
	}
	
	public MatrizMath getInversa() throws Exception {

		if (this.getDeterminante() == 0)
			throw new Exception("La matriz no posee inversa");

		int i, j, k;
		double escalar;
		MatrizMath aux = this.clone();
		MatrizMath inversa = new MatrizMath(this.filas, this.columnas);

		for (i = 0; i < this.filas; i++)
			inversa.add(i, i, 1);

		for (k = 0; k < this.filas; k++) {
			if (aux.getCoordMatriz(k, k) == 0) {
				i = k;
				while (aux.getCoordMatriz(i, k) == 0 && i < this.filas - k)
					i++;
				for (j = 0; j < this.filas; j++) {
					aux.add(k, j, aux.getCoordMatriz(k, j) + aux.getCoordMatriz(i, j));
					inversa.add(k, j, inversa.getCoordMatriz(k,j) + inversa.getCoordMatriz(i, j));
				}
			}
			escalar = aux.getCoordMatriz(k, k);
			for (j = 0; j < this.filas; j++) {
				aux.add(k, j, aux.getCoordMatriz(k, j) * (1 / escalar));
				inversa.add(k, j, inversa.getCoordMatriz(k, j) * (1 / escalar));
			}
			for (i = k + 1; i < this.filas; i++) {
				escalar = aux.getCoordMatriz(i, k);
				for (j = 0; j < this.filas; j++) {
					aux.add(i, j, aux.getCoordMatriz(i, j) - escalar * aux.getCoordMatriz(k, j));
					inversa.add(i, j, inversa.getCoordMatriz(i, j) - escalar * inversa.getCoordMatriz(k, j));
				}
			}
		}
		for (k = 0; k < this.filas - 1; k++){
			for (i = 1; i < this.filas - k; i++) {
				escalar = aux.getCoordMatriz(k, k + i);
				for (j = 0; j < this.filas; j++) {
					aux.add(k, j, aux.getCoordMatriz(k, j) - escalar * aux.getCoordMatriz(k + i, j));
					inversa.add(k, j, inversa.getCoordMatriz(k, j) - escalar * inversa.getCoordMatriz(k + i, j));
				}
			}
		}
		return inversa;
	}
	
	public MatrizMath clone() {
		MatrizMath aux = new MatrizMath(filas,columnas);

		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c];
			}
		}
		return aux;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columnas;
		result = prime * result + filas;
		result = prime * result + Arrays.hashCode(matriz);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrizMath other = (MatrizMath) obj;
		if (columnas != other.columnas)
			return false;
		if (filas != other.filas)
			return false;
		if (!Arrays.deepEquals(matriz, other.matriz))
			return false;
		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < this.columnas; c++) {
				double diff = this.matriz[f][c] = other.matriz[f][c];
				if (Math.abs(diff) >= Math.pow(10, -12))
					return false;
			}
		}
		return true;
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer results = new StringBuffer();
		String separator = ",";

		for (int i = 0; i < this.filas; ++i)
		{
		  results.append('[');
		  for (int j = 0; j < this.columnas; ++j)
		    if (j > 0)
		      results.append(matriz[i][j]);
		    else
		      results.append(matriz[i][j]).append(separator);
		  results.append(']');
		}
		
		return results.toString();
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public double[][] getMatriz() {
		return matriz;
	}
	
	public double getCoordMatriz(int f, int c){
		return matriz[f][c];
	}
}
