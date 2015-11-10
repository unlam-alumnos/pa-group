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
	public void colorear() {
		int color = 0;
		int nodosColoreados = 0;

		cleanNodos();
		shuffle(0, cantidadNodos - 1);
		
		while (nodosColoreados < cantidadNodos) {
			color++;
			for (int indice = 0; indice < cantidadNodos; indice++) {
				if (nodos[indice].getColor() == 0
						&& !(puedoColorear(nodos[indice].getIndice(), color))) {
					nodos[indice].setColor(color);
					nodosColoreados++;
				}
			}
		}

		if (color < cantidadColores) {
			cantidadColores = color;
		}
	}
}