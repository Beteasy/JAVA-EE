package com.leapyear;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int year;
		while(true) {
			System.out.println("请输入一个年份：");
			year = scan.nextInt();
			if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
				System.out.println(year+"是闰年");
			}
			else {
				System.out.println(year+"不是闰年");
			}
		}
		
	}

}
