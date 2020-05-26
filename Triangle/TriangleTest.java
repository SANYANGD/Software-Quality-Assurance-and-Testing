package triangle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import triangle.Triangle;

public class TriangleTest {
	
	Triangle testTriangle = new Triangle();
	public TriangleTest() {	
	}
	@Before
	public void setUp() throws Exception {	
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		List<List<Integer>> tri1 = new LinkedList<>();
	    assertEquals(0,testTriangle.minimumTotal(tri1),0.000000001d);
	}
	@Test
	public void test2() {
		List<List<Integer>> tri2 = new LinkedList<>();
		tri2.add(new LinkedList<>(Arrays.asList(4)));
	    assertEquals(4,testTriangle.minimumTotal(tri2),0.000000001d);
	}
	@Test
	public void test3() {
		List<List<Integer>> tri3 = new LinkedList<>();
		tri3.add(new LinkedList<>(Arrays.asList(2)));
		tri3.add(new LinkedList<>(Arrays.asList(3, 4)));
		tri3.add(new LinkedList<>(Arrays.asList(6, 5, 7)));
		tri3.add(new LinkedList<>(Arrays.asList(4, 1, 8, 3)));
	    assertEquals(11,testTriangle.minimumTotal(tri3),0.000000001d);
	}
	@Test
	public void test4() {
		List<List<Integer>> tri4 = new LinkedList<>();
		tri4.add(new LinkedList<>(Arrays.asList(2)));
		tri4.add(new LinkedList<>(Arrays.asList(3, 4)));
		tri4.add(new LinkedList<>(Arrays.asList(6, 7, 5)));
		tri4.add(new LinkedList<>(Arrays.asList(4, 1, 8, 0)));
	    assertEquals(11,testTriangle.minimumTotal(tri4),0.000000001d);
	}
	@Test
	public void test5() {
		List<List<Integer>> tri5 = new LinkedList<>();
		tri5.add(new LinkedList<>(Arrays.asList(2)));
		tri5.add(new LinkedList<>(Arrays.asList(3, 4)));
		tri5.add(new LinkedList<>(Arrays.asList(6, 7, 5)));
		tri5.add(new LinkedList<>(Arrays.asList(4, 1, 8, 0)));
		tri5.add(new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4)));
	    assertEquals(13,testTriangle.minimumTotal(tri5),0.000000001d);
	}
	@Test
	public void test6() {
		List<List<Integer>> tri6 = new LinkedList<>();
		tri6.add(new LinkedList<>(Arrays.asList(-2)));
	    assertEquals(-2,testTriangle.minimumTotal(tri6),0.000000001d);
	}
}
