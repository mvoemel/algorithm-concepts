package dynamicProgramming;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DynamicProgrammsTest {
	
	@Test
	public void testLongestIncreasingSubsequenceIterative() {
		int[] array1 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] array2 = {4, 9, 8, 13, 10, 11, 7, 3, 16};
		int[] array3 = {};
		int[] array4 = {4, 3, 2, 1};
		assertEquals(4, LongestIncreasingSubsequence.iterativeLIS(array1));
		assertEquals(5, LongestIncreasingSubsequence.iterativeLIS(array2));
		assertEquals(0, LongestIncreasingSubsequence.iterativeLIS(array3));
		assertEquals(1, LongestIncreasingSubsequence.iterativeLIS(array4));
	}
	
	@Test
	public void testLongestIncreasingSubsequenceWithBinarySearch() {
		int[] array1 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] array2 = {4, 9, 8, 13, 10, 11, 7, 3, 16};
		int[] array3 = {};
		int[] array4 = {4, 3, 2, 1};
		assertEquals(4, LongestIncreasingSubsequence.binarySearchLIS(array1));
		assertEquals(5, LongestIncreasingSubsequence.binarySearchLIS(array2));
		assertEquals(0, LongestIncreasingSubsequence.binarySearchLIS(array3));
		assertEquals(1, LongestIncreasingSubsequence.binarySearchLIS(array4));
	}
	
	@Test
	public void testLongestCommonSubsequence() {
		assertEquals(3, LongestCommonSubsequence.LCS("TIGER", "ZIEGE"));
		assertEquals(3, LongestCommonSubsequence.LCS("ABCDGH", "AEDFHR"));
		assertEquals(4, LongestCommonSubsequence.LCS("AGGTAB", "GXTXAYB"));
		assertEquals(0, LongestCommonSubsequence.LCS("", "HELLO"));
		assertEquals(1, LongestCommonSubsequence.LCS("HELLO", "L"));
		assertEquals(5, LongestCommonSubsequence.LCS("HELLO", "HELLO"));
	}
	
	@Test
	public void testMinimumEditDistance() {
		assertEquals(3, MinimumEditDistance.editDistance("TIGER", "ZIEGE"));
		assertEquals(3, MinimumEditDistance.editDistance("SUNDAY", "SATURDAY"));
		assertEquals(4, MinimumEditDistance.editDistance("FOOD", "MONEY"));
		assertEquals(5, MinimumEditDistance.editDistance("", "HELLO"));
		assertEquals(4, MinimumEditDistance.editDistance("HELLO", "L"));
		assertEquals(0, MinimumEditDistance.editDistance("HELLO", "HELLO"));
	}
	
	@Test
	public void testSubsetSum() {
		int[] array1 = {3,34,4,12,5,2};
		int[] array2 = {5,3,7,3,1};
		int[] array3 = {};
		assertEquals(true, SubsetSum.subsetSum(array1, 9));
		assertEquals(false, SubsetSum.subsetSum(array1, 30));
		assertEquals(true, SubsetSum.subsetSum(array2, 9));
		assertEquals(false, SubsetSum.subsetSum(array2, -5));
		assertEquals(false, SubsetSum.subsetSum(array3, 10));
	}
	
	@Test
	public void testKnapsackProblem() {
		int[] val1 = {60,100,120};
		int[] wt1 = {10,20,30};
		int W1 = 50;
		assertEquals(220, KnapsackProblem.knapsackProblem(W1, wt1, val1));
		int[] val2 = {10,15,40};
		int[] wt2 = {1,2,3};
		int W2 = 6;
		assertEquals(65, KnapsackProblem.knapsackProblem(W2, wt2, val2));
		int[] val3 = {1,6,18,22,28};
		int[] wt3 = {1,2,5,6,7};
		int W3 = 11;
		assertEquals(40, KnapsackProblem.knapsackProblem(W3, wt3, val3));
		assertEquals(0, KnapsackProblem.knapsackProblem(-10, wt3, val3));
		int[] emptyArray = {};
		assertEquals(0, KnapsackProblem.knapsackProblem(W3, emptyArray, emptyArray));
	}
}
