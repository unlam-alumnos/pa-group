package test;

import model.Funcion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercicio.RPN;

public class FuncionCuadraticaConUnicaVariable {

	private static final String FUNCION = "x 2 ^ x + 2 -";
	
	private Funcion funcion;
	
	@Before
	public void setup() {
		this.funcion = RPN.generarFuncion(FUNCION);
	}
	
	@Test
	public void uno() {
		Assert.assertEquals(0D, RPN.resolver(funcion, 1D, 2D, 8D), 0);
	}	

	@Test
	public void dos() {
		Assert.assertEquals(4D, RPN.resolver(funcion, 2D, 2D, 8D), 0);
	}		

	@Test
	public void tres() {
		Assert.assertEquals(10D, RPN.resolver(funcion, 3D, 2D, 8D), 0);
	}		

	@Test
	public void menos_dos() {
		Assert.assertEquals(0, RPN.resolver(funcion, -2D, 2D, 8D), 0);
	}				
}
