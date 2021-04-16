package searchAndSort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/*
	This is a parallelized version of Quicksort using the ForkJoin structure. As input 
	it takes the int[] array to be sorted and the number of threads that should be 
	used and it sorts the input array without returning a new array.
	
	@author Michael Voemel
	@date 16.04.2021
*/

public class ParallelQuickSort extends RecursiveAction {
	
	private static final long serialVersionUID = 1L;

	private static final int cutOff = 4;
	
	private int[] input;
	private int left;
	private int right;
	
	private ParallelQuickSort(int[] input, int left, int right) {
		this.input = input;
		this.left = left;
		this.right = right;
	}//Constructor
	
	//sorts the the given int[] input array using the forkjoin structure with numThreads threads
	public static void sort(int[] input, int numThreads) {
		if (input.length == 0) return;
		
		ParallelQuickSort app = new ParallelQuickSort(input, 0, input.length-1);
		ForkJoinPool fjp = new ForkJoinPool(numThreads);
		fjp.invoke(app);
	}//end sort
	
	private static int partition( int[] input, int left, int right) {
		int pivot = input[left+(right-left)/2];
		
		--left;
		++right;
		
		while(true) {
			do
				++left;
			while(input[left] < pivot);
			
			do
				--right;
			while(input[right] > pivot);
			
			if (left < right) {
				int tmp = input[left];
				input[left] = input[right];
				input[right] = tmp;
			} else {
				return right;
			}
		}
	}//end partition
	
	protected void compute() {
		if (right-left < cutOff) {
			Arrays.sort(input, left, right+1);
		} else {
			int pivot = partition(input, left, right);
			ForkJoinTask<Void> t1 = null;
			
			if (left < pivot)
				t1 = new ParallelQuickSort(input, left, pivot).fork();
			if (pivot+1 < right)
				new ParallelQuickSort(input, pivot+1, right).invoke();
			
			if (t1 != null)
				t1.join();
		}
	}//end compute
	
}//ParallelQuickSort
