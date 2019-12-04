
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

	public Shape rotate(Shape s) {
		int temp = s.getHeight();
		s.setHeight(s.getWidth());
		s.setWidth(temp);
		return s;
	}

	public List<Sheet> nextFit(List<Shape> shapes) {
		Sheet sheet = new Sheet();
		Shelf shelf = new Shelf();
		Shape s = shapes.get(0);
		shelf.place(s); // place shape in height
		int max_height = shelf.getHeight(); // set max heighT
		List<Sheet> usedSheets = new ArrayList<Sheet>();
		sheet.addShelf(shelf); // add shelf as we used a shelf
		usedSheets.add(sheet); // add used sheet as we used a sheet
		for (int i = 1; i < shapes.size(); i++) {
			/**
			 * As it next fit the total area of the shape is the max height and the width of
			 * the shape, this is because next fit does not go back therefore we don't want
			 * to consider shapes where it has space on top.
			 */
			s = shapes.get(i);
			/**
			 * These two logical if statement uses the analogy of fitting a object (book,
			 * shape etc) into a shelf if the shape does not fit rotate it the other way if
			 * it does not fit then make a new shelf.
			 */
			if (s.getWidth() + shelf.getWidth() <= Sheet.SHEET_WIDTH && s.getHeight() <= max_height) {
				shelf.place(s);
			} else if ((s.getWidth() + shelf.getWidth() > Sheet.SHEET_WIDTH)
					&& (s.getHeight() + shelf.getWidth() < Sheet.SHEET_WIDTH) && (s.getWidth() <= max_height)) {
				s = rotate(s);
				shelf.place(s);
			} else if ((s.getHeight() > max_height) && (s.getWidth() < max_height)
					&& (s.getHeight() + shelf.getWidth() <= Sheet.SHEET_WIDTH)) {
				s = rotate(s);
				shelf.place(s);
			} else {
				shelf = new Shelf(); // not enough space then new shelf; point to new shelf
				shelf.place(s);
				max_height = shelf.getHeight();
				if (sheet.allShelvesHeight() + shelf.getHeight() > Sheet.SHEET_HEIGHT) {
					sheet = new Sheet(); // point to a new sheet object
					sheet.addShelf(shelf);
					usedSheets.add(sheet);
				} else {
					sheet.addShelf(shelf);
				}
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
