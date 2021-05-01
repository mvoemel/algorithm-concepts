package otherAlgorithms;

import java.math.BigInteger;

/*
	This is a probabilistic algorithm, that test if a number <= 2^64-1 is prime. This algorithm is 
	a Monte-Carlo algorithm. As input the Miller Rabin algorithm takes an uneven number >= 3 and 
	a number a in {2,3,...,n-2}. And it returns "true" for it is probable prime or "false" for it 
	is not prime. For a couple n and a with n not prime, the algorithm can nevertheless return "true" 
	for it is probable prime. With repeating the test several times, the probability of returning
	"true", eventhough it is not a prime, gets reduced.
	
	@author Michael Voemel
	@date 01.05.2021
*/

public class IsPrime {
	
	@SuppressWarnings("unused")
	private static int[] a_array = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
	
	
	// takes a num <= 2^64-1 and returns if it is probable prime using the Miller Rabin test
	public static boolean isProbablePrime(long num) {
		BigInteger n = new BigInteger(num+"");
	      
	      // n == 2
	      if (n.compareTo(BigInteger.TWO)==0){
	        return true;
	      }
	      // n == 1 || n%2 == 0
	      else if (n.compareTo(BigInteger.ONE)==0 || n.mod(BigInteger.TWO)==BigInteger.ZERO){
	        return false;
	      }
	      
	      int l = /*a_array.length*/ 100;
	      for (int i=0; i<l; i++){
	        //BigInteger a = new BigInteger(a_array[i]+"");
	        long a_tmp = (long)((Math.random()*(n.longValue()-3))+2);
	        BigInteger a = new BigInteger(a_tmp+"");
	        
	        if (!millerRabin(n, a)){
	          return false;
	        }
	      }//for-loop (l)
	      return true;
	}//isProbablePrime
	
	
	// takes n and a as input and returns true if, using the Miller Rabin test, it is a prime
	private static boolean millerRabin(BigInteger n, BigInteger a){
	      // n-1 = d*2^k mit d ungerade
	      int k = 0;
	      BigInteger d = n.subtract(BigInteger.ONE); // (n-1)
	      while (d.mod(BigInteger.TWO).compareTo(BigInteger.ZERO)==0){ // d%2 == 0
	        d = d.divide(BigInteger.TWO); // d /= 2
	        k++;
	      }
	      
	      BigInteger x = a.modPow(d, n);
	      
	      // x == 1 || x == n-1
	      if (x.longValue()==1 || x.longValue()==n.longValue()-1){
	        return true;
	      }
	      
	      for (int i=0; i<k-1; i++){
	        x = x.modPow(BigInteger.TWO, n); // x = x^2 (mod n)
	        
	        if (x.longValue()==1) // x == 1
	          return false;
	        
	        if (x.longValue()==n.longValue()-1) // x == n-1
	          return true;
	      }//for-loop (k)
	      
	      return false;
	    }//end millerRabin
	
}//Prime
