package model;

public class Constante implements Funcion{

	private double valor;
	
	public Constante(double valor){
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
