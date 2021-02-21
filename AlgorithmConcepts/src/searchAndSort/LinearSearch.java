package searchAndSort;

/*
	Linear Search is used to search in an unsorted array.
	It operates in O(n) with n representing the number of 
	elements in the array.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class LinearSearch {
	
	//linear search for int
	public static int linearSearch(int[] array, int key) {
		//if array is empty return -1
		if (array.length == 0) 
			return -1;
		
		for (int i=0; i<array.length; i++) {
			if (array[i] == key)
				return i;
		}
		
		//if key was not found
		return -1;
	}//end linearSearch
	
}//LinearSearch
