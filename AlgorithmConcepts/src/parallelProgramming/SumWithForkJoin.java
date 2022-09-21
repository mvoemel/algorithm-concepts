package parallelProgramming;

import java.util.concurrent.*;

/*
	2011: ForkJoin, More Data Structure
		- Java 7.0 Release
		- Good support for Divide and Conquer Parallelism
		- Decoupling from Java Threads, introduction of lightweight ForkJoin Threads
 */

public class SumWithForkJoin {
	public int sum(int[] arr, int p) {
		ForkJoinPool fjp = new ForkJoinPool(p);
		return fjp.invoke(new SumTask(arr, 0, arr.length));
	}//end sum
}//SumWithForkJoin

class SumTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	int lo, hi;
	 int[] arr;
	 SumTask(int[] a, int l, int h) {
		 lo = l; hi = h; arr = a;
	 }
	 
	 @Override
	 protected Integer compute() {
		 int sequentialCutoff = 10_000;
		 if (hi - lo <= sequentialCutoff){
			 int sum = 0;
			 for (int i = lo; i < hi; ++i){
				 sum += arr[i];
			 }
			 return sum;
		 } else {
			 int mid = lo + (hi - lo) / 2;
			 SumTask left = new SumTask(arr, lo, mid);
			 SumTask right = new SumTask(arr, mid, hi);
			 left.fork();
			 right.fork();
			 return left.join() + right.join();
		 }
	 }//end compute
}//SumTask