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

public class OrdenadoraString {
	
	private final static String[] arraySorted = {"Abap","Aca","Ala","Banco","Chau","Hola","Zorro"};
	
    @Test
    public void insersion() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new Insercion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void insersionConCentinla() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new Insercion().ordenarConCentinela(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void seleccion() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new Seleccion().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void burbuja() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new Burbuja().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
    
    @Test
    public void shell() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new Shell().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }

    @Test
    public void quicksort() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new QuickSort().ordenar(elements);
        Assert.assertArrayEquals(arraySorted, elements);
        
    }

    @Test
    public void fusion() {
        String[] elements = {"Hola","Chau","Ala","Aca","Abap","Zorro","Banco"};
        new Fusion().ordenar(elements);
        Arrays.toString(elements);
        Assert.assertArrayEquals(arraySorted, elements);
    }
}