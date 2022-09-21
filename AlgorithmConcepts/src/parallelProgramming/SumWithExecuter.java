package parallelProgramming;

import java.util.*;
import java.util.concurrent.*;

/*
	2004: Concurrency Framework
		- Java 5.0 Release
		- Executor Service, Explicit lock classes, Toolkit of atomic operations
		- System takes over the job of distributing work packages to available threads
 */

public class SumWithExecuter {
	 public int sum(int[] arr, int p) throws Exception {
		 int taskSize = arr.length / p;
		 int nrOfTasks = arr.length / taskSize;
		 ExecutorService exs = Executors.newFixedThreadPool(p);
		 List<SumCallable> tasks = new ArrayList<>(nrOfTasks);
		 for (int i = 0; i < nrOfTasks; ++i){
			 tasks.add(new SumCallable(arr, taskSize * i, taskSize * i + taskSize));
		 }
		 int total = 0;
		 List<Future<Integer>> results = exs.invokeAll(tasks);
		 for (Future<Integer> result: results){
			 total += result.get();
		 }
		 exs.shutdown();
		 return total;
	}//end sum
}//SumWithExecuter

class SumCallable implements Callable<Integer> {
	 int lo, hi;
	 int[] arr;
	 SumCallable(int[] a, int l, int h) {
		 lo = l; hi = h; arr = a;
	 }
	 
	 @Override
	 public Integer call() {
		 int ans = 0;
		 for(int i = lo; i < hi ; ++i){
			 ans += arr[i];
		 }
		 return ans;
	 }//end call
}//SumCallable