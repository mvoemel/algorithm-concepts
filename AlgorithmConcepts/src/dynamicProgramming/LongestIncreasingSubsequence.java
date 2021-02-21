package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
	Find the length of the longest increasing subsequence in a given unsorted array.
	For example, given {4, 9, 8, 13, 10, 11, 7, 3, 16}, the longest increasing 
	subsequence is {4, 8, 10, 11, 16} with length 5.
	Runtime:
	- iterative method: O(n^2) OP's and O(n) memory
	- method using binary search: O(n*log(n)) OP's and O(n) memory
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class LongestIncreasingSubsequence {
	
	//longest increasing subsequence iterative approach with O(n^2) OP's and O(n) memory
	public static int iterativeLIS(int[] array) {
		if (array.length == 0 || array == null) return 0;
		
		int n = array.length;
		int[] dp = new int[n];
		for (int i=0; i<n; i++) // initialize
			dp[i] = 1;
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (array[i] > array[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(dp[i], max);
		}
		
		return max;
	}//end iterativeLIS
	
	
	//longest increasing subsequence approach using binary search with O(n*log(n)) OP's and O(n) memory
	public static int binarySearchLIS(int[] array) {
		if (array.length == 0 || array == null) return 0;
		
		int n = array.length;
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			if (list.size() == 0 || array[i] > list.get(list.size()-1)) {
				list.add(array[i]);
			} else {
				int index = binarySearch(list, array[i]);
				list.set(index, array[i]);
			}
		}
		
		return list.size();
	}//end binarySearchLIS
	
	
	//binary search algorithm with O(n*log(n))
	private static int binarySearch(List<Integer> list, int key) {
		int left = 0;
		int right = list.size()-1;
		
		while (left+1 < right) {
			int middle = left + (right-left)/2;
			if (list.get(middle) == key)
				return middle;
			else if (list.get(middle) < key)
				left = middle;
			else
				right = middle;
		}
		
		return list.get(left) >= key ? left : right;
	}//end binarySearch
	
}//LongestIncreasingSubsequence
