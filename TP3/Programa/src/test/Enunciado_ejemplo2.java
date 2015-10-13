package test;

import model.Funcion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercicio.RPN;

public class Enunciado_ejemplo2 {

	private static final String FUNCION = "2 y * x +";
	
	private Funcion funcion;
	
	@Before
	public void setup() {
		this.funcion = RPN.generarFuncion(FUNCION);
	}
	
	@Test
	public void dos_nueve() {
		Assert.assertEquals(20D, RPN.resolver(funcion, 2D, 9D, null), 0);
	}
	
	@Test
	public void uno_nueve() {
		Assert.assertEquals(19D, RPN.resolver(funcion, 1D, 9D, null), 0);
	}
	
	@Test
	public void dos_ocho() {
		Assert.assertEquals(18D, RPN.resolver(funcion, 2D, 8D, null), 0);
	}
	
	@Test
	public void tres_siete() {
		Assert.assertEquals(17D, RPN.resolver(funcion, 3D, 7D, null), 0);
	}
	
	@Test
	public void cuatro_seis() {
		Assert.assertEquals(16D, RPN.resolver(funcion, 4D, 6D, null), 0);
	}
	
	@Test
	public void cinco_cinco() {
		Assert.assertEquals(15D, RPN.resolver(funcion, 5D, 5D, null), 0);
	}
	
	@Test
	public void seis_cuatro() {
		Assert.assertEquals(14D, RPN.resolver(funcion, 6D, 4D, null), 0);
	}
	
	@Test
	public void siete_tres() {
		Assert.assertEquals(13D, RPN.resolver(funcion, 7D, 3D, null), 0);
	}
	
	@Test
	public void ocho_dos() {
		Assert.assertEquals(12D, RPN.resolver(funcion, 8D, 2D, null), 0);
	}
	
	@Test
	public void nueve_uno() {
		Assert.assertEquals(11D, RPN.resolver(funcion, 9D, 1D, null), 0);
	}
	
}
