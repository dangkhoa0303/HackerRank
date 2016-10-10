package TheBombermanGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static int R, C, N;
	private static int[][] grid;
	private static String[] gridString;

	/*
	 * 0 - bombs 1 - empty 5 - marked previous bombs
	 */

	public static void main(String[] args) {
		initializeGrid();

		int t = N % 3;

		if (t == 2) {
			result(t);
		} else {
			for (int i = 0; i < (N / 3); i++) {
				plantBombs();
				bombsExplode();
			}
			result(t);
		}
	}

	private static void result(int t) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (t == 2) {
					System.out.print("0");
				} else {
					if (grid[i][j] == 1) {
						System.out.print(".");
					}
					if (grid[i][j] == 0) {
						System.out.print("0");
					}
				}
			}
			System.out.println();
		}
	}

	private static void plantBombs() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 0) {
					grid[i][j] = 5; // marked
				}
				if (grid[i][j] == 1) {
					grid[i][j] = 0; // set bombs for empty cells
				}
			}
		}
	}

	private static void bombsExplode() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 5) {
					if (j + 1 < C) {
						if (!(grid[i][j + 1] == 5)) {
							grid[i][j + 1] = 1;
						}
					}
					if (j - 1 >= 0) {
						grid[i][j - 1] = 1;
					}
					if (i + 1 < R) {
						if (!(grid[i + 1][j] == 5)) {
							grid[i + 1][j] = 1;
						}
					}
					if (i - 1 >= 0) {
						grid[i - 1][j] = 1;
					}
					grid[i][j] = 1;
				}
			}
		}
	}

	private static void initializeGrid() {
		Scanner input = new Scanner(System.in);

		R = input.nextInt();
		C = input.nextInt();
		N = input.nextInt();

		grid = new int[R][C];
		gridString = new String[R];

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < R; i++) {
			gridString[i] = in.nextLine();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (gridString[i].charAt(j) == '.') {
					grid[i][j] = 1; // empty cells
				}
				if (gridString[i].charAt(j) == '0') {
					grid[i][j] = 0; // bombs
				}
			}
		}
	}
}
