package edu.unlam.numeroescondido;

import java.io.*;
import java.util.Arrays;

import model.CombinacionNumerica;

public class Main {

	public static void main(String[] args) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int auxLongitud;
		String auxCombinacion;
		CombinacionNumerica N = null;
		CombinacionNumerica M = null;
		int[] posiciones = null;
		char[] auxComparador = null;
		
		try {
			archivo = new File("entrada.in");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			auxLongitud = Integer.parseInt(br.readLine());
			auxCombinacion = br.readLine();
			N = new CombinacionNumerica(auxLongitud,auxCombinacion);
			
			auxLongitud = Integer.parseInt(br.readLine());
			auxCombinacion = br.readLine();
			M = new CombinacionNumerica(auxLongitud,auxCombinacion);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		Arrays.sort(M.getCombinacion());
		
		int indexPosiciones = 0;
		posiciones = new int[N.getLongitud()];

		int porciones = N.getLongitud() - M.getLongitud() + 1;
		for (int i = 0; i < porciones; i++) {
			auxComparador = N.extraeCombinacion(i, M.getLongitud());
			Arrays.sort(auxComparador);
			
			if (Arrays.equals(M.getCombinacion(), auxComparador)){
				posiciones[indexPosiciones] = i;
				indexPosiciones++;
			}
		}
				
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("salida.out");
			pw = new PrintWriter(fichero);

			if (indexPosiciones > 0) {
				pw.println("SI " + indexPosiciones);
				String auxPosiciones = new String();
				for (int i = 0; i < indexPosiciones; i++) {
					auxPosiciones += posiciones[i] + " ";	
				}
				auxPosiciones = auxPosiciones.substring(0,auxPosiciones.length()-1);
				pw.println(auxPosiciones);
			}else{
				pw.println("NO");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
