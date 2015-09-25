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

import test.model.Complejo;

public class OrdenadoraComplejo {
	
	private final static Complejo[] arrayIn = {new Complejo(5,5), new Complejo(1.2,1.5), new Complejo(1,2),new Complejo(3,3),new Complejo(1.19,1.489),new Complejo(2,2)};
	private final static Complejo[] arraySorted = {new Complejo(1.19,1.489), new Complejo(1.2,1.5), new Complejo(1,2),new Complejo(2,2),new Complejo(3,3),new Complejo(5,5)};
	
    @Test
    public void insersion() {
    	Complejo[] elements = arrayIn;
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        Complejo[] elements = arrayIn;
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        Complejo[] elements = arrayIn;
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        Complejo[] elements = arrayIn;
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        Complejo[] elements = arrayIn;
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        Complejo[] elements = arrayIn;
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void fusion() {
        Complejo[] elements = arrayIn;
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
}