package profile;

import java.util.Scanner;

public class ProfileClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int profile;
		double  reward = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入利润：");
		profile = scan.nextInt();
		
		if (profile > 0 && profile <= 100000) {
			reward = profile * 0.1;
		}
		else if (profile >100000 && profile <200000) {
			reward = 100000 * 0.1 + (profile - 100000) * 0.075;
		}
		else if (profile >= 200000 && profile < 400000) {
			reward = 100000 * 0.1 + 100000 * 0.075 + (profile-200000) * 0.05;
		}
		else if (profile >= 400000 && profile < 600000) {
			reward = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (profile-400000) * 0.03;
		}
		else if (profile >= 600000 && profile < 1000000) {
			reward = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (profile - 600000) * 0.015;
		}
		else if (profile >= 1000000) {
			reward = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 400000 * 0.015 + (profile - 1000000) * 0.01;
		}
		if (profile < 0) {
			System.out.println("利润不能小于0，请重新输入！");
		}
		else {
			System.out.printf("奖金是：%.1f元", reward);
		}
		}
}
