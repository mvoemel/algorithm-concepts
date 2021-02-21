package searchAndSort;

/*
	Quicksort is used to sort an array. Most work is done 
	in partitioning the array into subarrays.
	In the average case it operates in O(n*log(n)) time. In the 
	worst case it operates in O(n^2) time and in the best case 
	it operates in O(n).
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class QuickSort {
	
	//quick sort for int
	public static void quickSort(int[] array) {
		if (array.length == 0) return;
		quickSortRec(array, 0, array.length-1);
	}//end quickSort
	
	
	//quick sort recursive for int
	private static void quickSortRec(int[] array, int low, int high) {
		if (low<high) {
			//pivotIndx is partitioning index, array[pivot] is now at the right place
			int pivotIndx = partition(array, low, high);
			
			//recursively sort elements before and after pivot
			quickSortRec(array, low, pivotIndx-1);
			quickSortRec(array, pivotIndx+1, high);
		}
	}//end quickSortRec
	
	
	//takes last element of array as pivot and puts it on the correct position
	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		
		//index of smaller element
		int i = low-1;
		for (int j=low; j<high; j++) {
			//if cur element smaller than the pivot
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		
		//swap array[i+1] with pivot (array[high])
		swap(array, i+1, high);
		
		return i+1;
	}//end partition
	
	
	//swap operation for int
		private static void swap(int[] array, int i, int j) {
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}//end swap
	
}//end QuickSort
