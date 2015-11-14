package test;

import model.GrafoNDNP;

public class Main {

	final static String DIR_IN = "../LoteDePruebas/IN/";
	final static String DIR_OUT = "../LoteDePruebas/OUT";
	final static String FILE_NAME = "camino";

	public static void main(String[] args) {
		
		String pathDeEntrada = DIR_IN + FILE_NAME + ".in";
		String pathDeSalidaAleatorio = DIR_OUT + "SecuencialAleatorio/" + FILE_NAME + ".out";
		String pathDeSalidaMatula = DIR_OUT + "Matula/" + FILE_NAME + ".out";
		String pathDeSalidaWelshPowell = DIR_OUT + "WelshPowell/" + FILE_NAME + ".out";

		GrafoNDNP grafo = new GrafoNDNP(pathDeEntrada);

		grafo.coloreoSecuencialAleatorio();
		grafo.exportarResultado(pathDeSalidaAleatorio);

		grafo.coloreoMatula();
		grafo.exportarResultado(pathDeSalidaMatula);

		grafo.coloreoWelshPowell();
		grafo.exportarResultado(pathDeSalidaWelshPowell);	
	}
}
