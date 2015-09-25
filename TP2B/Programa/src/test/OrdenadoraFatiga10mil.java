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

public class OrdenadoraFatiga10mil {
	
	private final static Integer[] arrayIn = generadorOrdenInverso(10000);
	private final static Integer[] arraySorted = generadorOrdenado(10000);
	
	private static Integer[] generadorOrdenado(int dim){
		Integer[] aux = new Integer[dim];
		for (int i = 1; i <= aux.length; i++) {
			aux[i-1] = i;
		}
		return aux;
	}

	private static Integer[] generadorOrdenInverso(int dim){
		Integer[] aux = new Integer[dim];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = dim - i;
		}
		return aux;
	}
	
    @Test
    public void insersion() {
        Integer[] elements = arrayIn;
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        Integer[] elements = arrayIn;
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        Integer[] elements = arrayIn;
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        Integer[] elements = arrayIn;
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        Integer[] elements = arrayIn;
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        Integer[] elements = arrayIn;
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
        
    }

    @Test
    public void fusion() {
        Integer[] elements = arrayIn;
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
	
}
