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

public class OrdenadoraInteger {
	
	private final static Integer[] arraySorted = {-1, 1, 2, 3, 3, 4, 9, 10};
	
    @Test
    public void insersion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void fusion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
}