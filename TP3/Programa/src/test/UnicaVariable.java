package test;

import model.Funcion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercicio.RPN;

public class UnicaVariable {

	private static final String FUNCION = "x";
	
	private Funcion funcion;
	
	@Before
	public void setup() {
		this.funcion = RPN.generarFuncion(FUNCION);
	}
	
	@Test
	public void uno() {
		Assert.assertEquals(1D, RPN.resolver(funcion, 1D, null, null), 0);
	}	
	
	@Test
	public void menos_uno() {
		Assert.assertEquals(-1D, RPN.resolver(funcion, -1D, null, null), 0);
	}	
	
	@Test
	public void mil() {
		Assert.assertEquals(1000D, RPN.resolver(funcion, 1000D, null, null), 0);
	}	
}
