package ejercicio;

import java.util.Stack;

import model.Constante;
import model.Funcion;
import model.operaciones.Division;
import model.operaciones.Logaritmo;
import model.operaciones.Multiplicacion;
import model.operaciones.Potenciacion;
import model.operaciones.Resta;
import model.operaciones.Suma;
import model.singleton.Variable;
import model.singleton.X;
import model.singleton.Y;
import model.singleton.Z;

public class RPN {

	public static Funcion generarFuncion(String funcion) {
		Stack<Funcion> pila = new Stack<>();
		String[] split = funcion.split(" ");
		for (String component : split) {
			if (isOperador(component)) {
				Funcion c1 = pila.pop();
				Funcion c2 = pila.pop();
				switch (component) {
				case "+":
					pila.push(new Suma(c1, c2));
					break;
				case "-":
					pila.push(new Resta(c2, c1));
					break;
				case "*":
					pila.push(new Multiplicacion(c1, c2));
					break;
				case "/":
					pila.push(new Division(c2, c1));
					break;
				case "log":
					pila.push(c2);
					pila.push(new Logaritmo(c1));
					break;
				case "ln":
					pila.push(c2);
					pila.push(new Logaritmo(c1));
					break;
				case "^":
					pila.push(new Potenciacion(c2, c1));
					break;
				}
			} else if (isVariable(component)) {
				Variable var;
				if (isX(component)) {
					var = X.getInstancia();
				} else if (isY(component)) {
					var = Y.getInstancia();
				} else {
					var = Z.getInstancia();
				}
				pila.push(var);
			} else {
				pila.push(new Constante(Double.parseDouble(component)));
			}
		}
		return pila.pop();
	}
	
	public static double resolver(Funcion funcion, Double x, Double y, Double z) {
		X.getInstancia().setValor(x != null ? x : 0);
		Y.getInstancia().setValor(y != null ? y : 0);
		Z.getInstancia().setValor(z != null ? z : 0);
		return funcion.resolver();
	}

	private static boolean isX(String component) {
		return "x".equals(component.toLowerCase());
	}

	private static boolean isY(String component) {
		return "y".equals(component.toLowerCase());
	}

	private static boolean isVariable(String component) {
		return "xyz".contains(component.toLowerCase());
	}

	private static boolean isOperador(String component) {
		return "-+*/logln^".contains(component);
	}
}
