import java.util.List;

/**
 * @Purpose: The PerformanceTest class is used to compare the implemented
 *           algorithms in term of time and the number of sheets used
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 * 
 *        Modified by: Adanna
 */

public class PerformanceTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*********** Performance analysis **************");
		System.out.println("***********************************************");

		System.out.println();
		System.out.println("*********** Average Time and Average sheets **************");
		/*
		 * You must complete the Generator class in order to generate a random test
		 * values. You must complete the Algorithms class in order to call the two
		 * algorithms.
		 * 
		 * You can use any additional method you created in this class
		 */

		/**
		 * Remember: You need to calculate the time and number of sheets used for each
		 * run of each algorithm.
		 * 
		 * You are expected to run several tests (e.g. noOfTests=5) of your programs
		 * for, 10000, 20000, 30000, 40000, 50000 shapes (noOfShapes=10000,
		 * increment=10000) so that one can see how the algorithms perform for large
		 * datasets.
		 * 
		 * You are expected to run the same test a number of times to ensure accurate
		 * result (noOfRep=4). In this case, you need to calculate the average time and
		 * sheets needed for each run
		 **/

		//
		Generator generateShapes = new Generator();
		Algorithms a = new Algorithms();
		// total number of tests - you need to CHANGE this value
		int noOfTests = 5;

		// number of repetitions for each test - you need to CHANGE this value
		int noOfRep = 5;

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 10000;

		// the increment in the number of shapes - you need to CHANGE this value
		int increment = 10000;

		System.out.printf("noOfTest: %d\n", noOfTests);

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");
		System.out.printf("|%1$-19s|%2$-20s|%3$-19s|%4$-20s|%5$-19s|\n", "noOfShapes", "Average sheets (nextFit)",
				"Average sheets (firstFit)", "Average Time (nextFit)", "Average Time (firstFit)");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");

		for (int i = noOfShapes; i <= 50000; i += increment) {
			/**
			 * These variables are to initialise once the algorithm starts
			 */
			double averageFirstSheets = 0;
			long averageFirstTime = 0;
			double averageNextSheets = 0;
			long averageNextTime = 0;
			/**
			 * For each number of shapes it will perform 5 repetition for each number i
			 */
			for (int p = 0; p < noOfRep; p++) {
				/**
				 * Calculates the number of sheets and time for first fit
				 */
				List<Shape> shapes = generateShapes.generateShapeList(i);
				long startTime = System.nanoTime();
				List<Sheet> sheets = a.firstFit(shapes);
				long eclaspedTime = System.nanoTime() - startTime;
				averageFirstSheets += sheets.size();
				averageFirstTime += eclaspedTime;

				/*
				 * Calculates the number of sheets and time for next fit.
				 */
				startTime = System.nanoTime();
				sheets = a.nextFit(shapes);
				eclaspedTime = System.nanoTime() - startTime;
				averageNextSheets += sheets.size();
				averageNextTime += eclaspedTime;
			}
			averageFirstSheets = averageFirstSheets / noOfRep;
			averageFirstTime = averageFirstTime / noOfRep;

			averageNextSheets = averageNextSheets / noOfRep;
			averageNextTime = averageNextTime / noOfRep;

			System.out.printf("|%1$-19d|%2$-24.2f|%3$-25.2f|%4$-22d|%5$-23d|\n", i, averageNextSheets,
					averageFirstSheets, averageNextTime, averageFirstTime);
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------");

		}

	}
}
