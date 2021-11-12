package eecs4313a2w;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
public class Equivalence_WhiteBoxTests {
	
	// This is the method chosen for Equivalence Class Testing
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
	private static int nthdom(int year, int month, int dayofweek, int week) {
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		cal.set(Calendar.DAY_OF_WEEK, dayofweek);
		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, week);
		return (cal.get(Calendar.DATE));
	}

	@Test
	public void test1() {
		assertTrue(nthdom(2004, 0, 1, -1) == 25);
	}
	
	@Test
	public void test2() {
		assertTrue(nthdom(1, 11, 7, 6) == 7);
	}

	@Test
	public void test3() {
		assertTrue(nthdom(292278994, 4, 4, 2) == 14);
	}
	
	@Test
	public void test4() {
		assertTrue(nthdom(2017, 4, 3, 1) == 2);
	}
	
	@Test
	public void test5() {
		assertTrue(nthdom(0, 4, 3, 1) == 4);
	}
	
	@Test
	public void test6() {
		assertTrue(nthdom(2017, -1, 3, 1) == 6);
	}
	
	@Test
	public void test7() {
		assertTrue(nthdom(2017, 4, 0, 1) == 6);
	}
	
	@Test
	public void test8() {
		assertTrue(nthdom(2017, 4, 3, -2) == 23);
	}
	
	@Test
	public void test9() {
		assertTrue(nthdom(292278995, 4, 3, 1) == 20);
	}
	
	@Test
	public void test10() {
		assertTrue(nthdom(2017, 12, 3, 1) == 2);
	}
	
	@Test
	public void test11() {
		assertTrue(nthdom(2017, 4, 8, 1) == 7);
	}
	
	@Test
	public void test12() {
		assertTrue(nthdom(2017, 4, 3, 7) == 13);
	}
}
