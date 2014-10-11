package me.irfen.jodatime.ch02;

import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.junit.Test;

public class JodaTimeQuickStart {

	@Test
	public void testDateAndTime() {
		// 获取当前月份
		DateTime dt = new DateTime();
		int month = dt.getMonthOfYear();
		System.out.println(month);

		// 设定2000年/获取当前小时+2的小时
		DateTime year2000 = dt.withYear(2000);
		DateTime twoHoursLater = dt.plusHours(2);
		System.out.println(year2000.getYear());
		System.out.println(twoHoursLater.getHourOfDay());

		String monthName = dt.monthOfYear().getAsText();
		String frenchShortName = dt.monthOfYear().getAsShortText(Locale.FRENCH);
		boolean isLeapYear = dt.year().isLeap();
		DateTime rounded = dt.dayOfMonth().roundFloorCopy();
		System.out.println(monthName); // 本地月份名称
		System.out.println(frenchShortName); // 法语月份简称
		System.out.println(isLeapYear); // 是否闰年
		System.out.println(rounded); // 获取当天0:0:0的DateTime对象
	}

	@Test
	public void testChronologyAndTimeZone() {
		Chronology coptic = CopticChronology.getInstance();
		System.out.println(coptic); // CopticChronology[Asia/Shanghai]

		DateTimeZone zone = DateTimeZone.forID("Asia/Tokyo");
		Chronology gregorianJuian = GJChronology.getInstance(zone);
		System.out.println(gregorianJuian); // GJChronology[Asia/Tokyo]
	}

	@Test
	public void testTimeSpan() {
		DateTime beginDateTime = new DateTime(2010, 1, 1, 0, 0, 0);
		DateTime endDateTime = new DateTime(2015, 1, 1, 0, 0, 0);
		Interval interval = new Interval(beginDateTime, endDateTime);
		System.out.println(interval.containsNow()); // 是否包含当前时间
		System.out.println(interval.toDurationMillis()); // 时间间隔毫秒数
		
		DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
		DateTime plusPeriod = dt.plus(Period.days(1));
		System.out.println(plusPeriod); // Period的方式+1天
		DateTime plusDuration = dt.plus(new Duration(24L * 60L * 60L * 1000L));
		System.out.println(plusDuration); // Duration的方式+1天
	}
}
