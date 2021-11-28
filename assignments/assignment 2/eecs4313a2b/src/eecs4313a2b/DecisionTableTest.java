package eecs4313a2b;


import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ahmed Hagi (215043896)
 *
 */

public class DecisionTableTest {

	@Test
	public void H1_M1() {
		assertTrue(Util.minuteString(0).equals("0 Minutes"));
	}
	
	@Test
	public void H1_M2() {
		assertTrue(Util.minuteString(1).equals("1 Minute"));
	}
	
	@Test
	public void H1_M3() {
		assertTrue(Util.minuteString(37).equals("37 Minutes"));
	}
	
	@Test
	public void H2_M1() {
		assertTrue(Util.minuteString(60).equals("1 Hour"));
	}
	
	@Test
	public void H2_M2() {
		assertTrue(Util.minuteString(61).equals("1 Hour 1 Minute"));
	}
	
	@Test
	public void H2_M3() {
		assertTrue(Util.minuteString(86).equals("1 Hour 26 Minutes"));
	}
	
	@Test
	public void H3_M1() {
		assertTrue(Util.minuteString(660).equals("11 Hours"));
	}
	
	@Test
	public void H3_M2() {
		assertTrue(Util.minuteString(361).equals("6 Hours 1 Minute"));
	}
	
	@Test
	public void H3_M3() {
		assertTrue(Util.minuteString(988).equals("16 Hours 28 Minutes"));
	}

}

