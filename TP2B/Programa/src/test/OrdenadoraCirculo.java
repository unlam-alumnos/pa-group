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

import test.model.Circulo;
import test.model.Complejo;

public class OrdenadoraCirculo {
	
	private final static Circulo[] arraySorted = {new Circulo(1), new Circulo(2), new Circulo(4), new Circulo(4.99), new Circulo(5), new Circulo(5.01), new Circulo(10)};
	
    @Test
    public void insersion() {
    	Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void fusion() {
        Circulo[] elements = {new Circulo(5), new Circulo(5.01), new Circulo(4.99), new Circulo(2), new Circulo(4), new Circulo(1), new Circulo(10)};
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
}