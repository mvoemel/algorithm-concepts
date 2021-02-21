package dynamicProgramming;

/*
	Given an array A with n elements and a sum b. We try to find 
	the elements such that a(i)+...+a(j)=b. For each element of 
	the array, we distinguish two cases:
	1) b is subset sum of A[1...n-1]
	2) b-A[n] is subset sum of A[1...n-1]
	Runtime:
	- O(b*n) OP's
	- O(b*n) memory
	
	@author Michael Voemel
	@date 12.02.2021
 */

public class SubsetSum {
	
	//dynamic programm for subset sum with O(b*n) OP's and O(b*n) memory
	public static boolean subsetSum(int[] array, int b) {
		if (b<0 || array.length==0 || array==null) return false;
		
		int n = array.length;
		boolean[][] dp = new boolean[b+1][n+1];
		
		//Base case: if sum is 0, then answer is true
		for (int i=0; i<=n; i++)
			dp[0][i] = true;
		
		//Base case: if sum is not 0 and set is empty, then answer is false
		for (int i=1; i<=b; i++)
			dp[i][0] = false;
		
		for (int i=1; i<=b; i++) {
			for (int j=1; j<=n; j++) {
				dp[i][j] = i>=array[j-1] ? dp[i][j-1]||dp[i-array[j-1]][j-1] : dp[i][j-1];
			}
		}
		
		return dp[b][n];
	}//end subsetSum
	
}//SubsetSum
