package SherlockAndArray;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T, N;

		T = input.nextInt();
		
		for (int i=0; i<T; i++) {
			N = input.nextInt();
			boolean check = false;
			int array[] = new int[N];
			
			for (int j=0; j<N; j++) {
				array[j] = input.nextInt();
			}
			
			int start = 0, end = N-1, sumL = 0, sumR = 0;
			while (start <= end) {
				sumL += array[start];
				sumR += array[end];
				
				if (sumL==sumR) {
					if (start==end) {
						check = true;
						break;
					}
				}
				start++; 
				end--;
			}
			if (check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
