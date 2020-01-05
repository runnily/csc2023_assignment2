/**
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 *           SIGNITURE OF EXISTING METHODS, You may add additional methods if
 *           you wish
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author Modified by: Adanna
 * 
 **/

public class Shape implements Comparable<Shape> {

	private int sWidth; // width of the shape
	private int sHeight; // height of the shape
	private int sArea; // area of shape
	private int sPerimeter; // perimeter of shape

	/**
	 * A Shape constructor to set the width and height of a shape.
	 * 
	 * @param width  of a shape
	 * @param height of a shape
	 **/
	public Shape(int width, int height) {

		// Shape width and height should not be greater than the sheet width and height
		if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
			throw new IllegalArgumentException("Shape width or height is not valid");
		}

		this.sWidth = width;
		this.sHeight = height;
		this.sArea = sWidth * sHeight;
		this.sPerimeter = (sWidth * 2) + (sHeight * 2);
	}

	/**
	 * @return height of a shape
	 **/
	public int getHeight() {
		return sHeight;
	}

	/**
	 * @return width of a shape
	 */
	public int getWidth() {
		return sWidth;
	}

	/**
	 * @return area of a shape
	 */
	public int getArea() {
		return sArea;
	}

	/**
	 * @return Perminter of a shape
	 */
	public int getPerimeter() {
		return sPerimeter;
	}

	@Override
	public int compareTo(Shape o) {
		return Integer.compare(sArea, o.sArea);
	}

	/**
	 * This would rotate the shape
	 */
	public void rotate() {
		int temp = getWidth();
		sWidth = getHeight();
		sHeight = temp;
	}

	public String toString() {
		String output = String.format("|%1$-19s|\n", String.format("Shape(%d, %d)", sWidth, sHeight));
		output += "---------------------\n";
		return output;
	}
}
