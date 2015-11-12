package test;

import algoritmos.Matula;
import algoritmos.SecuencialAleatorio;
import algoritmos.WelshPowell;

public class Test {

	final static String IN = "../LoteDePruebas/IN/";
	final static String OUT = "../LoteDePruebas/OUT/";
	final static String FILE_NAME = "camino";

	public static void main(String[] args) {
		String pathDeEntrada = IN + FILE_NAME + ".in";
		String pathDeSalidaAleatorio = OUT + "SecuencialAleatorio/" + FILE_NAME
				+ ".out";
		String pathDeSalidaMatula = OUT + "Matula/" + FILE_NAME + ".out";
		String pathDeSalidaWelshPowell = OUT + "WelshPowell/" + FILE_NAME
				+ ".out";

		SecuencialAleatorio aleatoria = new SecuencialAleatorio(pathDeEntrada);
		Matula matula = new Matula(pathDeEntrada);
		WelshPowell welshPowell = new WelshPowell(pathDeEntrada);

		aleatoria.colorear();
		aleatoria.generarArchivoSalida(pathDeSalidaAleatorio);

		matula.colorear();
		matula.generarArchivoSalida(pathDeSalidaMatula);

		welshPowell.colorear();
		welshPowell.generarArchivoSalida(pathDeSalidaWelshPowell);

	}
}
