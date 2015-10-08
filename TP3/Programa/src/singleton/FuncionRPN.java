package singleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * Esta seria mi clase SINGLETON, la cual tiene una unica instancia.
 * La misma contiene la expresion de la funcion que debo analizar en los 's' puntos indicados.
 */

public class FuncionRPN {

	private static FuncionRPN instancia;
	private String funcion;
	private int cantVariables;
	
	private FuncionRPN(File archivo){
		super();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			funcion = br.readLine();
			cantVariables = Integer.parseInt(br.readLine().split(" ")[0]);			
		} catch (Exception e) {
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
	
	public static FuncionRPN getInstancia(File archivo){
		if (instancia == null) {
			instancia = new FuncionRPN(archivo);
		}
		return instancia;
	}
	
	public String getFuncion() {
		return funcion;
	}

	public int getCantVariables() {
		return cantVariables;
	}
}
