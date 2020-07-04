package com.datatypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomDate {
	public static void main(String[] args) {
		int minday = (int)LocalDate.of(1990, 1, 1).toEpochDay();
		System.out.println(minday);
		
		int maxday = (int)LocalDate.of(1991, 1, 1).toEpochDay();
		System.out.println(maxday);
		
		int randomdate = minday + new Random().nextInt(maxday-minday);
		System.out.println(randomdate);
		
		LocalDate ld = LocalDate.ofEpochDay(randomdate);
		System.out.println(ld);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
		System.out.println(ld.format(formatter));
	}
}
