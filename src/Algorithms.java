
/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests(shapes to be
	 *        cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two shapes
	 *         {(w=200,h=200),(w=50,h=100)}, then the returned list of sheets should
	 *         show us all the information needed (e.g. that one sheet is used, this
	 *         sheet has one shelf and this shelf has two shapes in it). In the test
	 *         program, you can use the returned list to retrieve the total number
	 *         of sheets used.
	 **/

	public void rotate(Shape s) {
		int temp = s.getHeight();
		s.setHeight(s.getWidth());
		s.setWidth(temp);
	}

	public List<Sheet> nextFit(List<Shape> shapes) {
		// Accessible to all statements; if need reassign new to point to new sheet
		Sheet sheet = new Sheet();
		// Accessible to all statement; if need reassign to point to new
		Shelf shelf = new Shelf();
		/*
		 * no need to loop through variables
		 */
		Shape s = shapes.get(0);
		// int totalWidth = s.getWidth();
		int totalArea = s.getArea();

		shelf.place(s); // place shape in height

		int max_width = Sheet.SHEET_WIDTH;
		int max_height = shelf.getHeight(); // set max height
		int max_area = shelf.getArea(); // set area

		/*
		 * Start with an empty list of sheets (remember each sheet has a width of 300
		 * and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();

		/*
		 * Add in your own code so that the method will place all the shapes according
		 * to NextFit under ALL the assumptions mentioned in the specification
		 */
		sheet.addShelf(shelf); // add shelf as we used a shelf
		usedSheets.add(sheet); // add used sheet as we used a sheet

		for (int i = 1; i < shapes.size(); i++) {
			/**
			 * As it next fit the total area of the shape is the max height and the width of
			 * the shape, this is because next fit does not go back therefore we don't want
			 * to consider shapes where it has space on top.
			 */
			s = shapes.get(i);
			int area = (s.getHeight() > max_height) ? s.getArea() : s.getWidth() * max_height;
			if (totalArea + area > max_area) { // added shape exceeds the max area
				shelf = new Shelf(); // point to a new shelf (create new shelf)
				shelf.place(s); // place s in shelf
				totalArea = 0; // reset total 0
				totalArea += s.getWidth() * max_height; // add total area
				max_height = shelf.getHeight(); // set height
				max_area = shelf.getArea(); // set area
				if (sheet.allShelvesHeight() + shelf.getHeight() > Sheet.SHEET_HEIGHT) { // new sheet need
					sheet = new Sheet(); // point to a new shelf (create new shelf)
					sheet.addShelf(shelf);
					usedSheets.add(sheet);
				} else {
					sheet.addShelf(shelf); // then add shelf
				}

			} else if (shelf.getWidth() + s.getWidth() > max_width || s.getHeight() > max_height) {
				rotate(s);
				shelf.place(s);
				totalArea += area;
			} else {
				shelf.place(s);
				totalArea += area;
			}

		}

		return usedSheets;

	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests (shapes to be
	 *        cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two shapes
	 *         {(w=200,h=200),(w=50,h=100)}, then the returned list of sheets should
	 *         show us all the information needed (e.g. that one sheet is used, this
	 *         sheet has one shelf and this shelf has two shapes in it). In the test
	 *         program, you can use the returned list to retrieve the total number
	 *         of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width of 300
		 * and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();

		/*
		 * Add in your own code so that the method will place all the shapes according
		 * to FirstFit under the assumptions mentioned in the spec
		 */

		return usedSheets;
	}

}
