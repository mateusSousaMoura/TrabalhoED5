package quicksort;



public class Quicksort {

	private void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private int partition(String[] arr, int low, int high)
	{
		// pivot
		String pivo = arr[high];
		
		int i = (low - 1);
		
		 for(int j = low; j <= high - 1; j++)
		    {
			 
		        if (arr[j].compareTo(pivo) < 0) 
		        {
		            i++; 
		            swap(arr, i, j);
		        }
		    }
		
		swap(arr, i + 1, high);
		return (i + 1);
	}
	
	public void quickSort(String[] vetor) {
		quickSort(vetor, 0, vetor.length-1);
	}
	
	public void quickSort(String[] arr, int low, int high)
	{
	    if (low < high) 
	    {
	          
	        // pi is partitioning index, arr[p]
	        // is now at right place 
	        int pi = partition(arr, low, high);
	  
	        // Separately sort elements before
	        // partition and after partition
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}
	
	public void printArray(String[] arr)
	{
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
