package quicksort;

import insertion.Insertion;

public class QuickX {

	private static final int INSERTION_SORT_CUTOFF = 8;
	
	public static void sort(String[] array) {
		sort(array, 0, array.length - 1);
	}
	
	private static void sort(String[] a, int lo, int hi) {
        if (hi <= lo) return;

        // cutoff to insertion sort (Insertion.sort() uses half-open intervals)
        int n = hi - lo + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            Insertion.sort(a, lo, hi + 1);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

	private static int partition(String[] a, int lo, int hi) {
        int n = hi - lo + 1;
        int m = median3(a, lo, lo + n/2, hi);
        exch(a, m, lo);

        int i = lo;
        int j = hi + 1;
        String v = a[lo];

        // a[lo] is unique largest element
        while (less(a[++i], v)) {
            if (i == hi) { exch(a, lo, hi); return hi; }
        }

        // a[lo] is unique smallest element
        while (less(v, a[--j])) {
            if (j == lo + 1) return lo;
        }

        // the main loop
        while (i < j) {
            exch(a, i, j);
            while (less(a[++i], v)) ;
            while (less(v, a[--j])) ;
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
	
	 private static int median3(String[] a, int i, int j, int k) {
	        return (less(a[i], a[j]) ?
	               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
	               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
	        }
	 
	 private static boolean less(String v, String w) {
	        return v.compareTo(w) < 0;
	    }
	 
	 private static void exch(String[] a, int i, int j) {
	        String swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
	 
	 public static void show(String[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.println(a[i]);
	        }
	    }

}
