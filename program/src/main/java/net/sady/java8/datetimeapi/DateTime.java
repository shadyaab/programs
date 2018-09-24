package net.sady.java8.datetimeapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTime {
	
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		
		System.out.println(localDate);
		System.out.println(localDate.getMonth());
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate.getDayOfYear());
		System.out.println(localDate.getMonthValue());
		System.out.println(localDate.getEra());
		
		//localDate.plus(ChronoField.HOUR_OF_DAY, 1);
		
		System.out.println(localDate.plusDays(2));
		System.out.println(localDate.plusWeeks(2));
		System.out.println(localDate.minusYears(10));
		
		System.out.println(localDate.getDayOfWeek().getValue());
		System.out.println(localDate.get(ChronoField.DAY_OF_WEEK));
		
		DayOfWeek dow = DayOfWeek.of(localDate.get(ChronoField.DAY_OF_WEEK));
		
		
		if(localDate.getDayOfWeek().getValue() == 5){
			System.out.println(localDate.plus(2, ChronoUnit.DAYS));
		}
		
		
		//Creating own Date
		LocalDate customLocalDate =  LocalDate.of(2019, 02, 03);
		System.out.println(customLocalDate);
		
	}

}
