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
	public void colorear() {
		Arrays.sort(this.nodos, Collections.reverseOrder());

		int color = 0;
		int nodosColoreados = 0;

		cleanNodos();
		shuffle();
		
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
