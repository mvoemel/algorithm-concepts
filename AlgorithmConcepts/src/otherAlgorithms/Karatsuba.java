package otherAlgorithms;

/*
	The Karatsuba algorithm is a multiplication algorithm 
	developed by Antolii Alexeevitch Karatsuba in 1960.
	It operates in O(n^log2(3)) ~ O(n^1.585) time 
	with n representing the number of digits of the numbers
	that are being multiplied together.
	
	@author Michael Voemel
	@date 10.02.2021
*/

public class Karatsuba {
	
	//takes two longs and returns maximum long
	public static long max(long a, long b) {
		return a>b? a:b;
	}//end max
	
	
	//takes two longs and returns a^b
	public static long power(long a, long b) {
		if (b==0)
			return 1;
		else {
			long value = 1;
			for (int i=0; i<b; i++)
				value *= a;
			return value;
		}
	}//end power
	
	
	//takes a long number and returns number of digits as an int
	public static int numDigits(long n) {
		return (""+n).length();
	}//end numDigits
	
	
	//applies Karatsuba's algorithm on x and y and returns x*y
	public static long karatsuba(long x, long y) {
		
		//Base case: x or y has only one digit
		if (x<10 || y<10)
			return x*y;
		
		//Recursive
		else {
			//Find max digit length of x and y
			int maxDigit = (int) max(numDigits(x), numDigits(y));
			//Ceil maxDigit/2
			maxDigit = (maxDigit/2) + (maxDigit%2);
			//Multiplier
			long maxDigitTen = power(10, maxDigit);
			
			//Compute expressions
			long b = x / maxDigitTen;
			long a = x - (b*maxDigitTen);
			long d = y / maxDigitTen;
			long c = y - (d*maxDigitTen);
			
			//Three recursive calls
			long z0 = karatsuba(a, c);
			long z1 = karatsuba(a + b, c + d);
			long z2 = karatsuba(b, d);
			
			return z0 + ((z1-z0-z2)*maxDigitTen) + (z2*(power(10, 2*maxDigit)));
			
		}
	}//end karatsuba
	
}//Karatsuba
