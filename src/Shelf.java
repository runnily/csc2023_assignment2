
/**
 * @Purpose: The Shelf class represents a shelf with a list of shapes.
 * DO NOT MODIFY THE EXISTING METHODS, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by @author 
 */

import java.util.ArrayList;
import java.util.List;

public class Shelf {

	// The used width: the width of all the shapes placed in the shelf
	private int usedWidth;

	// Shelf height: Equals to the height of the first shape placed in the shelf
	private int shelfHeight;

	// Shelf area: The total area is equal to width of the sheet (as thats the max
	// width) * height
	private int area;

	// List of shapes stored in the shelf
	List<Shape> shapes = new ArrayList<Shape>();

	/**
	 * empty constructor
	 */
	public Shelf() {

	}

	/**
	 * @return Height of the shelf
	 */
	public int getHeight() {

		if (shapes.size() != 0) {
			// equals to the height of shape placed at the left
			this.shelfHeight = shapes.get(0).getHeight();
			return this.shelfHeight;
		} else
			return 0;
	}

	/**
	 * @return return area of sheet
	 */
	public int getArea() {
		area = getHeight() * Sheet.SHEET_WIDTH;
		return area;
	}

	/**
	 * This method is used to place a shape on a shelf
	 * 
	 * @param shape: a shape
	 */
	public void place(Shape shape) {

		// add shape width to the shelf width
		usedWidth += shape.getWidth();
		shapes.add(shape);
	}

	/**
	 * @return list of all shapes placed in the shelf
	 */
	public List<Shape> getShapes() {
		return shapes;
	}

	/**
	 * @return the used width of the shelf
	 */
	public int getWidth() {
		return usedWidth;
	}

	/**
	 * @return A string to the information about the shelf
	 */
	public String toString() {
		String output = (" -----------------Shelf--------------------\n ");
		output += String.format("|%1$-19s|%2$-20s|\n", "Variable", "Values");
		output += String.format("|%1$-20s|%2$-20s|\n", "Height", getHeight());
		output += String.format("|%1$-20s|%2$-20s|\n", "Width", getWidth());
		output += "-------------------------------------------\n";
		output += "=================Shelf Shapes==============\n";
		for (Shape s : shapes) {
			output += s;
		}
		return output;
	}

}
