import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author Modified by: Adanna
 */
@RunWith(Parameterized.class)
public class CorrectnessTest {
	/**
	 * I am using JUnit with a parameterized class therefore I can compare all my
	 * test values in my test plan with the expected results and actual result.
	 */
	Algorithms alg;
	List<Shape> shapes;
	List<Sheet> sheets;
	List<Integer> expectedHeights;
	List<Integer> expectedWidth;
	List<Integer> allShelvesHeight;
	int numSheets;
	int numShelves;
	int numShapes;
	int algorithm;

	public CorrectnessTest(int algorithm, List<Shape> shapes, List<Integer> expectedHeights,
			List<Integer> allShelvesHeight, List<Integer> expectedWidth, int numSheets, int numShelves, int numShapes) {
		/**
		 * This is a consttructurer
		 */
		super();
		this.algorithm = algorithm;
		this.shapes = shapes;
		this.expectedHeights = expectedHeights;
		this.expectedWidth = expectedWidth;
		this.numSheets = numSheets;
		this.numShelves = numShelves;
		this.numShapes = numShapes;
		this.allShelvesHeight = allShelvesHeight;

	}

	@Before
	public void setup() {
		/**
		 * This will test what algorithm to use based from the first parameter in my
		 * contractor.
		 */
		alg = new Algorithms();
		if (algorithm == 0) {
			sheets = alg.nextFit(shapes);
		} else {
			sheets = alg.firstFit(shapes);
		}
	}

	@Test
	public void testAllShelvesHeight() {
		/**
		 * This is testing that all it produces the correct height for the amount of
		 * shelves in each sheet.
		 */
		List<Integer> heights = new ArrayList<>();
		for (Sheet s : sheets) {
			heights.add(s.allShelvesHeight());
		}

		assertEquals(allShelvesHeight, heights);
	}

	@Test
	public void testMaxHeight() {
		/**
		 * This is testing that it has the correct height for each shelf
		 */
		List<Integer> heights = new ArrayList<>(); // holds a list of heights
		for (Sheet s : sheets) {
			for (Shelf shelf : s.getShelves()) {
				heights.add(shelf.getHeight());

			}
		}
		assertEquals(expectedHeights, heights);

	}

	@Test
	public void testMaxWidth() {
		/*
		 * this is testing the max width of every shelf in my sheet
		 */
		List<Integer> width = new ArrayList<>();
		for (Sheet s : sheets) { // for every sheet
			for (Shelf shelf : s.getShelves()) { // got through the shelf
				width.add(shelf.getWidth()); // add to the width
			}
		}
		assertEquals(expectedWidth, width); // compare width to see if there are the same
	}

	@Test
	public void testNumSheets() {
		/**
		 * This is testing the number of sheets
		 */
		assertEquals(numSheets, sheets.size());

	}

	@Test
	public void testNumShelves() {
		int num = 0; // number of shelves
		for (Sheet s : sheets) { // for each sheet
			num += s.getShelves().size(); // get the number of shelves
		}

		assertEquals(numShelves, num);
	}

	@Test
	public void testNumShapes() {
		/*
		 * this is comparing the number of shapes in sheets
		 */
		int num = 0; // number of shelves
		for (Sheet s : sheets) { // for each sheet
			for (Shelf shelf : s.getShelves()) { // for each shelf
				num += shelf.shapes.size(); // get the number of shapes
			}
		}
		assertEquals(numShapes, num);
	}

	/*
	 * This is the setting up the parameters that would go into by JUnit class once
	 * it inialises
	 */
	@Parameterized.Parameters
	public static Collection<Object[]> input() {
		/**
		 * This code below is testing case [0] in my test plan
		 * 
		 */
		Algorithms b = new Algorithms();
		List<Shape> s0 = new ArrayList<>();
		s0.add(new Shape(80, 95));
		s0.add(new Shape(78, 49));
		s0.add(new Shape(29, 93));
		s0.add(new Shape(38, 83));
		s0.add(new Shape(62, 92));
		List<Integer> hS0 = new ArrayList<>();
		hS0.add(95);
		List<Integer> h0 = new ArrayList<>();
		h0.add(95); // number of expected height
		List<Integer> w0 = new ArrayList<>();
		w0.add(287); // number of expected width

		/**
		 * This code below is testing test case [1] in my test plan
		 */
		List<Shape> s1 = new ArrayList<>();
		s1.add(new Shape(251, 53));
		s1.add(new Shape(42, 40));
		s1.add(new Shape(158, 150));
		s1.add(new Shape(146, 50));
		List<Integer> hS1 = new ArrayList<>();
		hS1.add(203);
		List<Integer> h1 = new ArrayList<>();
		h1.add(53);
		h1.add(150);
		List<Integer> w1 = new ArrayList<>();
		w1.add(293);
		w1.add(208);

		/**
		 * This code below is testing test case [2] in my test plan
		 */
		List<Shape> s2 = new ArrayList<>();
		s2.add(new Shape(251, 53));
		s2.add(new Shape(42, 40));
		s2.add(new Shape(158, 50));
		s2.add(new Shape(170, 53));
		List<Integer> hS2 = new ArrayList<>();
		hS2.add(156);
		List<Integer> h2 = new ArrayList<>();
		h2.add(53);
		h2.add(50);
		h2.add(53);
		List<Integer> w2 = new ArrayList<>();
		w2.add(293);
		w2.add(158);
		w2.add(170);

		/**
		 * This code below is testing test case [3] in my test plan
		 */

		List<Shape> s3 = new ArrayList<>();
		s3.add(new Shape(150, 88));
		s3.add(new Shape(250, 178));
		s3.add(new Shape(300, 59));

		List<Integer> hS3 = new ArrayList<>();
		hS3.add(88);
		hS3.add(237);
		List<Integer> h3 = new ArrayList<>();
		h3.add(88);
		h3.add(178);
		h3.add(59);
		List<Integer> w3 = new ArrayList<>();
		w3.add(150);
		w3.add(250);
		w3.add(300);

		/**
		 * This code below is testing test case [4] in my test plan
		 */
		List<Shape> s4 = new ArrayList<>();
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 30));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 48));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 8));
		s4.add(new Shape(2, 34));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 50));
		s4.add(new Shape(2, 45));
		List<Integer> hS4 = new ArrayList<>();
		hS4.add(50);
		hS4.add(45);
		List<Integer> h4 = new ArrayList<>();
		h4.add(50);
		h4.add(45);
		List<Integer> w4 = new ArrayList<>();
		w4.add(40);
		w4.add(2);

		/**
		 * This code below is testing test case [5] in my test plan
		 */
		List<Shape> s5 = new ArrayList<>();
		s5.add(new Shape(15, 50));
		s5.add(new Shape(285, 50));
		List<Integer> hS5 = new ArrayList<>();
		hS5.add(50);
		List<Integer> h5 = new ArrayList<>();
		h5.add(50);
		List<Integer> w5 = new ArrayList<>();
		w5.add(300);

		/**
		 * This code below is testing test case [6] in my test plan
		 */
		List<Shape> s6 = new ArrayList<>();
		s6.add(new Shape(43, 166));
		s6.add(new Shape(92, 115));
		s6.add(new Shape(166, 165));
		List<Integer> hS6 = new ArrayList<>();
		hS6.add(166);
		List<Integer> h6 = new ArrayList<>();
		h6.add(166);
		List<Integer> w6 = new ArrayList<>();
		w6.add(300);

		/**
		 * This code below is testing test case [7] in my test plan
		 */
		List<Shape> s7 = new ArrayList<>();
		s7.add(new Shape(43, 166));
		s7.add(new Shape(92, 115));
		s7.add(new Shape(166, 166));
		List<Integer> hS7 = new ArrayList<>();
		hS7.add(166);
		hS7.add(166);
		List<Integer> h7 = new ArrayList<>();
		h7.add(166);
		h7.add(166);
		List<Integer> w7 = new ArrayList<>();
		w7.add(135);
		w7.add(166);

		/**
		 * Below are test cases corresponding with the new first fit algorithm
		 */

		/**
		 * This code below is testing test case [8] in my test plan
		 */
		List<Shape> s8 = new ArrayList<>();
		s8.add(new Shape(80, 95));
		s8.add(new Shape(78, 49));
		s8.add(new Shape(29, 93));
		s8.add(new Shape(38, 83));
		s8.add(new Shape(62, 92));
		List<Integer> hS8 = new ArrayList<>();
		hS8.add(95);
		List<Integer> h8 = new ArrayList<>();
		h8.add(95); // number of expected height
		List<Integer> w8 = new ArrayList<>();
		w8.add(287); // number of expected width

		/**
		 * This code below is testing test case [9] in my test plan
		 */
		List<Shape> s9 = new ArrayList<>();
		s9.add(new Shape(251, 53));
		s9.add(new Shape(42, 40));
		s9.add(new Shape(158, 150));
		s9.add(new Shape(146, 50));
		s9.add(new Shape(5, 30));
		System.out.println(b.firstFit(s9));
		List<Integer> hS9 = new ArrayList<>();
		hS9.add(203);
		List<Integer> h9 = new ArrayList<>();
		h9.add(53); // number of expected height
		h9.add(150);
		List<Integer> w9 = new ArrayList<>();
		w9.add(298); // number of expected height
		w9.add(208);

		/**
		 * This code below is testing test case [10] in my test plan
		 *
		 */
		List<Shape> s10 = new ArrayList<>();
		s10.add(new Shape(251, 53));
		s10.add(new Shape(42, 40));
		s10.add(new Shape(158, 50));
		s10.add(new Shape(170, 53));
		s10.add(new Shape(6, 40));
		s10.add(new Shape(43, 116));
		List<Integer> hS10 = new ArrayList<>();
		hS10.add(156);
		List<Integer> h10 = new ArrayList<>();
		h10.add(53); // number of expected height
		h10.add(50);
		h10.add(53);
		List<Integer> w10 = new ArrayList<>();
		w10.add(299);
		w10.add(274);
		w10.add(170);

		/**
		 * This code below is testing test case [11] in my test plan
		 * 
		 */
		List<Shape> s11 = new ArrayList<>();

		s11.add(new Shape(150, 88));
		s11.add(new Shape(250, 178));
		s11.add(new Shape(300, 59));
		s11.add(new Shape(60, 78));
		s11.add(new Shape(38, 37));
		s11.add(new Shape(47, 38));
		List<Integer> hS11 = new ArrayList<>();
		hS11.add(147);
		hS11.add(178);
		List<Integer> h11 = new ArrayList<>();
		h11.add(88);
		h11.add(59);
		h11.add(178);
		List<Integer> w11 = new ArrayList<>();
		w11.add(295);
		w11.add(300);
		w11.add(250);

		/**
		 * This code below is testing test case [12] in my test plan
		 *
		 */
		List<Shape> s12 = new ArrayList<>();
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 30));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 48));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 8));
		s12.add(new Shape(2, 34));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(2, 50));
		s12.add(new Shape(150, 88));
		s12.add(new Shape(250, 178));
		s12.add(new Shape(300, 59));
		s12.add(new Shape(60, 78));
		s12.add(new Shape(38, 37));
		s12.add(new Shape(47, 38));
		List<Integer> hS12 = new ArrayList<>();
		hS12.add(50);
		hS12.add(147);
		hS12.add(178);
		List<Integer> h12 = new ArrayList<>();
		h12.add(50);
		h12.add(88);
		h12.add(59);
		h12.add(178);
		List<Integer> w12 = new ArrayList<>();
		w12.add(40);
		w12.add(295);
		w12.add(300);
		w12.add(250);

		/**
		 * This is a static method that returns the test values into our correct test
		 * class to test.
		 */
		return Arrays.asList(new Object[][] { { 0, s0, h0, hS0, w0, 1, 1, 5 }, { 0, s1, h1, hS1, w1, 1, 2, 4 },
				{ 0, s2, h2, hS2, w2, 1, 3, 4 }, { 0, s3, h3, hS3, w3, 2, 3, 3 }, { 0, s4, h4, hS4, w4, 2, 2, 21 },
				{ 0, s5, h5, hS5, w5, 1, 1, 2 }, { 0, s6, h6, hS6, w6, 1, 1, 3 }, { 0, s7, h7, hS7, w7, 2, 2, 3 },
				{ 1, s8, h8, hS8, w8, 1, 1, 5 }, { 1, s9, h9, hS9, w9, 1, 2, 5 }, { 1, s10, h10, hS10, w10, 1, 3, 6 },
				{ 1, s11, h11, hS11, w11, 2, 3, 6 }, { 1, s12, h12, hS12, w12, 3, 4, 26 } });
	}

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*********** Correctness testing *************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Here you will need to validate that your algorithms (nextFit() and
		 * firstFit()) behave as expected on small data sets. Think about normal cases
		 * and border cases. You can use any additional method you created in this class
		 */

		/**
		 * Testing edge cases using print statements instead.
		 */
		Algorithms a = new Algorithms();
		List<Sheet> sheets;

		List<Shape> test1 = new ArrayList<>();
		test1.add(new Shape(5, 40));
		test1.add(new Shape(39, 230));
		test1.add(new Shape(5, 90));
		test1.add(new Shape(23, 40));
		test1.add(new Shape(28, 82));
		test1.add(new Shape(62, 44));
		test1.add(new Shape(77, 4));
		test1.add(new Shape(9, 5));
		test1.add(new Shape(2, 5));
		test1.add(new Shape(20, 70));
		test1.add(new Shape(2, 10));
		test1.add(new Shape(2, 10));
		test1.add(new Shape(2, 10));
		test1.add(new Shape(2, 15));
		test1.add(new Shape(7, 16));
		test1.add(new Shape(2, 15));
		test1.add(new Shape(5, 15));
		test1.add(new Shape(5, 40));
		test1.add(new Shape(15, 20));
		test1.add(new Shape(32, 90));
		sheets = a.nextFit(test1);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test2 = new ArrayList<>();
		test2.add(new Shape(5, 40));
		test2.add(new Shape(39, 230));
		test2.add(new Shape(5, 90));
		test2.add(new Shape(23, 40));
		test2.add(new Shape(28, 82));
		test2.add(new Shape(62, 44));
		test2.add(new Shape(77, 4));
		test2.add(new Shape(9, 5));
		test2.add(new Shape(2, 5));
		test2.add(new Shape(20, 70));
		test2.add(new Shape(2, 10));
		test2.add(new Shape(2, 10));
		test2.add(new Shape(2, 10));
		test2.add(new Shape(2, 15));
		test2.add(new Shape(7, 16));
		test2.add(new Shape(2, 15));
		test2.add(new Shape(5, 15));
		test2.add(new Shape(5, 40));
		test2.add(new Shape(15, 20));
		test2.add(new Shape(33, 90));
		sheets = a.nextFit(test2);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test3 = new ArrayList<>();
		test3.add(new Shape(5, 40));
		test3.add(new Shape(39, 230));
		test3.add(new Shape(5, 90));
		test3.add(new Shape(23, 40));
		test3.add(new Shape(28, 82));
		test3.add(new Shape(62, 44));
		test3.add(new Shape(77, 4));
		test3.add(new Shape(9, 5));
		test3.add(new Shape(2, 5));
		test3.add(new Shape(20, 70));
		test3.add(new Shape(2, 10));
		test3.add(new Shape(2, 10));
		test3.add(new Shape(2, 10));
		test3.add(new Shape(2, 15));
		test3.add(new Shape(7, 16));
		test3.add(new Shape(2, 15));
		test3.add(new Shape(5, 15));
		test3.add(new Shape(5, 40));
		test3.add(new Shape(15, 20));
		test3.add(new Shape(32, 90));
		test3.add(new Shape(150, 84));
		sheets = a.nextFit(test3);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test4 = new ArrayList<>();
		test4.add(new Shape(5, 40));
		test4.add(new Shape(39, 230));
		test4.add(new Shape(5, 90));
		test4.add(new Shape(23, 40));
		test4.add(new Shape(28, 82));
		test4.add(new Shape(62, 44));
		test4.add(new Shape(77, 4));
		test4.add(new Shape(9, 5));
		test4.add(new Shape(2, 5));
		test4.add(new Shape(20, 70));
		test4.add(new Shape(2, 10));
		test4.add(new Shape(2, 10));
		test4.add(new Shape(2, 10));
		test4.add(new Shape(2, 15));
		test4.add(new Shape(7, 16));
		test4.add(new Shape(2, 15));
		test4.add(new Shape(5, 15));
		test4.add(new Shape(5, 40));
		test4.add(new Shape(15, 20));
		test4.add(new Shape(32, 90));
		test4.add(new Shape(150, 84));
		test4.add(new Shape(270, 60));
		test4.add(new Shape(120, 60));
		test4.add(new Shape(260, 46));
		sheets = a.nextFit(test4);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test5 = new ArrayList<>();
		test5.add(new Shape(5, 40));
		test5.add(new Shape(39, 230));
		test5.add(new Shape(5, 90));
		test5.add(new Shape(23, 40));
		test5.add(new Shape(28, 82));
		test5.add(new Shape(62, 44));
		test5.add(new Shape(77, 4));
		test5.add(new Shape(9, 5));
		test5.add(new Shape(2, 5));
		test5.add(new Shape(20, 70));
		test5.add(new Shape(2, 10));
		test5.add(new Shape(2, 10));
		test5.add(new Shape(2, 10));
		test5.add(new Shape(2, 15));
		test5.add(new Shape(7, 16));
		test5.add(new Shape(2, 15));
		test5.add(new Shape(5, 15));
		test5.add(new Shape(5, 40));
		test5.add(new Shape(15, 20));
		test5.add(new Shape(32, 90));
		test5.add(new Shape(150, 84));
		test5.add(new Shape(270, 60));
		test5.add(new Shape(120, 60));
		test5.add(new Shape(260, 47));
		sheets = a.nextFit(test5);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test6 = new ArrayList<>();
		test6.add(new Shape(5, 40));
		test6.add(new Shape(39, 230));
		test6.add(new Shape(5, 90));
		test6.add(new Shape(23, 40));
		test6.add(new Shape(28, 82));
		test6.add(new Shape(62, 44));
		test6.add(new Shape(77, 4));
		test6.add(new Shape(9, 5));
		test6.add(new Shape(2, 5));
		test6.add(new Shape(20, 70));
		test6.add(new Shape(2, 10));
		test6.add(new Shape(2, 10));
		test6.add(new Shape(2, 10));
		test6.add(new Shape(2, 15));
		test6.add(new Shape(7, 16));
		test6.add(new Shape(2, 15));
		test6.add(new Shape(5, 15));
		test6.add(new Shape(5, 40));
		test6.add(new Shape(15, 20));
		test6.add(new Shape(32, 90));
		test6.add(new Shape(150, 84));
		test6.add(new Shape(270, 60));
		test6.add(new Shape(120, 60));
		test6.add(new Shape(46, 250));
		sheets = a.nextFit(test6);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test7 = new ArrayList<>();
		test7.add(new Shape(250, 50));
		test7.add(new Shape(50, 100));
		test7.add(new Shape(100, 250));
		sheets = a.firstFit(test7);
		for (Sheet s : sheets) {
			System.out.println(s);
		}

		List<Shape> test8 = new ArrayList<>();
		test8.add(new Shape(250, 50));
		test8.add(new Shape(50, 100));
		test8.add(new Shape(100, 250));
		test8.add(new Shape(50, 50));
		test8.add(new Shape(250, 100));
		sheets = a.firstFit(test8);
		for (Sheet s : sheets) {
			System.out.println(s);
		}
	}
}
