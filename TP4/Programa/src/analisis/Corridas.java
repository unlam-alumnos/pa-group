package analisis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import model.GrafoNDNP;

public class Corridas {
	final static String FILE_NAME = "grafoRegular_1000_75ady";
	final static String DIR_OUT = "src/analisis/OUT/";
	final static String DIR_IN = "src/analisis/IN/";
	final static String DIR_PLOT = "src/analisis/PLOT/";
	final static int corridas = 1000; 
			
	public static void main(String[] args) {
		GrafoNDNP grafo = new GrafoNDNP(DIR_IN + FILE_NAME + ".in");
		corrida("SecuencialAleatorio", grafo);
		corrida("Matula", grafo);
		corrida("WelshPowell", grafo);
	}
	
	public static void corrida(String directorio, GrafoNDNP grafo){
		int[] frecuenciaDeColor = new int[grafo.getCantidadNodos()];
		Arrays.fill(frecuenciaDeColor, 0);
		boolean first = true;
		int corridaMenorColor = corridas;
		int menorColor = grafo.getCantidadNodos();
		String pathSalida = DIR_OUT + directorio + "/" + FILE_NAME + ".out";
				
		for (int i = 0; i < corridas; i++) {
			System.out.println(i);
			switch (directorio) {
				case "SecuencialAleatorio":
					grafo.coloreoSecuencialAleatorio();
					break;
				case "Matula":
					grafo.coloreoMatula();
					break;
				case "WelshPowell":
					grafo.coloreoWelshPowell();
					break;
				default:
					break;
			}
			
			if (first) {
				corridaMenorColor = i;
				menorColor = grafo.getCantidadColores();
				grafo.exportarResultado(pathSalida);
				first = false;
			}else{
				if (menorColor > grafo.getCantidadColores()) {
					corridaMenorColor = i;
					menorColor = grafo.getCantidadColores();
					grafo.exportarResultado(pathSalida);
				}
			}
			frecuenciaDeColor[grafo.getCantidadColores()]++;
		}
		exportarPlotExcel(directorio, frecuenciaDeColor, corridaMenorColor);
	}
	
	public static void exportarPlotExcel(String directorio, int[] frecuenciaDeColor, int corridaMenorColor){
		FileWriter fw = null;
		PrintWriter pw = null;
		String ruta = DIR_PLOT + directorio + "/" + FILE_NAME + ".plot";
		System.out.println(ruta);
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			pw.println(corridaMenorColor);
			for (int i = 0; i < frecuenciaDeColor.length; i++) {
				pw.println(frecuenciaDeColor[i]);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
