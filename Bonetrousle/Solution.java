package Bonetrousle;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	private static long t, n, k, b;
	private static ArrayList<Long> list;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		t = input.nextLong();

		while (t > 0) {
			n = input.nextLong();
			k = input.nextLong();
			b = input.nextLong();

			generateSticksBoxes();
			calculate();

			t--;
		}
	}

	private static void generateSticksBoxes() {
		list = new ArrayList<>();
		for (long i = 0; i < k; i++) {
			list.add((i + 1));
		}
	}

	private static void printResult(long start, long nElements, long end) {
		for (long i = start; i < (start+nElements); i++) {
			System.out.print((i+1) + " ");
		}
		System.out.println(end+1);
	}

	private static void calculate() {
		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		if (sum < n) {
			System.out.println(-1);
			return;
		}
		if (sum == n) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print((i + 1) + " ");
			}
			System.out.println();
			return;
		}
		if (sum > n) {
			sum = 0;
			long start = 0, end = list.size()-1, nElements = b - 1;
			while (true) {
				for (long i = start; i < (start + nElements); i++) {
					sum += list.get((int) i);
				}
				sum += list.get((int) end);
				if (sum == n) {
					printResult(start, nElements, end);
					return;
				} else {
					if ((start+nElements)==end) {
						System.out.println(-1);
						return;
					} else {
						if (sum < n) {
							start++;
							sum = 0;
							continue;
						}
						if (sum > n) {
							end--;
							sum = 0;
							continue;
						}
					}
				}
			}
		}
	}
}
