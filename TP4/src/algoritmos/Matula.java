package algoritmos;

import java.util.Arrays;

import model.Grafo;

public class Matula extends Grafo {

	public Matula(String ruta) {
		super(ruta);
	}

	public Matula(Grafo grafo) {
		super(grafo);
	}
	
	@Override
	protected void mix() {
		shuffle();
	}

	@Override
	protected void sort() {
		Arrays.sort(this.nodos);
	}
}
