package searchAndSort;

/*
	Heapsort is used to sort an array. It uses a datastructure 
	where searching max is cheaper (max-heap).
	It operates in O(n*log(n)) time with heapifying in O(log(n)) and
	creatingHeap in O(n) with n representing the number of elements
	in the arrray.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class HeapSort {
	
	//heap sort for int
	public static void heapSort(int[] array) {
		if (array.length == 0) return;
		
		int n = array.length;
		
		//build heap
		for (int i=n/2-1; i>=0; i--)
			heapify(array, n, i);
		
		//one by one extract element from heap
		for (int i=n-1; i>0; i--) {
			swap(array, 0, i);
			heapify(array, i, 0);
		}
	}//end heapSort
	
	
	//heapify a subtree rooted with node i which is an index in array and n is size of heap
	private static void heapify(int[] array, int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if (left<n && array[left]>array[largest])
			largest = left;
		
		if (right<n && array[right]>array[largest])
			largest = right;
		
		if (largest != i) {
			swap(array, i, largest);
		
			//recursively heapify the affected subtree
			heapify(array, n, largest);
		}
	}//end heapify
	
	
	//swap operation for int
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}//end swap
	
}//HeapSort
