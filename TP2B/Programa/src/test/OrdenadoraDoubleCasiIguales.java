package test;

import java.util.Arrays;

import model.elementales.Burbuja;
import model.elementales.Insercion;
import model.elementales.Seleccion;
import model.noelementales.Fusion;
import model.noelementales.QuickSort;
import model.noelementales.Shell;

import org.junit.Assert;
import org.junit.Test;

public class OrdenadoraDoubleCasiIguales {
	
	private final static Double[] arraySorted = {-0.9998, -0.99, 0.089, 0.09999999, 0.99, 0.999998, 1.0, 1.01};
	
    @Test
    public void insersion() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
        
    }

    @Test
    public void fusion() {
        Double[] elements = {-0.99, 0.99, 1.00, 0.999998, 0.089, 1.01, 0.09999999, -0.9998};
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
}