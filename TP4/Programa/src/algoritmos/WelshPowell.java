package algoritmos;

import java.util.Arrays;
import java.util.Collections;

import model.Grafo;

public class WelshPowell extends Grafo {

	public WelshPowell(String ruta) {
		super(ruta);
	}

	public WelshPowell(Grafo grafo) {
		super(grafo);
	}

	@Override
	protected void mix() {
		shuffle();
	}

	@Override
	protected void sort() {
		Arrays.sort(this.nodos, Collections.reverseOrder());
	}
}
