package com.practice;

import java.time.LocalDate;

/**
 * This program tests the java inner class Date.
 * It prints the current month calendar.
 * Besides, it itself is a good exercise of coding.
 * @author kavin
 *
 */

public class CalendarTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println("Today is: " + date.toString());
		System.out.println("The current month calendar: ");
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();
		date = date.minusDays(today-1);	
		System.out.println("Mon Tue Wes Thu Fri Sat Sun");
		for(int i = 1; i < date.getDayOfWeek().getValue(); ++i) {
			System.out.print("    ");
		}
		while(date.getMonthValue() == month) {
			System.out.printf("%3d", date.getDayOfMonth());
			if(date.getDayOfMonth() == today) {
				System.out.print("*");
			}
			else {
				System.out.print(" ");
			}
			date = date.plusDays(1);
			if(date.getDayOfWeek().getValue() == 1) {
				System.out.println();
			}
		}		
	}
}