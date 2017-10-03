package question_5;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Small test suite used to check the functionality of the Q5 code.
 * @author Lucas Sherlock
 *
 */
public class Q5Tests {

	private String testString = null;

	@Test
	public void testRepeatedPairTrue() {
		testString = "qjhvhtzxzqqjkmpb";
		assertTrue(Q5.containsRepeatedPair(testString));
	}
	
	@Test
	public void testRepeatedPairTrue2() {
		testString = "uurcxstgmygtbstg";
		assertTrue(Q5.containsRepeatedPair(testString));
	}
	
	@Test
	public void testRepeatedPairTrue3() {
		testString = "xxyxx";
		assertTrue(Q5.containsRepeatedPair(testString));
	}
	
	@Test
	public void testRepeatedPairFalse1() {
		testString = "ieodomkazucvgmuy";
		assertFalse(Q5.containsRepeatedPair(testString));
	}
	
	@Test
	public void testRepeatedPairFalse2() {
		testString = "saaasjdgfbns";
		assertFalse(Q5.containsRepeatedPair(testString));
	}
}
