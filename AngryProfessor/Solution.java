package AngryProfessor;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int T, N, K, count;
		Scanner input = new Scanner(System.in);

		T = input.nextInt();
		for (int i = 0; i < T; i++) {
			count = 0;
			N = input.nextInt();
			K = input.nextInt();
			for (int j = 0; j < N; j++) {
				int s = input.nextInt();
				if (s <= 0) {
					count++;
				}
			}
			if (count >= K) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}

	}

}
