package programaProbadorColoreo;

import java.io.*;

import trash.Grafo;

public class ProgramaProbadorColoreo {

	private Grafo grafo;
	private int[] vectorColoreo;
	private int cantNodos;
	private final static int inf = 100000;

	public void leerArchivos(String entrada, String salida) {

		grafo = new Grafo(entrada);
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] datos;

		try {
			archivo = new File(salida);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			datos = br.readLine().split(" ");
			cantNodos = Integer.parseInt(datos[0]);
			vectorColoreo = new int[cantNodos];
			for (int i = 0; i < cantNodos; i++) {
				datos = br.readLine().split(" ");
				int nodo = Integer.parseInt(datos[0]);
				vectorColoreo[nodo] = Integer.parseInt(datos[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean bienColoreado() {
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if (grafo.getMatrizAdy()[i][j] != inf) {
					if (vectorColoreo[i] == vectorColoreo[j])
						return false;
				}
			}
		}
		return true;

	}

	public static void main(String[] args) {
		ProgramaProbadorColoreo p1 = new ProgramaProbadorColoreo();
		p1.leerArchivos("Prim con matriz 200 nodos 50% ady.out",
				"coloreado.out");

		// for (int i = 0; i <p1.grafo.getCantNodos() ;i++) {
		// System.out.println("");
		// for (int j = 0; j < p1.grafo.getCantNodos(); j++)
		// System.out.print(p1.grafo.getMatrizAdy()[i][j] + "\t");
		//
		// }
		//

		if (p1.bienColoreado()) {
			System.out.println("\nEsta bien coloreado");
		} else {
			System.out.println("Esta mal coloreado");
		}
	}

}
