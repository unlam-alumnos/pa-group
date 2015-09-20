package test;

import java.util.GregorianCalendar;
import java.util.Calendar;

import model.SEL;

public class Rendimiento {

	public static void main(String[] args) {
		
		String FILE_NAME = "SEL_1500x1500";
		
		SEL sistema = null;
		sistema = new SEL(FILE_NAME+".in");
		
		Calendar tIni = new GregorianCalendar();
		sistema.resolver();
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println(diff);
		sistema.escribirSalida(FILE_NAME+".out");
	}
}