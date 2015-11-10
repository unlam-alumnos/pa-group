package model;


public class MatrizSimetrica {
	private boolean vector[];
	
	public MatrizSimetrica(int cantNodos) {
		this.vector = new boolean[cantNodos * 2];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = false;
		}
	}
	
	public void setNodo(int nodoOrigen, int nodoDestino){
		if (nodoOrigen != nodoDestino) {
			int pos = getPosicionVector(nodoOrigen, nodoDestino);
			vector[pos] = true;
		}		
	}
	
	public int getPosicionVector(int nodoOrigen, int nodoDestino){
		return (int) (nodoOrigen * vector.length/2 + nodoDestino - ( Math.pow(nodoOrigen, 2) + 3 * nodoOrigen + 2) / 2);
	}
	
	public boolean isAdyacentes(int nodoOrigen, int nodoDestino){
		return this.vector[this.getPosicionVector(nodoOrigen, nodoDestino)];
	}

}