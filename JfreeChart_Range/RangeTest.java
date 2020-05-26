

package rangetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	/*
	 * 0 public Range(double lower, double upper)
     * 0 public double getLowerBound()
     * 1 public double getUpperBound()
     * 5 public double getLength()
     * 1 public double getCentralValue()
     * 5 public boolean contains(double value)
     * 8 public boolean intersects(double lower, double upper)
     * 1 public boolean intersects(Range range)
     * 5 public double constrain(double value)
     * 5 public static Range combine(Range range1, Range range2)
     * 6 public static Range expandToInclude(Range range, double value)
     * 3 public static Range expand(Range range, double lowerMargin, double upperMargin)
     * 1 public static Range shift(Range base, double delta)
     * 3 public static Range shift(Range base, double delta, boolean allowZeroCrossing)
     * 3 private static double shiftWithNoZeroCrossing(double value, double delta)
     * 6 public static Range scale(Range base, double factor)
     * 6 public boolean equals(Object obj)
     * 1 public int hashCode()
     * 1 public String toString()
	 */
	private Range testRange;
	public RangeTest() {	
	}
	@Before
	public void setUp() throws Exception {
		testRange = new Range(-1,1);
	}
	@After
	public void tearDown() throws Exception {
		testRange = null;
	}

	@Test (expected = IllegalArgumentException.class)
	public void testUpperBound4() {
		new Range(12,5).getUpperBound();
	}
	
	@Test
	public void testGetLength1() {
		double valueGetLength1 = new Range(1,1).getLength();
		assertEquals(0,valueGetLength1,0.000000001d);
	}
	@Test
	public void testGetLength2() {
		double valueGetLength2 = new Range(-1,1).getLength();
		assertEquals(2,valueGetLength2,0.000000001d);
	}
	@Test
	public void testGetLength3() {
		double valueGetLength3 = new Range(0,1).getLength();
		assertEquals(1,valueGetLength3,0.000000001d);
	}
	@Test
	public void testGetLength4() {
		double valueGetLength4 = new Range(-1,0).getLength();
		assertEquals(1,valueGetLength4,0.000000001d);
	}
	@Test
	public void testGetLength5() {
		double valueGetLength5 = new Range(0,0).getLength();
		assertEquals(0,valueGetLength5,0.000000001d);
	}
	
	@Test
	public void testGetCentralValue1() {
		double valueGetCentralValue1 = testRange.getCentralValue();
		assertEquals(0,valueGetCentralValue1,0.000000001d);
	}
	@Test
	public void testGetCentralValue2() {
		double valueGetCentralValue2 = new Range(1,3).getCentralValue();
		assertEquals(2,valueGetCentralValue2,0.000000001d);
	}
	
	@Test
	public void testContains1() {
		boolean ifContains1 = testRange.contains(0);
		assertTrue(ifContains1);
	}
	@Test
	public void testContains2() {
		boolean ifContains2 = testRange.contains(10);
		assertFalse(ifContains2);
	}
	@Test
	public void testContains3() {
		boolean ifContains3 = testRange.contains(1);
		assertTrue(ifContains3);
	}
	@Test
	public void testContains4() {
		boolean ifContains4 = testRange.contains(-10);
		assertFalse(ifContains4);
	}
	@Test
	public void testContains5() {
		boolean ifContains5 = testRange.contains(-1);
		assertTrue(ifContains5);
	}
	
	@Test
	public void testIntersects1() {
		boolean ifIntersects1 = testRange.intersects(1, 2);
		assertTrue(ifIntersects1);
	}
	@Test
	public void testIntersects2() {
		boolean ifIntersects2 = testRange.intersects(-2, -1);
		assertTrue(ifIntersects2);
	}
	@Test
	public void testIntersects3() {
		boolean ifIntersects3 = testRange.intersects(2, 3);
		assertFalse(ifIntersects3);
	}
	@Test
	public void testIntersects4() {
		boolean ifIntersects4 = testRange.intersects(-0.5, 0.5);
		assertTrue(ifIntersects4);
	}
	@Test
	public void testIntersects5() {
		boolean ifIntersects5 = testRange.intersects(-2, 2);
		assertTrue(ifIntersects5);
	}
	@Test
	public void testIntersects6() {
		boolean ifIntersects6 = testRange.intersects(-4, -3);
		assertFalse(ifIntersects6);
	}
	@Test
	public void testIntersects7() {
		boolean ifIntersects7 = testRange.intersects(-2, 0);
		assertTrue(ifIntersects7);
	}
	@Test
	public void testIntersects8() {
		boolean ifIntersects8 = testRange.intersects(0, 2);
		assertTrue(ifIntersects8);
	}
	
	@Test
	public void testIntersectsA() {
		boolean ifIntersectsA = testRange.intersects(new Range(-2,2));
		assertTrue(ifIntersectsA);
	}
	@Test
	public void testIntersectsB() {
		boolean ifIntersectsB = testRange.intersects(new Range(-4, -3));
		assertFalse(ifIntersectsB);
	}
	
	@Test
	public void testConstrain1() {
		double valueConstrain1 = testRange.constrain(0);
		assertEquals(0,valueConstrain1,0.000000001d);
	}
	@Test
	public void testConstrain2() {
		double valueConstrain2 = testRange.constrain(10);
		assertEquals(1,valueConstrain2,0.000000001d);
	}
	@Test
	public void testConstrain3() {
		double valueConstrain3 = testRange.constrain(-10);
		assertEquals(-1,valueConstrain3,0.000000001d);
	}
	@Test
	public void testConstrain4() {
		double valueConstrain4 = testRange.constrain(-1);
		assertEquals(-1,valueConstrain4,0.000000001d);
	}
	@Test
	public void testConstrain5() {
		double valueConstrain5 = testRange.constrain(1);
		assertEquals(1,valueConstrain5,0.000000001d);
	}
	
	@Test
	public void testCombine1() {
		Range testCombine1 = Range.combine(null,null);
		assertNull(testCombine1);
	}
	@Test
	public void testCombine2() {
		Range testCombine2 = Range.combine(testRange,null);
		assertEquals(-1,testCombine2.getLowerBound(),0.000000001d);
		assertEquals(1,testCombine2.getUpperBound(),0.000000001d);
	}
	@Test
	public void testCombine3() {
		Range testCombine3 = Range.combine(null,testRange);
		assertEquals(-1,testCombine3.getLowerBound(),0.000000001d);
		assertEquals(1,testCombine3.getUpperBound(),0.000000001d);
	}
	@Test
	public void testCombine4() {
		Range testCombine4 = Range.combine(testRange,new Range(-2,2));
		assertEquals(-2,testCombine4.getLowerBound(),0.000000001d);
		assertEquals(2,testCombine4.getUpperBound(),0.000000001d);
	}
	@Test
	public void testCombine5() {
		Range testCombine5 = Range.combine(testRange,new Range(2,4));
		assertEquals(-1,testCombine5.getLowerBound(),0.000000001d);
		assertEquals(4,testCombine5.getUpperBound(),0.000000001d);
	}
	
	@Test
	public void testExpandToInclude1() {
		Range testExpandToInclude1 = Range.expandToInclude(null,0);
		assertEquals(0,testExpandToInclude1.getLowerBound(),0.000000001d);
		assertEquals(0,testExpandToInclude1.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpandToInclude2() {
		Range testExpandToInclude2 = Range.expandToInclude(testRange,0);
		assertEquals(-1,testExpandToInclude2.getLowerBound(),0.000000001d);
		assertEquals(1,testExpandToInclude2.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpandToInclude3() {
		Range testExpandToInclude3 = Range.expandToInclude(testRange,1);
		assertEquals(-1,testExpandToInclude3.getLowerBound(),0.000000001d);
		assertEquals(1,testExpandToInclude3.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpandToInclude4() {
		Range testExpandToInclude4 = Range.expandToInclude(testRange,-1);
		assertEquals(-1,testExpandToInclude4.getLowerBound(),0.000000001d);
		assertEquals(1,testExpandToInclude4.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpandToInclude5() {
		Range testExpandToInclude5 = Range.expandToInclude(testRange,2);
		assertEquals(-1,testExpandToInclude5.getLowerBound(),0.000000001d);
		assertEquals(2,testExpandToInclude5.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpandToInclude6() {
		Range testExpandToInclude6 = Range.expandToInclude(testRange,-2);
		assertEquals(-2,testExpandToInclude6.getLowerBound(),0.000000001d);
		assertEquals(1,testExpandToInclude6.getUpperBound(),0.000000001d);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testExpand1(){
		Range testExpand1 = Range.expand(null, 1, 1);
	}
	@Test
	public void testExpand2(){
		Range testExpand2 = Range.expand(testRange, 1, 1);
		assertEquals(-3,testExpand2.getLowerBound(),0.000000001d);
		assertEquals(3,testExpand2.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpand3(){
		Range testExpand3 = Range.expand(testRange, -3, 1);
		assertEquals(4,testExpand3.getLowerBound(),0.000000001d);
		assertEquals(4,testExpand3.getUpperBound(),0.000000001d);
	}
	@Test
	public void testExpand4(){
		Range testExpand4 = Range.expand(testRange, 1, 0);
		assertEquals(-3,testExpand4.getLowerBound(),0.000000001d);
		assertEquals(1,testExpand4.getUpperBound(),0.000000001d);
	}

	@Test
	public void testShift() {
		Range testShift = Range.shift(testRange, 0);
		assertEquals(-1,testShift.getLowerBound(),0.000000001d);
		assertEquals(1,testShift.getUpperBound(),0.000000001d);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testShift1() {
		Range testShift1 = Range.shift(null, 0, false);
	}
	@Test
	public void testShift2() {
		Range testShift2 = Range.shift(testRange, 1, true);
		assertEquals(0,testShift2.getLowerBound(),0.000000001d);
		assertEquals(2,testShift2.getUpperBound(),0.000000001d);
	}
	@Test
	public void testShift3() {
		Range testShift3 = Range.shift(testRange, 0, false);
		assertEquals(-1,testShift3.getLowerBound(),0.000000001d);
		assertEquals(1,testShift3.getUpperBound(),0.000000001d);
	}
	@Test
	public void testShift4() {
		Range testShift4 = Range.shift(testRange, -2, true);
		assertEquals(-3,testShift4.getLowerBound(),0.000000001d);
		assertEquals(-1,testShift4.getUpperBound(),0.000000001d);
	}
	
	@Test
	public void testShiftWithNoZeroCrossing1(){
		double testShiftWithNoZeroCrossing1 = Range.shiftWithNoZeroCrossing(1,1);
		assertEquals(2,testShiftWithNoZeroCrossing1,0.000000001d);
	}
	@Test
	public void testShiftWithNoZeroCrossing2(){
		double testShiftWithNoZeroCrossing2 = Range.shiftWithNoZeroCrossing(-1,1);
		assertEquals(0,testShiftWithNoZeroCrossing2,0.000000001d);
	}
	@Test
	public void testShiftWithNoZeroCrossing3(){
		double testShiftWithNoZeroCrossing3 = Range.shiftWithNoZeroCrossing(0,1);
		assertEquals(1,testShiftWithNoZeroCrossing3,0.000000001d);
	}
	@Test
	public void testShiftWithNoZeroCrossing4(){
		double testShiftWithNoZeroCrossing4 = Range.shiftWithNoZeroCrossing(0,-2);
		assertEquals(-2,testShiftWithNoZeroCrossing4,0.000000001d);
	}
	
	@Test
	public void testScale1() {
		Range testScale1 = Range.scale(testRange,0);
		assertEquals(0,testScale1.getLowerBound(),0.000000001d);
		assertEquals(0,testScale1.getUpperBound(),0.000000001d);
	}
	@Test
	public void testScale2() {
		Range testScale2 = Range.scale(testRange,1);
		assertEquals(-1,testScale2.getLowerBound(),0.000000001d);
		assertEquals(1,testScale2.getUpperBound(),0.000000001d);
	}
	@Test
	public void testScale3() {
		Range testScale3 = Range.scale(testRange,2);
		assertEquals(-2,testScale3.getLowerBound(),0.000000001d);
		assertEquals(2,testScale3.getUpperBound(),0.000000001d);
	}
	@Test
	public void testScale4() {
		Range testScale4 = Range.scale(testRange,0.5);
		assertEquals(-0.5,testScale4.getLowerBound(),0.000000001d);
		assertEquals(0.5,testScale4.getUpperBound(),0.000000001d);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testScale5() {
		Range testScale5 = Range.scale(null,0.5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testScale6() {
		Range testScale6 = Range.scale(testRange,-0.5);
	}

	@Test
	public void testEquals1() {
		boolean ifEquals1 = testRange.equals(new Range(-1,1));
		assertTrue(ifEquals1);
	}
	@Test
	public void testEquals2() {
		boolean ifEquals2 = testRange.equals(new Range(-1,2));
		assertFalse(ifEquals2);
	}
	@Test
	public void testEquals3() {
		boolean ifEquals3 = testRange.equals(new Range(0,1));
		assertFalse(ifEquals3);
	}
	@Test
	public void testEquals4() {
		boolean ifEquals4 = testRange.equals(new Range(0.5,0.5));
		assertFalse(ifEquals4);
	}
	@Test
	public void testEquals5() {
		boolean ifEquals5 = testRange.equals(new Range(3,4));
		assertFalse(ifEquals5);
	}
	@Test
	public void testEquals6() {
		boolean ifEquals6 = testRange.equals(null);
		assertFalse(ifEquals6);
	}
	
	@Test
	public void testHashCode() {
		int testHashCode = testRange.hashCode();
		assertEquals(-31457280,testHashCode);
	}
	
	@Test
	public void testToString() {
		String testToString = testRange.toString();
		assertEquals("Range[-1.0,1.0]", testToString);
	}
}
