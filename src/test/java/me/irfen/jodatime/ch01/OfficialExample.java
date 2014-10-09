package me.irfen.jodatime.ch01;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.Test;

public class OfficialExample {

	@Test
	public void testIsAfterPayDay() {
		DateTime dateTime = new DateTime();
		System.out.println(isAfterPayDay(dateTime));
	}

	@Test
	public void testDaysToNewYear() {
		LocalDate fromDate = new LocalDate();
		System.out.println(daysToNewYear(fromDate));
	}
	
	@Test
	public void testIsRentalOverdue() {
		DateTime dateTime = new DateTime();
		System.out.println(isRentalOverdue(dateTime));
	}
	
	@Test
	public void testGetBirthMonthText() {
		LocalDate dateOfBirth = new LocalDate();
		System.out.println(getBirthMonthText(dateOfBirth));
	}

	private boolean isAfterPayDay(DateTime datetime) {
		if (datetime.getMonthOfYear() == 2) { // February is month 2!!
			return datetime.getDayOfMonth() > 26;
		}
		return datetime.getDayOfMonth() > 28;
	}

	private Days daysToNewYear(LocalDate fromDate) {
		LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
		return Days.daysBetween(fromDate, newYear);
	}

	private boolean isRentalOverdue(DateTime datetimeRented) {
		Period rentalPeriod = new Period().withDays(2).withHours(12);
		return datetimeRented.plus(rentalPeriod).isBeforeNow();
	}

	private String getBirthMonthText(LocalDate dateOfBirth) {
		return dateOfBirth.monthOfYear().getAsText(Locale.ENGLISH);
	}
}
