package eecs4313a2b;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Reuben Ninan (216315509)
 * 
 */
public class BoundaryValueTests {
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
	
	long[] values = {0, 1, System.currentTimeMillis(), Long.MAX_VALUE - 1, Long.MAX_VALUE};

	@Test
	public void test_d1_nominal_d2_min() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(values[0]);;

		Assert.assertTrue(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_minplus() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(values[1]);;

		Assert.assertTrue(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(values[2]);;

		Assert.assertFalse(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_maxminus() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(values[3]);;

		Assert.assertFalse(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_max() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(values[4]);;

		Assert.assertFalse(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_min_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(values[0]);
		Date d2 = new Date();

		Assert.assertFalse(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_minplus_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(values[1]);
		Date d2 = new Date();

		Assert.assertFalse(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_maxminus_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(values[3]);
		Date d2 = new Date();

		Assert.assertTrue(isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_max_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(values[4]);
		Date d2 = new Date();

		Assert.assertTrue(isAfter(d1, d2));
	}

}