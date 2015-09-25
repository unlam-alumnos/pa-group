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
			elementos = GeneradorInteger.elementosOrdenados(dimensiones[i]);
			tBurbuja = burbuja(elementos);
			tInsercion1 = insercion(elementos);
			tInsercion2 = insercionConCentinela(elementos);
			tSeleccion = seleccion(elementos);
			tShell = shell(elementos);
			tQuickSort = quickSort(elementos);
			tFusion = fusion(elementos);
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
			elementos = GeneradorInteger.elementosOrdenInverso(dimensiones[i]);
			tBurbuja = burbuja(elementos);
			tInsercion1 = insercion(elementos);
			tInsercion2 = insercionConCentinela(elementos);
			tSeleccion = seleccion(elementos);
			tShell = shell(elementos);
			tQuickSort = quickSort(elementos);
			tFusion = fusion(elementos);
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
		Integer[] elementos;
		
		double tBurbuja = 0;
		double tInsercion1 = 0;
		double tInsercion2 = 0;
		double tSeleccion = 0;
		double tShell = 0;
		double tQuickSort = 0;
		double tFusion = 0;
		
		for (int i = 0; i < dimensiones.length; i++) {
			elementos = GeneradorInteger.elementosRandom(dimensiones[i]);
			tBurbuja = burbuja(elementos);
			tInsercion1 = insercion(elementos);
			tInsercion2 = insercionConCentinela(elementos);
			tSeleccion = seleccion(elementos);
			tShell = shell(elementos);
			tQuickSort = quickSort(elementos);
			tFusion = fusion(elementos);
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