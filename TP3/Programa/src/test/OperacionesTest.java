package test;

import org.junit.Assert;
import org.junit.Test;

import composite.Division;
import composite.Logaritmo;
import composite.Multiplicacion;
import composite.Potenciacion;
import composite.Resta;
import composite.Suma;

public class OperacionesTest {

	@Test
	public void sumar1(){
		Suma suma = new Suma(1,2);
		Assert.assertEquals(3, suma.resolver(), -10E10);
	}
	@Test
	public void sumar2(){
		Suma suma = new Suma(2,1);
		Assert.assertEquals(3, suma.resolver(), -10E10);
	}

	@Test
	public void restar1(){
		Resta resta = new Resta(1,2);
		Assert.assertEquals(-1, resta.resolver(), -10E10);
	}
	@Test
	public void restar2(){
		Resta resta = new Resta(2,1);
		Assert.assertEquals(1, resta.resolver(), -10E10);
	}
	
	@Test
	public void multiplicar1(){
		Multiplicacion multiplicacion = new Multiplicacion(3,2);
		Assert.assertEquals(6, multiplicacion.resolver(), -10E10);
	}
	@Test
	public void multiplicar2(){
		Multiplicacion multiplicacion = new Multiplicacion(2,3);
		Assert.assertEquals(6, multiplicacion.resolver(), -10E10);
	}
	
	@Test
	public void dividir1(){
		Division division = new Division(3,2);
		Assert.assertEquals(1.5, division.resolver(), -10E10);
	}
	@Test
	public void dividir2(){
		Division division = new Division(2,3);
		Assert.assertEquals(0.6666666666666666, division.resolver(), -10E10);
	}
	
	@Test
	public void potenciacion1(){
		Potenciacion potenciacion = new Potenciacion(3,2);
		Assert.assertEquals(9, potenciacion.resolver(), -10E10);
	}
	@Test
	public void potenciacion2(){
		Potenciacion potenciacion = new Potenciacion(2,3);
		Assert.assertEquals(8, potenciacion.resolver(), -10E10);
	}

	@Test
	public void logaritmo(){
		Logaritmo logaritmo = new Logaritmo(Math.E,1);
		Assert.assertEquals(0, logaritmo.resolver(), -10E10);
	}
}
