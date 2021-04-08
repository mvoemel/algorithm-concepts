package searchAndSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
	This is a parallelized version of Mergesort using the ForkJoin structure. As input 
	it takes the int[] array to be sorted and the number of threads that should be 
	used and it returns the sorted int[] array.
	
	@author Michael Voemel
	@date 08.04.2021
*/

public class ParallelMergeSort extends RecursiveTask<int[]>{
	
	private static final long serialVersionUID = 1531647254971804196L;
	
	private int[] input;
	private int start;
	private int length;
	
	private ParallelMergeSort(int[] input, int start, int length) {
		this.input = input;
		this.start = start;
		this.length = length;
	}//Constructor
	
	//sorts the the given int[] input array using the forkjoin structure with numThreads threads
	public static int[] sort(int[] input, int numThreads) {
		if (input.length == 0) return input;
		
		ParallelMergeSort app = new ParallelMergeSort(input, 0, input.length);
		ForkJoinPool fjp = new ForkJoinPool(numThreads);
		int[] array = fjp.invoke(app);
		
		return array;
	}//end sort
	
	private static void merge(int[] in1, int[] in2, int[] output) {	
		int in1Position = 0;
		int in2Position = 0;
		int outputPosition = 0;

		while (in1Position < in1.length && in2Position < in2.length) {
			if (in1[in1Position] < in2[in2Position]) {
				output[outputPosition++] = in1[in1Position++];
			} else {
				output[outputPosition++] = in2[in2Position++];
			}
		}

		while (in1Position < in1.length) {
			output[outputPosition++] = in1[in1Position++];
		}

		while (in2Position < in2.length) {
			output[outputPosition++] = in2[in2Position++];
		}
	}//end merge
	
	@Override
	protected int[] compute() {
		int[] result = new int[length];
		
		if (length == 1) {
			result[0] = input[start];

		} else if (length == 2) {
			if (input[start] > input[start + 1]) {
				result[0] = input[start + 1];
				result[1] = input[start];
			} else {
				result[0] = input[start];
				result[1] = input[start + 1];
			}
		} else {
			int halfSize = length/2;
			
			ParallelMergeSort msort1 = new ParallelMergeSort(input, start, halfSize);
			msort1.fork();
			
			ParallelMergeSort msort2 = new ParallelMergeSort(input, start+halfSize, length-halfSize);
			msort2.fork();
			
			merge(msort1.join(), msort2.join(), result);
		}
		
		return result;
	}//end compute
	
}//ParallelMergeSort
