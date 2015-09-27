package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import model.GeneradorInteger;
import model.elementales.Burbuja;
import model.elementales.Insercion;
import model.noelementales.Fusion;
import model.noelementales.QuickSort;
import model.noelementales.Shell;

public class TestManual {

	private static Integer[] arrayIn = GeneradorInteger.elementosRandom(1000000);
	
	public static void main(String[] args) {

        Integer[] elementos1 = arrayIn;
        Integer[] elementos2 = arrayIn;
        Integer[] elementos3 = arrayIn;        
        Calendar tIni;
        Calendar tFin;
        double diff;
        
        tIni = new GregorianCalendar();
		new Shell().ordenar(elementos1);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("SHELL:" + diff);

		tIni = new GregorianCalendar();
		new Fusion().ordenar(elementos3);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Fusion:" + diff);
		
		tIni = new GregorianCalendar();
		new QuickSort().ordenar(elementos2);
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("QuickSort:" + diff);
	}

}
