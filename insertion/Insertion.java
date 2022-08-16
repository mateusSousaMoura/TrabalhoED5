package insertion;

public class Insertion {

	public static void sort(String[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            
        }
    }
	
	 public static void sort(String[] a, int lo, int hi) {
	        for (int i = lo + 1; i < hi; i++) {
	            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
	                exch(a, j, j-1);
	            }
	        }
	    }
	 
	 private static boolean less(String v, String w) {
	        return v.compareTo(w) < 0;
	    }
	 
	 private static void exch(String[] a, int i, int j) {
	        String swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
}
