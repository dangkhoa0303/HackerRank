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

			int start = 0, end = N - 1, sumL = array[start], sumR = array[end];
			while (start <= end) {
				if (sumL < sumR) {
					start++;
					sumL += array[start];
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
