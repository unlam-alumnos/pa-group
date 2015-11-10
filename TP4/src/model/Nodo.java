package model;

public class Nodo {
	private int indice;
	private int color;
	private int grado;
	
	public Nodo(int indice, int color, int grado) {
		this.indice = indice;
		this.color = color;
		this.grado = grado;
	}

	public int getIndice() {
		return indice;
	}

	public int getColor() {
		return color;
	}

	public int getGrado() {
		return grado;
	}
}
