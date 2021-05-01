package otherAlgorithms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IsPrimeTest {
	
	@Test
	public void testIsProbablePrime() {
		assertEquals(false, IsPrime.isProbablePrime(1));
		assertEquals(true, IsPrime.isProbablePrime(2));
		assertEquals(true, IsPrime.isProbablePrime(17));
		assertEquals(false, IsPrime.isProbablePrime(25));
		assertEquals(false, IsPrime.isProbablePrime(2932021007403L));
		assertEquals(true, IsPrime.isProbablePrime(3613));
		assertEquals(true, IsPrime.isProbablePrime(2932031007403L));
	}
	
}
