package composite;

import java.io.File;
import java.util.*;
import singleton.FuncionRPN;

/*
 * Esta seria mi clase COMPOSITE, la cual implementa la interfaz "Operacion" 
 * y a su vez utiliza una coleccion de Operaciones; cada suma, resta, multiplicacion, division, logaritmo, potenciacion
 * entre 1 o 2 numeros, que encuentre en la funcion.
 */

public class Funcion implements Operacion{
	private FuncionRPN funcion;
	private List<Operacion> operaciones = new ArrayList<Operacion>();
	
	public Funcion(File archivo) {
		super();
		this.funcion = FuncionRPN.getInstancia(archivo);
		
	}



	@Override
	public double resolver() {
		double res = 0;
		for (Operacion operacion : operaciones) {
			res+=operacion.resolver();
		}
		return res;
	}

}
