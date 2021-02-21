package searchAndSort;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinarySearchTest {
	
	@Test
	public void testBinarySearchInt() {
		int[] testArray1 = {1, 2, 11, 20, 35, 50, 75, 81};
		assertEquals(6, BinarySearch.binarySearch(testArray1, 75));
		assertEquals(-1, BinarySearch.binarySearch(testArray1, 24));
		assertEquals(0, BinarySearch.binarySearch(testArray1, 1));
		assertEquals(7, BinarySearch.binarySearch(testArray1, 81));
		int[] testArray2 = {1,23,45,56,67,68,78,79,80,82,83,85,91,105,134,285,1045,1203};
		assertEquals(15, BinarySearch.binarySearch(testArray2, 285));
	}
	
}
