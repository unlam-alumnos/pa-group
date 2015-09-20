package test;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Calendar;

import model.Ordenadora;

public class Rendimiento {

	public static void main(String[] args) {
		int[] vector = {8,15,8,4,7,-1,12,0};
		Ordenadora ordenadora = new Ordenadora(vector);
		
		Calendar tIni = new GregorianCalendar();
		ordenadora.seleccion();
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println(diff);
		System.out.println(Arrays.toString(ordenadora.getVector()));
		//sistema.escribirSalida(FILE_NAME+".out");
	}
}