package otherAlgorithms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KaratsubaTest {
	
	@Test
	public void testKaratsuba() {
		assertEquals(111, Karatsuba.karatsuba(37, 3));
		assertEquals(452767925, Karatsuba.karatsuba(53741, 8425));
		assertEquals(0, Karatsuba.karatsuba(0, 8425));
	}
	
}
