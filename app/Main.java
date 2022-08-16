package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

import quicksort.Quick3way;
import quicksort.QuickBentleyMcIlroy;
import quicksort.QuickX;
import quicksort.Quicksort;

public class Main {

	
	public static void main(String[] args) throws IOException{
		//ArrayList<String> nomes = new ArrayList<String>();
		String[] nomes = new String[100000];
		int index=0;
		try {
			File myObj = new File("C:/Users/Mateus/Desktop/nomes100k.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        //System.out.println(data);
		        nomes[index] = data;
		        index++;
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		Quicksort ordene = new Quicksort();
		long start = System.currentTimeMillis();
		//ordene.quickSort(nomes);
		//Quick3way.sort(nomes);
		//QuickBentleyMcIlroy.sort(nomes);
		QuickX.sort(nomes);
		long end= System.currentTimeMillis();
		//QuickBentleyMcIlroy.show(nomes);
		QuickX.show(nomes);
		System.out.println("Tempo para ordenar: " + (end-start) + " ms");
	}
		
}
