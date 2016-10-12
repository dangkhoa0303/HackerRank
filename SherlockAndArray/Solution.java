package SherlockAndArray;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T, N;

		T = input.nextInt();

		for (int i = 0; i < T; i++) {
			N = input.nextInt();
			boolean check = false;
			int array[] = new int[N];

			for (int j = 0; j < N; j++) {
				array[j] = input.nextInt();
			}

			if (N == 1 || (N == 2 && array[0] == array[1])) {
				System.out.println("YES");
				continue;
			} else {
				if (N == 2 && array[0] != array[1]) {
					System.out.println("NO");
					continue;
				}
			}

			int start = 0, end = N - 1, sumL = array[start], sumR = array[end];
			while (start <= end) {
				if (sumL < sumR) {
					start++;
					sumL += array[start];
				} else {

				}
				if (sumL > sumR) {
					end--;
					sumR += array[end];
				}
				if (sumL == sumR) {
					if (start == end) {
						check = true;
						break;
					} else {
						start++;
						sumL += array[start];
					}
				}
			}
			if (check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
