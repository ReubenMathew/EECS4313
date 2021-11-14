package eecs4313a2b;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.sf.borg.common.DateUtil;



/**
 * @author Ahmed Hagi (215043896)
 *
 */

public class DecisionTableTest {
	
	DateUtil d;

	@Before
	public void setUp() throws Exception {
		DateUtil d = new DateUtil();
	}

	@Test
	public void H1_M1() {
		String s = d.minuteString(0);
		assertTrue(s.equals("0 Minutes"));
	}
	
	@Test
	public void H1_M2() {
		String s = d.minuteString(1);
		assertTrue(s.equals("1 Minute"));
	}
	
	@Test
	public void H1_M3() {
		String s = d.minuteString(37);
		assertTrue(s.equals("37 Minutes"));
	}
	
	@Test
	public void H2_M1() {
		String s = d.minuteString(60);
		assertTrue(s.equals("1 Hour"));
	}
	
	@Test
	public void H2_M2() {
		String s = d.minuteString(61);
		assertTrue(s.equals("1 Hour 1 Minute"));
	}
	
	@Test
	public void H2_M3() {
		String s = d.minuteString(86);
		assertTrue(s.equals("1 Hour 26 Minutes"));
	}
	
	@Test
	public void H3_M1() {
		String s = d.minuteString(660);
		assertTrue(s.equals("11 Hours"));
	}
	
	@Test
	public void H3_M2() {
		String s = d.minuteString(361);
		assertTrue(s.equals("6 Hours 1 Minute"));
	}
	
	@Test
	public void H3_M3() {
		String s = d.minuteString(988);
		assertTrue(s.equals("16 Hours 28 Minutes"));
	}

}

