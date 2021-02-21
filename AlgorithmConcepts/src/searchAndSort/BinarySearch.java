package searchAndSort;

/*
	Binary search is used to search in a sorted array.
	Divide and conquer approach.
	It operates in O(log(n)) time with n representing 
	the number of elements in the array.
	
	@author Michael Voemel
	@date 11.02.2021
 */

public class BinarySearch {
	
	//binarySearch for int
	public static int binarySearch(int[] array, int key) {
		int left = 0;
		int right = array.length-1;
		
		while (left <= right) {
			int middle = (left+right)/2;
			
			if (array[middle] == key)
				return middle;
			else if (array[middle] > key)
				right = middle - 1;
			else
				left = middle + 1;
		}
		
		//key was not found in array
		return -1;
	}//end binarySearch
	
}//BinarySearch
