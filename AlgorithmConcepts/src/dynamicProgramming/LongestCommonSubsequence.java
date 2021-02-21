package dynamicProgramming;

/*
	Given are two Strings A and B with length n and m. We want to find the longest 
	common subsequence. We write the two sequences over each other and shift the 
	elements with spaces to find matchings. We have four cases: 
	1. X ~ _	->	LCS[n][m] = LCS[n-1][m]
	2. _ ~ X	->	LCS[n][m] = LCS[n][m-1]
	3. X ~ Y	->	LCS[n][m] = LCS[n-1][m-1]
	4. X ~ X	->	LCS[n][m] = LCS[n-1][m-1]+1
	Runtime:
	- O(n*m) OP's
	- O(n*m) memory
	Optimization: with a rolling array we would only have O(n*m) OP's and O(n) memory
	
	@author Michael Voemel
	@date 11.02.2021
*/

public class LongestCommonSubsequence {
	
	//dynamic programm for longest common subsequence with O(n*m) OP's and O(n*m) memory
	public static int LCS(String A, String B) {
		if (A.length()==0 || B.length()==0 || A==null || B==null) return 0;
		
		int n = A.length();
		int m = B.length();
		int[][] dp = new int[n+1][m+1]; // initialized with 0
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (A.charAt(i-1) == B.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = max3(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
			}
		}
		
		return dp[n][m];
	}//end LCS
	
	
	private static int max3(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}//end max3
	
}//LongestCommonSubsequence
