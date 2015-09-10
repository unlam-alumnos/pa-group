package model;

import java.util.Arrays;

public class CombinacionNumerica{
	
	private int longitud;
	private char[] combinacion;
	
	public CombinacionNumerica(int longitud, String combinacion) {
		super();
		this.longitud = longitud;
		this.combinacion = new char[this.longitud];
		for (int i = 0; i < combinacion.length(); i++) {
			this.combinacion[i] = combinacion.charAt(i);
		}
		
	}
	
	public char[] extraeCombinacion(int indice, int longitud){
		char[] aux = new char[longitud];
		
		for (int i = 0; i < aux.length; i++) {
			aux[i] = this.combinacion[i+indice];
		}
		
		return aux;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(combinacion);
	}
	
	public char[] getCombinacion() {
		return combinacion;
	}

	public int getLongitud() {
		return longitud;
	}

}
