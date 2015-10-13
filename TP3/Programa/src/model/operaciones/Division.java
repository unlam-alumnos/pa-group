package model.operaciones;

import model.Funcion;
import model.composite.OperacionBinaria;

public class Division extends OperacionBinaria {

	public Division(Funcion izquierda, Funcion derecha) {
		super(izquierda, derecha);
	}

	@Override
	public double resolver() {
		return izquierda.resolver() / derecha.resolver();
	}
}