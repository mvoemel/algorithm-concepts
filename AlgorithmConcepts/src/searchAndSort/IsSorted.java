package searchAndSort;

/*
	Looks if an array is sorted.
	It operates in O(n) time with n representing 
	the number of element in the array.
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class IsSorted {
	
	//checks if it is sorted for an int array
	public static boolean isSorted(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			if (array[i] > array[i+1])
				return false;
		}
		
		//if fully iterated than it is sorted
		return true;
	}//end isSorted
	
}//IsSorted
