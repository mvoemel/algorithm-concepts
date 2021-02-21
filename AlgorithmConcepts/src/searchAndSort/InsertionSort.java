package searchAndSort;

/*
	Insertionsort is used to sort an array.
	It operates in O(n^2) time with O(n*log(n)) comparisons and O(n^2) swaps 
	with n representing the number of elements in the array.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class InsertionSort {
	
	//insertion sort for int
	public static void insertionSort(int[] array) {
		if (array.length == 0) return;
		
		int n = array.length;
		for (int i=0; i<n; i++) {
			int key = array[i];
			int j = i-1;
			
			//move elements, that are greater than key to one position ahead
			while (j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}//end insertionSort
	
}//InsertionSort
