package searchAndSort;

/*
	Mergesort is used to sort an array.
	It operates in O(n*log(n)) time with O(n*log(n)) comparisons and O(n*log(n)) swaps 
	with n representing the number of elements in the array.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class MergeSort {
	
	//merge sort for int
	public static void mergeSort(int[] array) {
		if (array.length == 0) return;
		mergeSortRec(array, 0, array.length-1);
	}//end mergeSort
	
	
	//merge sort recursive for int
	private static void mergeSortRec(int[] array, int left, int right) {
		if (left<right) {
			int middle = left+(right-left)/2;
			
			mergeSortRec(array, left, middle);
			mergeSortRec(array, middle+1, right);
			
			merge(array, left, right, middle);
		}
	}//end mergeSortRec
	
	
	//merge operation for int
	private static void merge(int[] array, int left, int right, int middle) {
		//find size of two subarrays to be merged
		int n1 = middle-left+1;
		int n2 = right-middle;
		
		//create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		//copy data to temp arrays
		for (int i=0; i<n1; i++)
			L[i] = array[left+i];
		for (int i=0; i<n2; i++)
			R[i] = array[middle+1+i];
		
		//merge temp arrays
		int i = 0;
		int j = 0;
		
		int k = left;
		while (i<n1 && j<n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else { // L[i] > R[j]
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		//copy remaining elements of L[], R[] if any
		while (i<n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j<n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}//end merge
	
}//MergeSort
