package DiagonalDifference;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n, sum1 = 0, sum2 = 0;
		n = input.nextInt();

		int matrix[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = input.nextInt();
				if (i == j)
					sum1 += matrix[i][j];
				if (i + j == n - 1)
					sum2 += matrix[i][j];
			}
		}
		System.out.println(Math.abs(sum1 - sum2));
	}
}
