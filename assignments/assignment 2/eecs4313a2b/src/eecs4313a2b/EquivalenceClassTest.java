package eecs4313a2b;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Eric Kwok (216307150)
 *
 */
public class EquivalenceClassTest {

	@Test
	public void test1() {
		assertTrue(Util.nthdom(2004, 0, 1, -1) == 25);
	}
	
	@Test
	public void test2() {
		assertTrue(Util.nthdom(1, 11, 7, 6) == 7);
	}

	@Test
	public void test3() {
		assertTrue(Util.nthdom(292278994, 4, 4, 2) == 14);
	}
	
	@Test
	public void test4() {
		assertTrue(Util.nthdom(2017, 4, 3, 1) == 2);
	}
	
	@Test
	public void test5() {
		assertTrue(Util.nthdom(0, 4, 3, 1) == 4);
	}
	
	@Test
	public void test6() {
		assertTrue(Util.nthdom(2017, -1, 3, 1) == 6);
	}
	
	@Test
	public void test7() {
		assertTrue(Util.nthdom(2017, 4, 0, 1) == 6);
	}
	
	@Test
	public void test8() {
		assertTrue(Util.nthdom(2017, 4, 3, -2) == 23);
	}
	
	@Test
	public void test9() {
		assertTrue(Util.nthdom(292278995, 4, 3, 1) == 20);
	}
	
	@Test
	public void test10() {
		assertTrue(Util.nthdom(2017, 12, 3, 1) == 2);
	}
	
	@Test
	public void test11() {
		assertTrue(Util.nthdom(2017, 4, 8, 1) == 7);
	}
	
	@Test
	public void test12() {
		assertTrue(Util.nthdom(2017, 4, 3, 7) == 13);
	}
}
