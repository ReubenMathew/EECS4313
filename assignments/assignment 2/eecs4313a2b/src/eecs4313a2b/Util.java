package eecs4313a2b;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {

	// The method being tested, taken from
	// https://github.com/mikeberger/borg_calendar/blob/master/BORGCalendar/common/src/main/java/net/sf/borg/common/DateUtil.java
	/**
	 * Checks if one date falls on a later calendar day than another.
	 * 
	 * @param d1 the first date
	 * @param d2 the second date
	 * 
	 * @return true, if is after
	 */
	public static boolean isAfter(Date d1, Date d2) {

		GregorianCalendar tcal = new GregorianCalendar();
		tcal.setTime(d1);
		tcal.set(Calendar.HOUR_OF_DAY, 0);
		tcal.set(Calendar.MINUTE, 0);
		tcal.set(Calendar.SECOND, 0);
		GregorianCalendar dcal = new GregorianCalendar();
		dcal.setTime(d2);
		dcal.set(Calendar.HOUR_OF_DAY, 0);
		dcal.set(Calendar.MINUTE, 10);
		dcal.set(Calendar.SECOND, 0);

		if (tcal.getTime().after(dcal.getTime())) {
			return true;
		}
		System.out.println(tcal.getTime());
		System.out.println(dcal.getTime());

		return false;
	}
	
	/**
	 * generate a human readable string for a particular number of minutes
	 * 
	 * @param mins - the number of minutes
	 * 
	 * @return the string
	 */
	public static String minuteString(int mins) {
		
		int hours = mins / 60;
		int minsPast = mins % 60;
		
		String minutesString;
		String hoursString;
		
		if (hours > 1) {
			hoursString = hours + " " + "Hours";
		} else if (hours > 0) {
			hoursString = hours + " " + "Hour";
		} else {
			hoursString = "";
		}

		if (minsPast > 1) {
			minutesString = minsPast + " " + "Minutes";
		} else if (minsPast > 0) {
			minutesString = minsPast + " " + "Minute";
		} else if (hours >= 1) {
			minutesString = "";
		} else {
			minutesString = minsPast + " " + "Minutes";
		}

		// space between hours and minutes
		if (!hoursString.equals("") && !minutesString.equals(""))
			minutesString = " " + minutesString;

		return hoursString + minutesString;
	}
	
	/**
	 * compute nth day of month for calculating when certain holidays fall.
	 * 
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param dayofweek
	 *            the day of the week
	 * @param week
	 *            the week of the month
	 * 
	 * @return the date
	 */
	public static int nthdom(int year, int month, int dayofweek, int week) {
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		cal.set(Calendar.DAY_OF_WEEK, dayofweek);
		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, week);
		return (cal.get(Calendar.DATE));
	}
	
}
