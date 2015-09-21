package test;

import model.Burbuja;
import model.Fusion;
import model.Insersion;
import model.QuickSort;
import model.Seleccion;
import model.Shell;

import org.junit.Test;

public class OrdenadoraTest {
	
    @Test
    public void insersion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Insersion().sort(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void insersionConCentinla() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Insersion().sortWithSentinal(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
    
    @Test
    public void seleccion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Seleccion().sort(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void burbuja() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Burbuja().sort(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
    
    @Test
    public void shell() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Shell().sort(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void quicksort() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new QuickSort().sort(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }

    @Test
    public void fusion() {
        Integer[] elements = {1, 2, 3 , 4, -1 , 10, 3, 9};
        new Fusion().sort(elements);
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
}