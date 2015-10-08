package singleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FuncionRPN {

	private String funcion;
	
	private static FuncionRPN instancia;
	
	private FuncionRPN(File archivo){
		super();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			funcion = br.readLine();	
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
}
