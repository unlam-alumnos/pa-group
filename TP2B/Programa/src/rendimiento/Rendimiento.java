package rendimiento;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;

import model.GeneradorInteger;
import model.elementales.Burbuja;
import model.elementales.Insercion;
import model.elementales.Seleccion;
import model.noelementales.Fusion;
import model.noelementales.QuickSort;
import model.noelementales.Shell;


public class Rendimiento {
	
	private static int[] dimensiones = {10,100,1000,2000,3000,4000,5000,6000,7000,8000,10000,20000,50000,100000};
	
	private static double burbuja(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Burbuja().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static double insercion(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Insercion().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static double insercionConCentinela(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Insercion().ordenarConCentinela(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static double seleccion(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Seleccion().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}
	
	private static double shell(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Shell().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static double quickSort(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new QuickSort().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static double fusion(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Fusion().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}
	
	private static void ordenados(){
		Integer[] elementos;
		
		double tBurbuja = 0;
		double tInsercion1 = 0;
		double tInsercion2 = 0;
		double tSeleccion = 0;
		double tShell = 0;
		double tQuickSort = 0;
		double tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			Integer[] elementos1 = GeneradorInteger.elementosOrdenados(dimensiones[i]);
			Integer[] elementos2 = elementos1.clone();
			Integer[] elementos3 = elementos1.clone();
			Integer[] elementos4 = elementos1.clone();
			Integer[] elementos5 = elementos1.clone();
			Integer[] elementos6 = elementos1.clone();
			Integer[] elementos7 = elementos1.clone();
			
			tBurbuja = burbuja(elementos1);
			tInsercion1 = insercion(elementos2);
			tInsercion2 = insercionConCentinela(elementos3);
			tSeleccion = seleccion(elementos4);
			tShell = shell(elementos5);
			tQuickSort = quickSort(elementos6);
			tFusion = fusion(elementos7);
			System.out.println("Dimension: " + dimensiones[i]);
			System.out.println("\tBurbuja: " + tBurbuja);
			System.out.println("\tSeleccion: " + tSeleccion);
			System.out.println("\tInsercion1: " + tInsercion1);
			System.out.println("\tInsercion2: " + tInsercion2);
			System.out.println("\tShell: " + tShell);
			System.out.println("\tQuickSort: " + tQuickSort);
			System.out.println("\tFusion: " + tFusion);
		}
	}

	private static void ordenInverso(){
		Integer[] elementos;
		
		double tBurbuja = 0;
		double tInsercion1 = 0;
		double tInsercion2 = 0;
		double tSeleccion = 0;
		double tShell = 0;
		double tQuickSort = 0;
		double tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			Integer[] elementos1 = GeneradorInteger.elementosOrdenInverso(dimensiones[i]);
			Integer[] elementos2 = elementos1.clone();
			Integer[] elementos3 = elementos1.clone();
			Integer[] elementos4 = elementos1.clone();
			Integer[] elementos5 = elementos1.clone();
			Integer[] elementos6 = elementos1.clone();
			Integer[] elementos7 = elementos1.clone();
			
			tBurbuja = burbuja(elementos1);
			tInsercion1 = insercion(elementos2);
			tInsercion2 = insercionConCentinela(elementos3);
			tSeleccion = seleccion(elementos4);
			tShell = shell(elementos5);
			tQuickSort = quickSort(elementos6);
			tFusion = fusion(elementos7);
			System.out.println("Dimension: " + dimensiones[i]);
			System.out.println("\tBurbuja: " + tBurbuja);
			System.out.println("\tSeleccion: " + tSeleccion);
			System.out.println("\tInsercion1: " + tInsercion1);
			System.out.println("\tInsercion2: " + tInsercion2);
			System.out.println("\tShell: " + tShell);
			System.out.println("\tQuickSort: " + tQuickSort);
			System.out.println("\tFusion: " + tFusion);
		}
	}

	private static void ordenRandom(){
		double tBurbuja = 0;
		double tInsercion1 = 0;
		double tInsercion2 = 0;
		double tSeleccion = 0;
		double tShell = 0;
		double tQuickSort = 0;
		double tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			Integer[] elementos1 = GeneradorInteger.elementosRandom(dimensiones[i]);
			Integer[] elementos2 = elementos1.clone();
			Integer[] elementos3 = elementos1.clone();
			Integer[] elementos4 = elementos1.clone();
			Integer[] elementos5 = elementos1.clone();
			Integer[] elementos6 = elementos1.clone();
			Integer[] elementos7 = elementos1.clone();
			
			tBurbuja = burbuja(elementos1);
			tInsercion1 = insercion(elementos2);
			tInsercion2 = insercionConCentinela(elementos3);
			tSeleccion = seleccion(elementos4);
			tShell = shell(elementos5);
			tQuickSort = quickSort(elementos6);
			tFusion = fusion(elementos7);
			System.out.println("Dimension: " + dimensiones[i]);
			System.out.println("\tBurbuja: " + tBurbuja);
			System.out.println("\tSeleccion: " + tSeleccion);
			System.out.println("\tInsercion1: " + tInsercion1);
			System.out.println("\tInsercion2: " + tInsercion2);
			System.out.println("\tShell: " + tShell);
			System.out.println("\tQuickSort: " + tQuickSort);
			System.out.println("\tFusion: " + tFusion);
		}
	}
	
	public static void main(String[] args) {
		
		//ordenRandom();
		//ordenInverso();
		//ordenados();
	}
	
}