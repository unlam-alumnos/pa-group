package model;

public class Main {

	public static void main(String[] args) {
		
		FuncionRPN rpn = new FuncionRPN("funcion.in");
		rpn.resolver();
		rpn.escribirSalida("funcion.out");
	}

}
