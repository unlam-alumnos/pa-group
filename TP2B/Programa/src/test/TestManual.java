package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import model.GeneradorInteger;
import model.elementales.Burbuja;
import model.elementales.Insercion;
import model.elementales.Seleccion;
import model.noelementales.Fusion;
import model.noelementales.QuickSort;
import model.noelementales.Shell;

public class TestManual {

	private static Integer[] arrayIn = GeneradorInteger.elementosRandom(50000);
	
	public static void main(String[] args) {

        Integer[] elementos1 = Arrays.copyOf(arrayIn,arrayIn.length);
        Integer[] elementos2 = Arrays.copyOf(arrayIn,arrayIn.length);
        Integer[] elementos3 = Arrays.copyOf(arrayIn,arrayIn.length);  
        Integer[] elementos4 = Arrays.copyOf(arrayIn,arrayIn.length);       
        Calendar tIni;
        Calendar tFin;
        double diff;

        tIni = new GregorianCalendar();
		new Burbuja().ordenar(elementos1);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Burbuja:" + diff);

		tIni = new GregorianCalendar();
		new Seleccion().ordenar(elementos2);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Seleccion:" + diff);

		tIni = new GregorianCalendar();
		new Insercion().ordenar(elementos3);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Insercion:" + diff);
		
        
        tIni = new GregorianCalendar();
		new Insercion().ordenarConCentinela(elementos4);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("InsercionConCentinela:" + diff);
		
		
	}

}
