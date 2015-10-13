package ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * Esta seria mi clase SINGLETON, la cual tiene una unica instancia.
 * La misma contiene la expresion de la funcion que debo analizar en los 's' puntos indicados.
 */

public class FuncionRPN {

	private String funcion;
	private int cantVariables;
	private int cantPuntos;
	private Double[] salida;
	private String[] puntos;
	
	
	public FuncionRPN(String pathfile) {
		super();
		
		File archivo;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(pathfile);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String datos[];
			funcion = br.readLine();
			datos = br.readLine().split(" ");
			cantVariables = Integer.parseInt(datos[0]);
			cantPuntos = Integer.parseInt(datos[1]);
			puntos = new String[cantPuntos];
			salida = new Double[cantPuntos];
			for (int i = 0; i < cantPuntos; i++) {
				puntos[i] = br.readLine();
			}
		}
		catch (Exception e) {
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
	}
	
	public void escribirSalida(String pathFile){
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(pathFile);
			pw = new PrintWriter(fichero);

			pw.println(salida.length);
			for (int i = 0; i < salida.length; i++)
				pw.println(salida[i]);

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
	
	public void resolver(){
		for (int i = 0; i < puntos.length; i++) {
			double resultado = 0;
			String[] variables = puntos[i].split(" ");
			if (cantVariables == 3) {
				resultado = RPN.resolver(RPN.generarFuncion(funcion), 	Double.parseDouble(variables[0]), Double.parseDouble(variables[1]), Double.parseDouble(variables[2]));
			}else if (cantVariables == 2) {
				resultado = RPN.resolver(RPN.generarFuncion(funcion), 	Double.parseDouble(variables[0]), Double.parseDouble(variables[1]), null);
			}else{
				resultado = RPN.resolver(RPN.generarFuncion(funcion), 	Double.parseDouble(variables[0]), null, null);
			}
			salida[i] = resultado;
		}
	}
}
