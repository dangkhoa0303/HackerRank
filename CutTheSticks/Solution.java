package CutTheSticks;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicComboBoxUI.ListDataHandler;

public class Solution {

	private static ArrayList<Integer> list = new ArrayList<>();
	private static int N, countZeros = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		for (int i = 0; i < N; i++) {
			int a = input.nextInt();
			list.add(a);
		}
		while (true) {
			int min = smallestStick();
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != 0 && list.get(i) != -1) {
					int temp = list.get(i) - min;
					list.set(i, temp);
					count++;
				} else {
					if (list.get(i)==0) {
						countZeros++;
						list.set(i, -1);
					}
				}
			}
			if (countZeros==N)
				break;
			System.out.println(count);
		}
	}

	private static int smallestStick() {
		int min = 2000000000;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= min && list.get(i) > 0) {
				min = list.get(i);
			}
		}
		return min;
	}
}
