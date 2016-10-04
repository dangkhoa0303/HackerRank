package CircularArrayRotation;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, k, q;

		n = input.nextInt();
		k = input.nextInt();
		q = input.nextInt();

		int array[] = new int[n];
		int new_array[] = new int[n];
		int denotes[] = new int[q];

		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		for (int i = 0; i < q; i++) {
			denotes[i] = input.nextInt();
		}

		if (array.length > 1 || (k % n) != 0) {
			int i = 0, j = 0;
			if (k < n) {
				i = n - k;
			} else if (k > n) {
				i = n - (k % n);
			}
			while (i < n) {
				new_array[j] = array[i];
				i++;
				j++;
			}
			i = 0;
			while (j < n) {
				new_array[j] = array[i];
				j++;
				i++;
			}
		}
		for (int i = 0; i < q; i++) {
			if (denotes[i] >= 0 && denotes[i] < n) {
				System.out.println(new_array[denotes[i]]);
			} else {
				break;
			}
		}
	}

}
