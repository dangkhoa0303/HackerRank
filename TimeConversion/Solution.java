package TimeConversion;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		String time, hourString;
		char indicator;
		Scanner input = new Scanner(System.in);
		
		time = input.nextLine();
		
		hourString = time.substring(0, 2);
		indicator = time.charAt(time.length()-2);
		int hour = Integer.parseInt(hourString);
		
		if (indicator=='A') {
			if (hour==12) {
				System.out.println("00" + time.substring(2, time.length()-2));
			} else {
				System.out.println(time.substring(0, time.length()-2));
			}
		} else {
			if (hour==12) {
				System.out.println("12" + time.substring(2, time.length()-2));
			} else {
				hour+=12;
				if (hour < 24) {
					System.out.println(String.valueOf(hour) + time.substring(2, time.length()-2));
				} else {
					if (hour==24) {
						System.out.println("00" + time.substring(2, time.length()-2));
					}
				}
			}
		}
	}

}
