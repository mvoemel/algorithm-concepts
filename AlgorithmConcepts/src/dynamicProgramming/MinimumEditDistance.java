package dynamicProgramming;

/*
	Given are two Strings, what is the minimal number of 
	editing operations to make them equal. We can perform 
	three operations: delete, insert, change.
	Runtime:
	- O(n*m) OP's
	- O(n*m) memory
	Optimization: with a rolling array we would only have O(n*m) OP's and O(n) memory
	
	@author Michael Voemel
	@date 12.02.2021
*/

public class MinimumEditDistance {
	
	//dynamic programm for minimum edit distance with O(n*m) OP's and O(n*m) memory
	public static int editDistance(String A, String B) {
		if (A == null || B == null) return -1;
		
		int n = A.length();
		int m = B.length();
		
		int[][] dp = new int[n+1][m+1];
		
		//Base cases
		for (int i=1; i<=m; i++)
			dp[0][i] = i;
		for (int i=1; i<=n; i++)
			dp[i][0] = i;
		
		//Remove: dp[i-1][j]; Insert: dp[i][j-1]; Replace: dp[i-1][j-1]
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (A.charAt(i-1) == B.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = min3(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1;
			}
		}
		
		return dp[n][m];
	}//end editDistance
	
	
	private static int min3(int one, int two, int three) {
		return Math.min(one,  Math.min(two, three));
	}//end min3
	
}//MinimumEditDistance
