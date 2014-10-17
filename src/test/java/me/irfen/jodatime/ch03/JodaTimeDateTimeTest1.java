package me.irfen.jodatime.ch03;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

public class JodaTimeDateTimeTest1 {

	@Test
	public void testConstructor() {
		DateTime dt = new DateTime();
		System.out.println(dt.toString()); // 
		
		dt = new DateTime("2014-10-10T08:00:00"); // 使用的是ISO标准
		System.out.println(dt.toString()); // 2014-10-10T08:00:00.000+08:00
		
		dt = new DateTime(2014, 10, 10, 10, 10);
		System.out.println(dt.toString()); // 2014-10-10T10:10:00.000+08:00
		
		dt = new DateTime(2014, 10, 10, 10, 10, 10, 111);
		System.out.println(dt.toString()); // 2014-10-10T10:10:10.111+08:00
	}
	
	@Test
	public void testStatic() {
		DateTime dt = DateTime.now(); // DateTime dt = new DateTime();
		System.out.println(dt.toString()); // 
		
		dt = DateTime.parse("2014-10-10T08:00:00");
		System.out.println(dt.toString()); // 2014-10-10T08:00:00.000+08:00
		
		dt = DateTime.parse("2014-10-10 08:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dt.toString()); // 2014-10-10T08:00:00.000+08:00
	}
	
	@Test
	public void testJoda2JDK() {
		DateTime dt = new DateTime();
		Date d = dt.toDate();
		Calendar c = dt.toCalendar(Locale.CHINESE);
		GregorianCalendar gc = dt.toGregorianCalendar();
	}
	
	@Test
	public void testJDK2Joda() {
		DateTime dt = new DateTime(new Date());
		System.out.println(dt.toString()); // 
		dt = new DateTime(Calendar.getInstance());
		System.out.println(dt.toString()); // 
	}
}
