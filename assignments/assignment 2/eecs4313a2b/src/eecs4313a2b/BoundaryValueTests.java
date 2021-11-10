package eecs4313a2b;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * @author Reuben Ninan (216315509)
 * 
 */
public class BoundaryValueTests {
	// The method being tested, taken from https://github.com/mikeberger/borg_calendar/blob/master/BORGCalendar/common/src/main/java/net/sf/borg/common/DateUtil.java
	/**
	 * Checks if one date falls on a later calendar day than another.
	 * 
	 * @param d1
	 *            the first date
	 * @param d2
	 *            the second date
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

		return false;
	}
	
	@Test
	public void test() {
		
	}

}