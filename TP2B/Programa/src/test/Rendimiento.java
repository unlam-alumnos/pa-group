package test;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;

import model.elementales.Burbuja;
import model.elementales.Insersion;


public class Rendimiento {

	public static void main(String[] args) {
		
		Integer[] elementos = Generador.elementosRandom(100);
		//System.out.println(Arrays.toString(elementos));
		
		Calendar tIni = new GregorianCalendar();
		//new Burbuja().sort(elementos);
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println(diff);
		//System.out.println(Arrays.toString(elementos));
	}
}