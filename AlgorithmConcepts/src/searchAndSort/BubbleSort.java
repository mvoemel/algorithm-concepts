package searchAndSort;

/*
	Bubblesort is used to sort an array.
	It operates in O(n^2) time with O(n^2) comparisons and O(n^2) swaps 
	with n representing the number of elements in the array.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class BubbleSort {
	
	//bubble sort for int
	public static void bubbleSort(int[] array) {
		//if array empty return
		if (array.length == 0) return;
		
		int n = array.length;
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (array[j] > array[j+1])
					swap(array, j, j+1);
			}
		}
	}//end bubbleSort
	
	
	//swap operation for int
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}//end swap
	
}//BubbleSort
