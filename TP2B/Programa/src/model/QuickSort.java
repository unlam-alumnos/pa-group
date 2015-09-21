package model;

public class QuickSort extends Ordenadora {
	
    @Override
    public void sort(Comparable[] elements) {
        sort(elements, 0, elements.length - 1);
        assert isSorted(elements);
    }

    // quicksort the subarray from elements[lo] to elements[hi]
    private static void sort(Comparable[] elements, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(elements, lo, hi);
        sort(elements, lo, j - 1);
        sort(elements, j + 1, hi);
        assert isSorted(elements, lo, hi);
    }

    // partition the subarray elements[lo..hi] so that elements[lo..j-1] <= elements[j] <= elements[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] elements, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = elements[lo];
        while (true) {

            // find item on lo to swap
            while (less(elements[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            // find item on hi to swap
            while (less(v, elements[--j])) {
                if (j == lo) {
                    break;      // redundant since elements[lo] acts as sentinel
                }
            }

            // check if pointers cross
            if (i >= j) {
                break;
            }

            exch(elements, i, j);
        }

        // put partitioning item v at elements[j]
        exch(elements, lo, j);

        // now, elements[lo .. j-1] <= elements[j] <= elements[j+1 .. hi]
        return j;
    }
}