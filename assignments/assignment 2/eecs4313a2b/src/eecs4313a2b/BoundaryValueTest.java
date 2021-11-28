package eecs4313a2b;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Reuben Ninan (216315509)
 * 
 */
public class BoundaryValueTest {

	Util u;

	@Before
	public void setUp() throws Exception {
		u = new Util();
	}
	
	@Test
	public void test_d1_nominal_d2_min() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(0);

		Assert.assertTrue(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_minplus() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(1);;

		Assert.assertTrue(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(System.currentTimeMillis());;

		Assert.assertFalse(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_maxminus() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(Long.MAX_VALUE - 1);;

		Assert.assertFalse(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_nominal_d2_max() {
		// d1 nominal value = current time 
		Date d1 = new Date();
		Date d2 = new Date(Long.MAX_VALUE);

		Assert.assertFalse(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_min_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(0);
		Date d2 = new Date();

		Assert.assertFalse(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_minplus_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(1);
		Date d2 = new Date();

		Assert.assertFalse(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_maxminus_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(Long.MAX_VALUE - 1);
		Date d2 = new Date();

		Assert.assertTrue(Util.isAfter(d1, d2));
	}
	
	@Test
	public void test_d1_max_d2_nominal() {
		// d1 nominal value = current time 
		Date d1 = new Date(Long.MAX_VALUE);
		Date d2 = new Date();

		Assert.assertTrue(Util.isAfter(d1, d2));
	}

	@Test
	public void test_added_mutant1() {
		// d1 nominal value = current time
		Date d1 = new Date(2020854664);
		Date d2 = new Date(2020854650);

		Assert.assertFalse(Util.isAfter(d1, d2));
	}

	@Test
	public void test_added_mutant2() {
		// d1 nominal value = current time
		Date d1 = new Date(86400001);
		Date d2 = new Date(86400000);

		Assert.assertFalse(Util.isAfter(d1, d2));
	}
}