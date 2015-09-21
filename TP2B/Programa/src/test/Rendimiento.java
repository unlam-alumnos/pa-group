package test;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;

import model.elementales.Burbuja;
import model.elementales.Insercion;
import model.elementales.Seleccion;
import model.noelementales.Fusion;
import model.noelementales.QuickSort;
import model.noelementales.Shell;


public class Rendimiento {
	
	private static int[] dimensiones = {10,100,500,1000,1500,2000,3000,4000,5000,6000,7000,8000,10000,20000,50000,100000};
	
	private static long burbuja(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Burbuja().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static long insercion(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Insercion().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static long insercionConCentinela(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Insercion().ordenarConCentinela(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static long seleccion(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Seleccion().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}
	
	private static long shell(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Shell().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static long quickSort(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new QuickSort().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}

	private static long fusion(Comparable[] elementos){
		
		Calendar tIni = new GregorianCalendar();
		new Fusion().ordenar(elementos);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		return diff;
	}
	
	private static void ordenados(){
		Integer[] elementos;
		
		long tBurbuja = 0;
		long tInsercion1 = 0;
		long tInsercion2 = 0;
		long tSeleccion = 0;
		long tShell = 0;
		long tQuickSort = 0;
		long tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			elementos = Generador.elementosOrdenados(dimensiones[i]);
			tBurbuja = burbuja(elementos);
			tInsercion1 = insercion(elementos);
			tInsercion2 = insercionConCentinela(elementos);
			tSeleccion = seleccion(elementos);
			tShell = shell(elementos);
			tQuickSort = quickSort(elementos);
			tFusion = fusion(elementos);
			System.out.println("Dimension: " + dimensiones[i]);
			System.out.println("\tBurbuja: " + tBurbuja);
			System.out.println("\tInsercion1: " + tInsercion1);
			System.out.println("\tInsercion2: " + tInsercion2);
			System.out.println("\tSeleccion: " + tSeleccion);
			System.out.println("\tShell: " + tShell);
			System.out.println("\tQuickSort: " + tQuickSort);
			System.out.println("\tFusion: " + tFusion);
		}
	}

	private static void ordenInverso(){
		Integer[] elementos;
		
		long tBurbuja = 0;
		long tInsercion1 = 0;
		long tInsercion2 = 0;
		long tSeleccion = 0;
		long tShell = 0;
		long tQuickSort = 0;
		long tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			elementos = Generador.elementosOrdenInverso(dimensiones[i]);
			tBurbuja = burbuja(elementos);
			tInsercion1 = insercion(elementos);
			tInsercion2 = insercionConCentinela(elementos);
			tSeleccion = seleccion(elementos);
			tShell = shell(elementos);
			tQuickSort = quickSort(elementos);
			tFusion = fusion(elementos);
			System.out.println("Dimension: " + dimensiones[i]);
			System.out.println("\tBurbuja: " + tBurbuja);
			System.out.println("\tInsercion1: " + tInsercion1);
			System.out.println("\tInsercion2: " + tInsercion2);
			System.out.println("\tSeleccion: " + tSeleccion);
			System.out.println("\tShell: " + tShell);
			System.out.println("\tQuickSort: " + tQuickSort);
			System.out.println("\tFusion: " + tFusion);
		}
	}

	private static void ordenRandom(){
		Integer[] elementos;
		
		long tBurbuja = 0;
		long tInsercion1 = 0;
		long tInsercion2 = 0;
		long tSeleccion = 0;
		long tShell = 0;
		long tQuickSort = 0;
		long tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			elementos = Generador.elementosRandom(dimensiones[i]);
			tBurbuja = burbuja(elementos);
			tInsercion1 = insercion(elementos);
			tInsercion2 = insercionConCentinela(elementos);
			tSeleccion = seleccion(elementos);
			tShell = shell(elementos);
			tQuickSort = quickSort(elementos);
			tFusion = fusion(elementos);
			System.out.println("Dimension: " + dimensiones[i]);
			System.out.println("\tBurbuja: " + tBurbuja);
			System.out.println("\tInsercion1: " + tInsercion1);
			System.out.println("\tInsercion2: " + tInsercion2);
			System.out.println("\tSeleccion: " + tSeleccion);
			System.out.println("\tShell: " + tShell);
			System.out.println("\tQuickSort: " + tQuickSort);
			System.out.println("\tFusion: " + tFusion);
		}
	}
	
	public static void main(String[] args) {
		
		//ordenRandom();
		//ordenInverso();
		ordenados();
	}
	
}