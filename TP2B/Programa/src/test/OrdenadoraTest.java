package test;

import model.elementales.Burbuja;
import model.elementales.Insersion;
import model.elementales.Seleccion;
import model.noelementales.Fusion;
import model.noelementales.QuickSort;
import model.noelementales.Shell;

import org.junit.Test;

public class OrdenadoraTest {
	
    @Test
    public void insersion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Insersion().ordenar(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void insersionConCentinla() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Insersion().ordenarConCentinela(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
    
    @Test
    public void seleccion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Seleccion().ordenar(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void burbuja() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Burbuja().ordenar(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
    
    @Test
    public void shell() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Shell().ordenar(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void quicksort() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new QuickSort().ordenar(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void fusion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Fusion().ordenar(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
}