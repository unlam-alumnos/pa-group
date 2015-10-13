package test;

import model.Funcion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercicio.RPN;

public class PuntosCercaDelMinimo {

	private static final String FUNCION = "2 x + -1 *";
	
	private Funcion funcion;
	
	@Before
	public void setup() {
		this.funcion = RPN.generarFuncion(FUNCION);
	}
	
	@Test
	public void primero() {
		Assert.assertEquals(9.89E10, RPN.resolver(funcion, -9.89E10, null, null), 1);
	}	
	
	@Test
	public void segundo() {
		Assert.assertEquals(9.90E+10D, RPN.resolver(funcion, -9.90E+10, null, null), 0);
	}	
	
	@Test
	public void tercero() {
		Assert.assertEquals(9.99E+10, RPN.resolver(funcion, -9.99E+10, null, null), 0);
	}
	
	@Test
	public void cuarto() {
		Assert.assertEquals(9.92E+10, RPN.resolver(funcion, -9.92E+10, null, null), 0);
	}
}
