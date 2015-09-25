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

public class OrdenadoraDoubleGrandes {
	
	private final static Double[] arraySorted = {10E+0, 100E+1, 100E+2, 100E+3, 100E+4, 100E+5, 100E+6, 100E+7};
	
    @Test
    public void insersion() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
        
    }

    @Test
    public void fusion() {
        Double[] elements = {100E+3, 10E+0, 100E+7, 100E+5, 100E+4, 100E+6, 100E+2, 100E+1};
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
}