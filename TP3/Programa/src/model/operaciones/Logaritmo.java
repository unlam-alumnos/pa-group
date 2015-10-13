package model.operaciones;

import model.Funcion;
import model.composite.OperacionUnaria;

public class Logaritmo extends OperacionUnaria {

	public Logaritmo(Funcion operando) {
		super(operando);
	}

	@Override
	public double resolver() {
		return Math.log(operando.resolver());
	}
}
