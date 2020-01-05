
/**
 *  @Purpose: The Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 * Modified by: Adanna
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

	public static final int MAX_SIZE_HEIGHT = 250;
	public static final int MAX_SIZE_WIDTH = 300;

	public static final int MAX_MIN = 1;

	/**
	 * This method will generate a list of shapes of random width and height
	 * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive. The
	 * random height is between 1 and MAX_SIZE_HEIGHT inclusive.
	 * 
	 * @param numberOfShapes: the number of shapes to generate
	 * @return a list of shapes of random sizes
	 */

	public List<Shape> generateShapeList(int numberOfShapes) {

		List<Shape> shapes = new ArrayList<Shape>();
		/*
		 * generate a random size of shape note: added +1 to max sizes to make them
		 * inclusive to the random number generated
		 */
		Random r = new Random();
		for (int i = 0; i < numberOfShapes; i++) {
			shapes.add(new Shape(r.nextInt(MAX_SIZE_WIDTH) + MAX_MIN, r.nextInt(MAX_SIZE_HEIGHT) + MAX_MIN));
		}
		/*
		 * THIS METHOD CURRENTLY RETURNS AN EMPTY LIST SO YOU WILL NEED TO ADD IN YOUR
		 * OWN CODE TO GENERATE A LIST OF SHAPES randomly
		 */
		return shapes;
	}

}