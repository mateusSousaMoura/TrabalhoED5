package quicksort;

public class QuickBentleyMcIlroy {
	
	private final static int INSERTION_SORT_CUTOFF = 8;
	
	 private final static int MEDIAN_OF_3_CUTOFF = 40;
	 
	 public static void sort(String[] array) {
		 sort(array, 0, array.length - 1);
	 }
	 
	 private static void sort(String[] array, int lo, int hi) {
		 int n = hi - lo + 1;
		 
		// cutoff to insertion sort
	        if (n <= INSERTION_SORT_CUTOFF) {
	            insertionSort(array, lo, hi);
	            return;
	        } else if (n <= MEDIAN_OF_3_CUTOFF){
	        	int m = median3(array, lo, lo + n/2, hi);
	        	exch(array, m, lo);
	        } else  {
	            int eps = n/8;
	            int mid = lo + n/2;
	            int m1 = median3(array, lo, lo + eps, lo + eps + eps);
	            int m2 = median3(array, mid - eps, mid, mid + eps);
	            int m3 = median3(array, hi - eps - eps, hi - eps, hi);
	            int ninther = median3(array, m1, m2, m3);
	            exch(array, ninther, lo);
	        }
	        
	        int i = lo, j = hi+1;
	        int p = lo, q = hi+1;
	        String v = array[lo];
	        
	        while (true) {
	            while (less(array[++i], v))
	                if (i == hi) break;
	            while (less(v, array[--j]))
	                if (j == lo) break;

	            // pointers cross
	            if (i == j && eq(array[i], v))
	                exch(array, ++p, i);
	            if (i >= j) break;

	            exch(array, i, j);
	            if (eq(array[i], v)) exch(array, ++p, i);
	            if (eq(array[j], v)) exch(array, --q, j);
	        }
	        
	        i = j + 1;
	        for (int k = lo; k <= p; k++)
	            exch(array, k, j--);
	        for (int k = hi; k >= q; k--)
	            exch(array, k, i++);

	        sort(array, lo, j);
	        sort(array, i, hi);
		 
	 }

	private static boolean eq(String v, String w) {
		if (v == w) return true;    // optimization when reference equal
        return v.compareTo(w) == 0;
	}

	private static int median3(String[] array, int i, int j, int k) {
		return (less(array[i], array[j]) ?
			   (less(array[j], array[k]) ? j : less(array[i], array[k]) ? k : i) :
			   (less(array[k], array[j]) ? j : less(array[k], array[i]) ? k : i));	   
	}

	private static void insertionSort(String[] array, int lo, int hi) {
		for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(array[j], array[j-1]); j--)
                exch(array, j, j-1);
	}

	private static void exch(String[] array, int i, int j) {
		String swap = array[i];
		array[i] = array[j];
		array[j] = swap;
		
	}

	private static boolean less(String v, String w) {
		if (v == w) return false;    // optimization when reference equal
        return v.compareTo(w) < 0;
	}
	
	public static void show(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
	
}
