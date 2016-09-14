package aufgabenblatt3;

public class Quicksort {
	private long counter = 0;
	private long swap = 0;

	private void swap(int[] array, int i, int j) {
		swap++;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void sort(int[] array, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int mid = array[(left + right) / 2];
			while (i <= j) {
				counter++;
				while (array[i] < mid) {
					counter++;
					i++;
				}
				while (array[j] > mid) {
					counter++;
					j--;
				}
				if (i <= j) {
					swap(array, i, j);
					i++;
					j--;
				}
			}
			sort(array, left, j);
			sort(array, i, right);
		}
	}

	public void sortMedian(int[] array, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int mid = findMedian(array[left], array[(right + left) / 2], array[right]);
			while (i <= j) {
				counter++;
				while (array[i] < mid) {
					counter++;
					i++;
				}
				while (array[j] > mid) {
					counter++;
					j--;
				}
				if (i <= j) {
					swap(array, i, j);
					i++;
					j--;
				}
			}
			sortMedian(array, left, j);
			sortMedian(array, i, right);
		}
	}

	private int findMedian(int left, int mid, int right) {
		if ((mid < left && left < right) || (right < left && left < mid)) {
			return left;
		}
		if ((left < right && right < mid) || (mid < right && right < left)) {
			return right;
		}
		return mid;
	}

	public void sortRnd(int[] array, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int mid = array[(int) (Math.random() * (right - left)) + left];

			while (i <= j) {
				counter++;
				while (array[i] < mid) {
					counter++;
					i++;
				}
				while (array[j] > mid) {
					counter++;
					j--;
				}
				if (i <= j) {
					swap(array, i, j);
					i++;
					j--;
				}
			}
			sortRnd(array, left, j);
			sortRnd(array, i, right);
		}
	}

	public long getCounter() {
		return counter;
	}

	public long getSwap() {
		return swap;
	}
}
