package aufgabenblatt3;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuicksortTest {

	private final int n = 100000;

	@Test
	public void testSort() {
		Quicksort test = new Quicksort();
		int[] actual = { 5, 7, 6, 1, 2, 3, 8, 9, 4, 0 };
		int[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		test.sort(actual, 0, 9);
		assertArrayEquals(expected, actual);
		System.out.println("Pivot 10: " + test.getCounter());
		System.out.println("swap Pivot 10: " + test.getSwap());

		Quicksort test1 = new Quicksort();
		int[] merkel = new int[n];
		for (int i = 0; i < n; i++) {
			merkel[i] = 0 + (int) (Math.random() * n);
		}
		test1.sort(merkel, 0, n - 1);
		System.out.println("sort counter: " + test1.getCounter() + " --- swap: " + test1.getSwap());

		int[] actual1 = { 1, 0 };
		int[] expected1 = { 0, 1 };
		test.sort(actual1, 0, 1);
		assertArrayEquals(expected1, actual1);
	}

	@Test
	public void testSortMedian() {
		Quicksort test = new Quicksort();
		int[] actual = { 5, 7, 6, 1, 2, 3, 8, 9, 4, 0 };
		int[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		test.sortMedian(actual, 0, 9);
		assertArrayEquals(expected, actual);
		System.out.println("Median 10: " + test.getCounter());
		System.out.println("swap median 10: " + test.getSwap());

		Quicksort test1 = new Quicksort();
		int[] merkel = new int[n];
		for (int i = 0; i < n; i++) {
			merkel[i] = 0 + (int) (Math.random() * n);
		}
		test1.sortMedian(merkel, 0, n - 1);
		System.out.println("sortMedian counter: " + test1.getCounter() + " --- swap: " + test1.getSwap());

		int[] actual1 = { 1, 0 };
		int[] expected1 = { 0, 1 };
		test.sortMedian(actual1, 0, 1);
		assertArrayEquals(expected1, actual1);
	}

	@Test
	public void testSortRnd() {
		Quicksort test = new Quicksort();
		int[] actual = { 5, 7, 6, 1, 2, 3, 8, 9, 4, 0 };
		int[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		test.sortRnd(actual, 0, 9);
		assertArrayEquals(expected, actual);
		System.out.println("Random 10: " + test.getCounter());
		System.out.println("swap median 10: " + test.getSwap());

		Quicksort test1 = new Quicksort();
		int[] merkel = new int[n];
		for (int i = 0; i < n; i++) {
			merkel[i] = 0 + (int) (Math.random() * n);
		}
		test1.sortRnd(merkel, 0, n - 1);
		System.out.println("sortRnd counter: " + test1.getCounter() + " --- swap: " + test1.getSwap());

		int[] actual1 = { 1, 0 };
		int[] expected1 = { 0, 1 };
		test.sortRnd(actual1, 0, 1);
		assertArrayEquals(expected1, actual1);
	}
}
