package parallelProgramming;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/*
	2014: Java Stream API
		- Huge step towards parallelizing computation
		- Take away the burden on manually managing the decomposition into tasks and collecting results
 */

public class SumWithStreams {
	 public int sum(int[] arr, int p) throws Exception {
		ForkJoinPool fjp = new ForkJoinPool(p);
		return (int) fjp.submit(
				 () -> IntStream.of(arr)
				 	.parallel()
				 	.sum()
		).get();
	 }//end sum
}//SumWithStreams

