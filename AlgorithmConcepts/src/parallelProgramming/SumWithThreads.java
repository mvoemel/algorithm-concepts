package parallelProgramming;

/*
	1996: Threads, Locks, Synchronized Blocks
		- Java 1.0 Release
		- Java threads are mapped to OS threads
		- Each object in Java acts as a reentrant lock
 */

public class SumWithThreads {
	 public int sum(int[] arr, int p) throws Exception {
		 int len = arr.length;
		 int ans = 0;
		 SumThread[] ts = new SumThread[p];
		 for(int i = 0; i < p; ++i){
			 	ts[i] = new SumThread(arr, i * len/p, (i+1)*len/p);
			 	ts[i].start();
		 }
		 for (int i = 0; i < p; ++i){
			 ts[i].join();
			 ans += ts[i].ans;
		 }
		 return ans;
	 }//end sum
}//SumWithThreads

class SumThread extends Thread {
	 int lo, hi, ans = 0;
	 int[] arr;
	 
	 SumThread(int[] a, int l, int h) {
		 lo = l; hi = h; arr = a;
	 }
	 
	 @Override
	 public void run() {
		 for(int i = lo; i < hi ; ++i){
			 ans += arr[i];
		 }
	 }//end run
}//SumThread

