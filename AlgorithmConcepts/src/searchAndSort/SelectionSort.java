package searchAndSort;

/*
	Selection sort is used to sort an array.
	It operates in O(n^2) time with O(n^2) comparisons and O(n) swaps 
	with n representing the number of elements in the array.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class SelectionSort {
	
	//selection sort (min) for int
	public static void selectionSort(int[] array) {
		if (array.length == 0) return;
		
		int n = array.length;
		for (int i=0; i<n-1; i++) {
			//find min element in unsorted array
			int minIdx = i;
			for (int j=i+1; j<n; j++)
				if (array[j] < array[minIdx])
					minIdx = j;
			
			//swap minimum element with first element
			swap(array, minIdx, i);
		}
	}//end selectionSort
	
	
	//swap operation for int
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}//end swap
	
}//SelectionSort
