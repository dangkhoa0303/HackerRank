package AlmostSorted;

import java.util.Scanner;

public class Solution {

	private static int array[], invalidIndex, n;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();

		invalidIndex = 0;
		array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}

		for (int i = 0; i < n-1; i++) {
			if (array[i] > array[i+1]) {
				int pos = indexSmallestSuitable(i);
				
				if (pos!=i) {
					swap(pos, i);
					if (isSorted()) {
						System.out.println("yes");
						System.out.println("swap " + (i+1) + " " + (pos+1));
					} else {
						swap(pos, i);
						array = reverse(i, pos);
						if (isSorted()) {
							System.out.println("yes");
							System.out.println("reverse " + (i+1) + " " + (pos+1));
						} else {
							System.out.println("no");
						}
					}
				} else {
					swap(i, i+1);
					if (isSorted()) {
						System.out.println("yes");
						System.out.println("swap " + (i+1) + " " + (i+2));
					} else {
						System.out.println("no");
					}
				}
				break;
			}
		}
	}

	private static int indexSmallestSuitable(int current) {
		int a = 0, b = 0, min, index = 0;
		min = array[current];
		if (current > 0 && current < n - 1) {
			a = array[current - 1];
			b = array[current + 1];
			index = current;
			for (int i = current + 2; i < n; i++) {
				if (array[i] > a && array[i] < b && array[i] < min) {
					min = array[i];
					index = i;
				}
			}
		}
		if (current == 0) {
			a = array[current + 1];
			for (int i = current + 2; i < n; i++) {
				if (array[i] < a && array[i] < min) {
					min = array[i];
					index = i;
				}
			}
		}
		return index;
	}

	private static void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static boolean isSorted() {
		for (int i = 0; i < array.length; i++) {
			if (i != n - 1) {
				if (array[i + 1] < array[i]) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[] reverse(int index1, int index2) {
		int[] a = new int[n];
		int[] new_array = new int[n];
		for (int i = index2, j = 0; i >= index1; i--, j++) {
			a[j] = array[i];
		}
		int m = 0;
		for (int i = 0; i < n; i++) {
			if (i >= index1 && i <= index2) {
				new_array[i] = a[m];
				m++;
			} else {
				new_array[i] = array[i];
			}
		}
		return new_array;
	}

}
