package quicksort;

public class Quick3way {
	
	public static void sort(String[] nomes) {
		Quick3way.sort(nomes, 0, nomes.length-1);
	}
	
	private static void sort(String[] nomes, int lo, int hi) {
		if (hi <= lo) return;
		int lt = lo, gt = hi;
		String v = nomes[lo];
		int i = lo + 1;
		while (i <= gt) {
			int cmp = nomes[i].compareTo(v);
			if (cmp < 0) exch(nomes, lt++, i++);
			else if (cmp > 0) exch(nomes, i, gt--);
			else i++;
		}
		sort(nomes, lo, lt-1);
		sort(nomes, gt+1, hi);
	}

	private static void exch(String[] nomes, int i, int j) {
		String swap = nomes[i];
		nomes[i] = nomes[j];
		nomes[j] = swap;
	}
	
	public static void show(String[] nomes) {
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
	}
	
}
