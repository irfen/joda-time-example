package me.irfen.jodatime.ch04;

import java.util.Locale;

import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTimeDateTimeTest2 {

	@Test
	public void testGetNumber() {
		DateTime dt = new DateTime(2014, 10, 10, 12, 15, 30);
		System.out.println(dt.getEra()); // 1 == > AD ==> DateTimeConstants.AD
		System.out.println(dt.getYear()); // 2014
		System.out.println(dt.getMonthOfYear()); // 10
		System.out.println(dt.getDayOfMonth()); // 10
		System.out.println(dt.getWeekOfWeekyear()); // 41
		System.out.println(dt.getHourOfDay()); // 12
		System.out.println(dt.getMinuteOfHour()); // 15
		System.out.println(dt.getSecondOfMinute()); // 30
		System.out.println(dt.getYearOfCentury()); // 14
		System.out.println(dt.getDayOfWeek()); // 5
		System.out.println(dt.getDayOfYear()); // 283
	}
	
	@Test
	public void testProperty() {
		DateTime dt = new DateTime("2014-10-10");
		System.out.println(dt.dayOfWeek().getAsText()); // 星期五
		System.out.println(dt.dayOfWeek().getAsText(Locale.ENGLISH)); // Friday
		System.out.println(dt.dayOfWeek().getAsText(Locale.JAPAN)); // 金曜日
		
		System.out.println(dt.dayOfWeek().getAsShortText(Locale.ENGLISH)); // Fri
		System.out.println(dt.dayOfWeek().getAsShortText(Locale.JAPAN)); // 金
		
		System.out.println(dt.dayOfWeek().isLeap()); // false
		
		System.out.println(dt.dayOfWeek().getMinimumValue()); // 1
		System.out.println(dt.dayOfWeek().getMaximumValue()); // 7
	}
}
