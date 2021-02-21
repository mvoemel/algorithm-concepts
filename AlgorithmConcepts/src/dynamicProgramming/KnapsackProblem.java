package dynamicProgramming;

/*
	Given is a backpack with weightlimit W and n objects each with 
	value v(i) and weight w(i). We search for I subset of {1,...,n} 
	such that the sum w(i) <= W and the sum v(i) is maximal. We have 
	that the optimal solution is either solution for 1...n-1 with W 
	or for 1...n-1 with W-w(n).
	Runtime:
	- O(n*W) OP's
	- O(n*W) memory
	Optimization: we could make the algorithm faster by approximating 
	the optimal solution:
	- input-approx: w(i), floor(v(i) / k), W
	- factor: k = E/n * v(max)
	- Runtime: O(n^3/E)
	
	@author Michael Voemel
	@date 12.02.2021
 */

public class KnapsackProblem {
	
	//dynamic programm for Knapsack problem with O(n*W) OP's and O(n*W) memory
	public static int knapsackProblem(int W, int[] weight, int[] value) {
		//Precondition: weight.length == value.length
		if (W<0 || weight==null || weight.length==0) return 0;
		
		int n = weight.length;
		int[][] dp = new int[n+1][W+1];
		
		for (int i=0; i<=n; i++) {
			for (int w=0; w<=W; w++) {
				if (i==0 || w==0)
					dp[i][w] = 0;
				else if (weight[i-1] <= w)
					dp[i][w] = Math.max(value[i-1] + dp[i-1][w-weight[i-1]], dp[i-1][w]);
				else
					dp[i][w] = dp[i-1][w];
			}
		}
		
		return dp[n][W];
	}//end KnapsackProblem
	
}//KnapsackProblem
