package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.GeneradorInteger;
import model.noelementales.QuickSort;

public class TestManual {

	private static Integer[] arrayIn = GeneradorInteger.elementosRandom(50000);
	
	public static void main(String[] args) {

        Integer[] elements = arrayIn;        
        
        Calendar tIni = new GregorianCalendar();
        
		//new QuickSort().ordenar(elements);
		
		Calendar tFin = new GregorianCalendar();
		
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		
		System.out.println(diff);
	}

}
