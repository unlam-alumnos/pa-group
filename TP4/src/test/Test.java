package test;

import java.io.File;
import java.io.PrintWriter;

import algoritmos.Matula;
import algoritmos.SecuencialAleatorio;
import algoritmos.WelshPowell;
import model.Generador;
import model.Grafo;
import model.MatrizSimetrica;

public class Test {

	public static void main(String[] args) {
		final int corridas = 100;
		final int tamanoVectorColores = 600;
		final int[] vecColoreoMatula = new int[tamanoVectorColores];
		final int[] vecColoreoSecAleatorio = new int[tamanoVectorColores];
		final int[] vecColoreoWelshPowell = new int[tamanoVectorColores];

		int cantMenorColoresMatula = tamanoVectorColores;
		int cantMenorColoresSecAleatorio = tamanoVectorColores;
		int cantMenorColoresWelshPowell = tamanoVectorColores;

		int matulaCantColores = 0;
		int secAleatorioCantColores = 0;
		int welshPowellCantColores = 0;

		Matula matula = null;
		SecuencialAleatorio secuencialAleatorio = null;
		WelshPowell welshPowell = null;

		File salida1 = new File("OUT_40ady/SalidaMatula.out");
		File salida2 = new File("OUT_40ady/SalidaSecuencialAleatorio.out");
		File salida3 = new File("OUT_40ady/SalidaWelshPowell.out");

		Grafo g1 = new Grafo("grafo1.in");
		MatrizSimetrica matrizAdyacencia = new MatrizSimetrica(
				g1.getCantidadNodos());
		matrizAdyacencia.setCantAristas(g1.getCantidadAristas());
		matrizAdyacencia.setVector(g1.getMatrizAdyacencia().getVector());

		for (int i = 1; i <= corridas; i++) {
			g1.desordenarNodos();
			
			// coloreamos usando los 3 algoritmos
			matula = new Matula(g1, matrizAdyacencia);
			secuencialAleatorio = new SecuencialAleatorio(g1, matrizAdyacencia);
			welshPowell = new WelshPowell(g1, matrizAdyacencia);

			matula.colorear();
			secuencialAleatorio.colerear();
			welshPowell.colorear();

			matulaCantColores = matula.getCantidadColores();
			secAleatorioCantColores = secuencialAleatorio.getCantidadColores();
			welshPowellCantColores = welshPowell.getCantidadColores();

			// Actualizamos los vectores de cantidad de colores de cada
			// algoritmo
			vecColoreoMatula[matulaCantColores]++;
			vecColoreoSecAleatorio[secAleatorioCantColores]++;
			vecColoreoWelshPowell[welshPowellCantColores]++;

			// Imprimimos en pantalla el numero de corrida actual
			System.out.println("Corrida actual:" + i);

			// Vemos si este fue el mejor caso de Matula, y lo guardamos
			if (matulaCantColores < cantMenorColoresMatula) {
				// System.out.println("Vemos si este fue el mejor caso de Matula, y lo guardamos");
				matula.generarArchivoSalida(salida1);
				cantMenorColoresMatula = matulaCantColores;
			}
			// Vemos si este fue el mejor caso de Secuencial Aleatorio, y lo
			// guardamos
			if (secAleatorioCantColores < cantMenorColoresSecAleatorio) {
				// System.out.println("Vemos si este fue el mejor caso de Secuencial Aleatorio, y lo guardamos");
				secuencialAleatorio.generarArchivoSalida(salida2);
				cantMenorColoresSecAleatorio = secAleatorioCantColores;
			}
			// Vemos si este fue el mejor caso de Welsh Powell, y lo guardamos
			if (welshPowellCantColores < cantMenorColoresWelshPowell) {
				// System.out.println("Vemos si este fue el mejor caso de Welsh Powell, y lo guardamos");
				welshPowell.generarArchivoSalida(salida3);
				cantMenorColoresWelshPowell = welshPowellCantColores;
			}

		}

		// Despues de hacer las 10000 corridas, grabamos los vectores de
		// cantidad de colores
		File archivoMatula = null;
		PrintWriter pwMatula = null;
		File archivoSecAle = null;
		PrintWriter pwSecAle = null;
		File archivoWelshPowell = null;
		PrintWriter pwWelshPowell = null;

		try {
			archivoMatula = new File("vecColoreoMatula_" + corridas + ".txt");
			pwMatula = new PrintWriter(archivoMatula);
			archivoSecAle = new File("vecColoreoSecuencialAleatorio_"
					+ corridas + ".txt");
			pwSecAle = new PrintWriter(archivoSecAle);
			archivoWelshPowell = new File("vecColoreoWelshPowell_" + corridas
					+ ".txt");
			pwWelshPowell = new PrintWriter(archivoWelshPowell);

			// Grabamos la primer linea (cantNodos, cantColores, cantAristas,
			// %Ady, gradoMax, gradoMin)
			pwMatula.println(matula.getCantidadNodos() + " "
					+ matula.getCantidadColores() + " "
					+ matula.getCantidadAristas() + " "
					+ matula.getPorcentajeAdyacencia() + " "
					+ matula.getMaximoGrado() + " " + matula.getMinimoGrado());
			pwWelshPowell.println(secuencialAleatorio.getCantidadNodos() + " "
					+ secuencialAleatorio.getCantidadColores() + " "
					+ secuencialAleatorio.getCantidadAristas() + " "
					+ secuencialAleatorio.getPorcentajeAdyacencia() + " "
					+ secuencialAleatorio.getMaximoGrado() + " "
					+ secuencialAleatorio.getMinimoGrado());
			pwSecAle.println(welshPowell.getCantidadNodos() + " "
					+ welshPowell.getCantidadColores() + " "
					+ welshPowell.getCantidadAristas() + " "
					+ welshPowell.getPorcentajeAdyacencia() + " "
					+ welshPowell.getMaximoGrado() + " "
					+ welshPowell.getMinimoGrado());

			// grabamos el vector de cantidad de colores REVISAR CONDICION DEL
			// FOR!!!
			for (int i = 0; i < tamanoVectorColores; i++) {
				pwMatula.println(i + "	" + vecColoreoMatula[i]);
				pwWelshPowell.println(i + "	" + vecColoreoWelshPowell[i]);
				pwSecAle.println(i + "	" + vecColoreoSecAleatorio[i]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pwMatula.close();
				pwSecAle.close();
				pwWelshPowell.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
