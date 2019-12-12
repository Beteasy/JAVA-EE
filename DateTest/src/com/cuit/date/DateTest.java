package com.cuit.date;

import java.text.SimpleDateFormat;
import java.util.*;


public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int hour;
			String dateString;
			int year;
			int month;
			int day;
			int h;
			String[] dateArr;
		 	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 	Scanner scanner = new Scanner(System.in);
		 	System.out.println("请输入日期，格式：yyyy-mm-dd-HH");
		 	dateString = scanner.nextLine();
		 	dateArr = dateString.split("-");
		 	year = Integer.parseInt(dateArr[0]);
		 	month = Integer.parseInt(dateArr[1]);
		 	day = Integer.parseInt(dateArr[2]);
		 	h = Integer.parseInt(dateArr[3]);
		 	System.out.println("请输入小时数：");
		 	hour = scanner.nextInt();
	        @SuppressWarnings("deprecation")
			Date givenDate = new Date(year-1900,month-1,day,h,0);
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(givenDate);
	        Date updateDate1 = calendar.getTime();
	        System.out.println("给定时间="+sdf.format(updateDate1));
	       
	        //往前推n小时
	        calendar.add(Calendar.HOUR_OF_DAY, hour);
	        Date updateDate5 = calendar.getTime();
	        System.out.println("往前推"+hour+"小时的时间="+sdf.format(updateDate5));
	}
	
	

}
