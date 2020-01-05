import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Purpose: The SortedTest class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of shapes is
 *           SORTED
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 * 
 *        Modified by: Adanna
 */

public class SortedTest {
	Algorithms a = new Algorithms();
	List<Shape> shapes;

	SortedTest(List<Shape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * 
	 * @param shapes
	 * @return number of sheets for unsorted shapes
	 */
	public int unsortedSheetsNF() {
		List<Sheet> sheets = a.nextFit(shapes);
		return sheets.size();
	}

	/**
	 * 
	 * @param shapes
	 * @return number of sheets for unsorted shapes
	 */
	public int unsortedSheetsFF() {
		List<Sheet> sheets = a.firstFit(shapes);
		return sheets.size();
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for next fit, first
	 *         index is sorted by increasing area and second index is sorted by
	 *         decreasing area.
	 */
	public int[] sortedAreaSheetsNF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by area
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getArea(), s2.getArea());
			}

		});
		List<Sheet> sheetsI = a.nextFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.nextFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for first fit, first
	 *         index is sorted by increasing area and second index is sorted by
	 *         decreasing area.
	 */
	public int[] sortedAreaSheetsFF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by area
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getArea(), s2.getArea());
			}

		});
		List<Sheet> sheetsI = a.firstFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.firstFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for next fit, first
	 *         index is sorted by increasing height and second index is sorted by
	 *         decreasing height.
	 */
	public int[] sortedPerimeterSheetsNF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by perimeter
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getPerimeter(), s2.getPerimeter());
			}

		});
		List<Sheet> sheetsI = a.nextFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.nextFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for first fit, first
	 *         index is sorted by increasing perimter and second index is sorted by
	 *         decreasing perimter.
	 */
	public int[] sortedPerimeterSheetsFF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by perimter
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getPerimeter(), s2.getPerimeter());
			}

		});
		List<Sheet> sheetsI = a.firstFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.firstFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for next fit, first
	 *         index is sorted by increasing width and second index is sorted by
	 *         decreasing width.
	 */
	public int[] sortedWidthSheetsNF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by width
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getWidth(), s2.getWidth());
			}

		});
		List<Sheet> sheetsI = a.nextFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.nextFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for first fit, first
	 *         index is sorted by increasing width and second index is sorted by
	 *         decreasing width.
	 */
	public int[] sortedWidthSheetsFF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by width
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getWidth(), s2.getWidth());
			}

		});
		List<Sheet> sheetsI = a.firstFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.firstFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for next fit, first
	 *         index is sorted by increasing width and second index is sorted by
	 *         decreasing width.
	 */
	public int[] sortedHeightSheetsNF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by height
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getHeight(), s2.getHeight());
			}

		});
		List<Sheet> sheetsI = a.nextFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.nextFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	/**
	 * 
	 * @param shapes
	 * @return returns an array of the sorted number of sheets for first fit, first
	 *         index is sorted by increasing width and second index is sorted by
	 *         decreasing width.
	 */
	public int[] sortedHeightSheetsFF() {
		Collections.sort(shapes, new Comparator<Shape>() {
			/**
			 * overrides the comparator and instead will sort by perimter
			 */
			@Override
			public int compare(Shape s1, Shape s2) {
				return Integer.compare(s1.getHeight(), s2.getHeight());
			}

		});
		List<Sheet> sheetsI = a.firstFit(shapes); // this gets the list of shapes we changed it order
		Collections.sort(shapes, Collections.reverseOrder()); // this sorts shape in reverses order
		List<Sheet> sheetsD = a.firstFit(shapes); // this gets the number of sheets in reverse order
		int sheets[] = { sheetsI.size(), sheetsD.size() }; // create an array here to store the value
		return sheets;
	}

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("**************** Sorted Test ****************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Generate a random shape list and then check the number of sheets used when
		 ** this shape list is passed un-sorted the list is sorted based on different
		 * criteria as set in the speciication document.
		 * 
		 * run several tests for different sizes of the "list of shapes"
		 */

		/*
		 * HINT: you might want to implements the comparTo method in the Shape class or
		 * implement the Comparator Interface to do the sorting
		 */

		Generator generateShapes = new Generator();
		List<Shape> shapes = generateShapes.generateShapeList(10000);
		SortedTest sort = new SortedTest(shapes);
		/**
		 * The first index would hold the the number of sheets used when the shape sort
		 * was ascending and the second index would hold the number of sheets used when
		 * the shapes was descending
		 */
		int[] sheetsF; // this would hold the values returned by the methods
		int[] sheetsN; // this would hold the values returned by the methods

		/**
		 * Below are print statements to print the table
		 */

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		System.out.printf("|%1$19s|%2$50s|%3$46s|\n", "", "Ascending", "Descending");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");

		System.out.printf("|%1$-19s|%2$-24s|%3$-25s|%4$-22s|%5$-23s|\n", "Sort Type", "NoOfSheets (nextFit)",
				"NoOfSheets (firstFit)", "NoOfSheets (nextFit)", "NoOfSheets (firstFit)");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		System.out.printf("|%1$-19s|%2$-24d|%3$-25d|\n", "Unsorted", sort.unsortedSheetsNF(), sort.unsortedSheetsFF());

		sheetsN = sort.sortedAreaSheetsNF();
		sheetsF = sort.sortedAreaSheetsFF();
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		System.out.printf("|%1$-19s|%2$-24d|%3$-25d|%4$-22d|%5$-23d|\n", "Sorted by Area", sheetsN[0], sheetsF[0],
				sheetsN[1], sheetsF[1]);

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		sheetsN = sort.sortedPerimeterSheetsNF();
		sheetsF = sort.sortedPerimeterSheetsFF();
		System.out.printf("|%1$-19s|%2$-24d|%3$-25d|%4$-22d|%5$-23d|\n", "Sorted by Perimeter", sheetsN[0], sheetsF[0],
				sheetsN[1], sheetsF[1]);

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		sheetsN = sort.sortedWidthSheetsNF();
		sheetsF = sort.sortedWidthSheetsFF();
		System.out.printf("|%1$-19s|%2$-24d|%3$-25d|%4$-22d|%5$-23d|\n", "Sorted by Width", sheetsN[0], sheetsF[0],
				sheetsN[1], sheetsF[1]);

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		sheetsN = sort.sortedHeightSheetsNF();
		sheetsF = sort.sortedHeightSheetsFF();
		System.out.printf("|%1$-19s|%2$-24d|%3$-25d|%4$-22d|%5$-23d|\n", "Sorted by Height", sheetsN[0], sheetsF[0],
				sheetsN[1], sheetsF[1]);
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
	}

}
