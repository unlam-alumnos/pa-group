package operaciones;

import model.composite.Funcion;
import model.composite.OperacionBinaria;

public class Multiplicacion extends OperacionBinaria{

	public Multiplicacion(Funcion izquierda, Funcion derecha) {
		super(izquierda, derecha);
	}

	@Override
	public double resolver() {
		return izquierda.resolver() * derecha.resolver();
	}
}
