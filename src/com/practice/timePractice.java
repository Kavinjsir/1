package com.practice;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author kavin
 * 
 */
public class timePractice {

	public static void main(String[] args) {
		// Test
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));

		// Java 8
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthValue()); // 1 - 12
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getHour());
		System.out.println(dt.getMinute());
		System.out.println(dt.getSecond());

		// 如何取得从1970年1月1日0时0分0秒到现在的毫秒数？
		Calendar.getInstance().getTimeInMillis();
		System.currentTimeMillis();
		Clock.systemDefaultZone().millis(); // Java 8

		// 如何取得某月的最后一天
		Calendar time = Calendar.getInstance();
		time.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(time.getActualMaximum(Calendar.DAY_OF_MONTH));

		// 如何格式化日期
		/**
		 * 利用java.text.DataFormat 的子类（如SimpleDateFormat类）中的format(Date)方法可将日期格式化。Java
		 * 8中可以用java.time.format.DateTimeFormatter来格式化时间日期，代码如下所示。
		 */
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
 
        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));

        //打印昨日日期
        Calendar calyes = Calendar.getInstance();
        calyes.add(Calendar.DATE, -1);
        System.out.println(calyes.getTime());
        
        //Java 8
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        System.out.println(yesterday);
	}
}
