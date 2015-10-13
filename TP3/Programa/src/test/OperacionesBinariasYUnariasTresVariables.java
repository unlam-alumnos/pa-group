package test;

import model.Funcion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercicio.RPN;

public class OperacionesBinariasYUnariasTresVariables {

	private static final String FUNCION = "2 4 + x ln * 2 3 ^ 8 / +";
	
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
	public void dos() {
		Assert.assertEquals(5.1588, RPN.resolver(funcion, 2D, null, null), 0.0001);
	}		

	@Test
	public void tres() {
		Assert.assertEquals(7.5916, RPN.resolver(funcion, 3D, null, null), 0.0001);
	}		

	@Test
	public void cuatro() {
		Assert.assertEquals(9.3177, RPN.resolver(funcion, 4D, null, null), 0.0001);
	}			

	@Test
	public void cinco() {
		Assert.assertEquals(10.6566, RPN.resolver(funcion, 5D, null, null), 0.0001);
	}	
		
	
}
