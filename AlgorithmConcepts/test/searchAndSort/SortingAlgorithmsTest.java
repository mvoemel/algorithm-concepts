package searchAndSort;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SortingAlgorithmsTest {
	
	@Test
	public void testBubbleSort() {
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		BubbleSort.bubbleSort(array1);
		assertEquals(true, IsSorted.isSorted(array1));
		int[] array2 = {};
		BubbleSort.bubbleSort(array2);
		assertEquals(true, IsSorted.isSorted(array2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		BubbleSort.bubbleSort(array3);
		assertEquals(true, IsSorted.isSorted(array3));
	}
	
	@Test
	public void testSelectionSort() {
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		SelectionSort.selectionSort(array1);
		assertEquals(true, IsSorted.isSorted(array1));
		int[] array2 = {};
		SelectionSort.selectionSort(array2);
		assertEquals(true, IsSorted.isSorted(array2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		SelectionSort.selectionSort(array3);
		assertEquals(true, IsSorted.isSorted(array3));
	}
	
	@Test
	public void testInsertionSort() {
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		InsertionSort.insertionSort(array1);
		assertEquals(true, IsSorted.isSorted(array1));
		int[] array2 = {};
		InsertionSort.insertionSort(array2);
		assertEquals(true, IsSorted.isSorted(array2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		InsertionSort.insertionSort(array3);
		assertEquals(true, IsSorted.isSorted(array3));
	}
	
	@Test
	public void testHeapSort() {
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		HeapSort.heapSort(array1);
		assertEquals(true, IsSorted.isSorted(array1));
		int[] array2 = {};
		HeapSort.heapSort(array2);
		assertEquals(true, IsSorted.isSorted(array2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		HeapSort.heapSort(array3);
		assertEquals(true, IsSorted.isSorted(array3));
	}
	
	@Test
	public void testMergeSort() {
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		MergeSort.mergeSort(array1);
		assertEquals(true, IsSorted.isSorted(array1));
		int[] array2 = {};
		MergeSort.mergeSort(array2);
		assertEquals(true, IsSorted.isSorted(array2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		MergeSort.mergeSort(array3);
		assertEquals(true, IsSorted.isSorted(array3));
	}
	
	@Test
	public void testParallelMergeSort() {
		int numThreads = 4;
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		int[] result1 = ParallelMergeSort.sort(array1, numThreads);
		assertEquals(true, IsSorted.isSorted(result1));
		int[] array2 = {};
		int[] result2 = ParallelMergeSort.sort(array2, numThreads);
		assertEquals(true, IsSorted.isSorted(result2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		int[] result3 = ParallelMergeSort.sort(array3, numThreads);
		assertEquals(true, IsSorted.isSorted(result3));
	}
	
	@Test
	public void testQuickSort() {
		int[] array1 = {2,5,7,1,3,6,9,8,4};
		QuickSort.quickSort(array1);
		assertEquals(true, IsSorted.isSorted(array1));
		int[] array2 = {};
		QuickSort.quickSort(array2);
		assertEquals(true, IsSorted.isSorted(array2));
		int[] array3 = {13,45,19,205,275,1085,9,2,74};
		QuickSort.quickSort(array3);
		assertEquals(true, IsSorted.isSorted(array3));
	}
	
}
