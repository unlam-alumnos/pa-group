package model.operaciones;

import model.Funcion;
import model.composite.OperacionBinaria;

public class Potenciacion extends OperacionBinaria{
	
	public Potenciacion(Funcion izquierda, Funcion derecha) {
		super(izquierda, derecha);
	}

	@Override
	public double resolver() {
		return Math.pow(izquierda.resolver(), derecha.resolver());
	}
	
}
