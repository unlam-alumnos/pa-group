package model.composite;

public abstract class OperacionBinaria implements Funcion {

	protected Funcion izquierda;
	protected Funcion derecha;
	
	public OperacionBinaria(Funcion izquierda, Funcion derecha) {
		super();
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	@Override
	public abstract double resolver();
}
