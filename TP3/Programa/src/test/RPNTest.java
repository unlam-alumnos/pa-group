package test;

import model.RPN;
import model.composite.Funcion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNTest {

	private static final String FUNCION = "2 x 2 ^ 3 * +";
	
	private Funcion funcion;
	
	@Before
	public void setup() {
		this.funcion = RPN.generarFuncion(FUNCION);
	}
	
	@Test
	public void menosCinco() {
		Assert.assertEquals(77D, RPN.resolver(funcion, -5D, null, null), 0);
	}
	
	@Test
	public void menosCuatro() {
		Assert.assertEquals(50D, RPN.resolver(funcion, -4D, null, null), 0);
	}
	
	@Test
	public void menosTres() {
		Assert.assertEquals(29D, RPN.resolver(funcion, -3D, null, null), 0);
	}
	
	@Test
	public void menosDos() {
		Assert.assertEquals(14D, RPN.resolver(funcion, -2D, null, null), 0);
	}
	
	@Test
	public void menosUno() {
		Assert.assertEquals(5D, RPN.resolver(funcion, -1D, null, null), 0);
	}

	@Test
	public void cero() {
		Assert.assertEquals(2D, RPN.resolver(funcion, 0D, null, null), 0);
	}
	
	@Test
	public void uno() {
		Assert.assertEquals(5D, RPN.resolver(funcion, 1D, null, null), 0);
	}
	
	@Test
	public void dos() {
		Assert.assertEquals(14D, RPN.resolver(funcion, 2D, null, null), 0);
	}
	
	@Test
	public void tres() {
		Assert.assertEquals(29D, RPN.resolver(funcion, 3D, null, null), 0);
	}
	
	@Test
	public void cuatro() {
		Assert.assertEquals(50D, RPN.resolver(funcion, 4D, null, null), 0);
	}
	
	@Test
	public void cinco() {
		Assert.assertEquals(77D, RPN.resolver(funcion, 5D, null, null), 0);
	}
}
