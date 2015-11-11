package algoritmos;

import model.Grafo;

public class SecuencialAleatorio extends Grafo {

	public SecuencialAleatorio(String ruta) {
		super(ruta);
	}

	public SecuencialAleatorio(Grafo grafo) {
		super(grafo);
	}

	@Override
	protected void mix() {
		shuffle(0, cantidadNodos - 1);
	}
}