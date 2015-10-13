package model.composite;

import model.Funcion;


public abstract class OperacionUnaria implements Funcion {
	
	protected Funcion operando;
	
	public OperacionUnaria(Funcion operando) {
		super();
		this.operando = operando;
	}

	@Override
	public double resolver() {
		return operando.resolver();
	}	
}
