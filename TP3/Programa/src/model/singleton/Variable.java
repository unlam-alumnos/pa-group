package model.singleton;

import model.Funcion;

public abstract class Variable implements Funcion{

	private double valor;
	
	protected Variable(double valor){
		this.valor = valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor(){
		return this.valor;
	}

	@Override
	public double resolver() {
		return valor;
	}
}
