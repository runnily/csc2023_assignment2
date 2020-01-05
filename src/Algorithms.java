
/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 * Modified by: Adanna
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

	public List<Sheet> nextFit(List<Shape> shapes) {
		if (shapes.isEmpty()) { // when our list is empty return an empty list.
			return new ArrayList<Sheet>();
		}
		int noOfShapes = 0;
		Sheet sheet = new Sheet();
		Shelf shelf = new Shelf();
		Shape s = shapes.get(0);
		shelf.place(s); // place shape in height
		noOfShapes++;
		int max_height = shelf.getHeight(); // set max height, max height could only ever be 250 here
		List<Sheet> usedSheets = new ArrayList<Sheet>();
		sheet.addShelf(shelf); // add shelf as we used a shelf
		usedSheets.add(sheet); // add used sheet as we used a sheet
		for (int i = 1; i < shapes.size(); i++) {
			s = shapes.get(i);
			int width = s.getWidth();
			int height = s.getHeight();
			/**
			 * These two logical if statement uses the analogy of fitting a object (book,
			 * shape etc) into a shelf if the shape does not fit rotate it the other way if
			 * it does not fit then make a new shelf.
			 * 
			 */
			if ((noOfShapes + 1 <= Sheet.SHAPE_LIMIT) && (width + shelf.getWidth() <= Sheet.SHEET_WIDTH)
					&& (height <= max_height)) {// ..is within limits
				shelf.place(s);
				noOfShapes++;
			} else if ((noOfShapes + 1 <= Sheet.SHAPE_LIMIT) && (width + shelf.getWidth() > Sheet.SHEET_WIDTH)
					&& (height + shelf.getWidth() <= Sheet.SHEET_WIDTH) && (width <= max_height)) {
				s.rotate();
				shelf.place(s);
				noOfShapes++;
			} else if ((noOfShapes + 1 <= Sheet.SHAPE_LIMIT) && (height > max_height) && (width <= max_height)
					&& (height + shelf.getWidth() <= Sheet.SHEET_WIDTH)) { // ... ditto
				s.rotate();
				shelf.place(s);
				noOfShapes++;

			} else { // ... hits the else statement when there is not enough space
				shelf = new Shelf(); // shelf is reassigned (points to a new shelf); Therefore other shelf is
										// forgotten
				shelf.place(s);
				noOfShapes++;
				max_height = shelf.getHeight(); // our new max height

				if (noOfShapes + 1 <= Sheet.SHAPE_LIMIT && (sheet.allShelvesHeight() + max_height <= Sheet.SHEET_HEIGHT
						|| s.getWidth() + sheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT)) {
					if (sheet.allShelvesHeight() + max_height > Sheet.SHEET_HEIGHT) {
						s.rotate();
					}
					sheet.addShelf(shelf);
				} else {
					sheet = new Sheet(); // point to a new sheet object
					noOfShapes = 1; // set to one
					sheet.addShelf(shelf);
					usedSheets.add(sheet);
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
		if (shapes.isEmpty()) {
			return new ArrayList<Sheet>();
		}

		/**
		 * declare a map type to associate sheet (key) with the amount of shapes inside
		 * (value)
		 */
		List<Sheet> usedSheets = new ArrayList<>();
		Sheet sheet = new Sheet(); // declare a new sheet
		Shelf shelf = new Shelf(); // declare a new shelf initially
		Shape s = shapes.get(0); // get the first value of shape
		int maxHeight = s.getHeight(); // our max height set
		shelf.place(s); // then place the shape in shelf
		sheet.addShelf(shelf); // add shelf into sheet
		usedSheets.add(sheet);
		/**
		 * Now loop through all the shapes starting from index 1 as shape 0 (first
		 * shape) has already been added
		 */
		for (int i = 1; i < shapes.size(); i++) {
			s = shapes.get(i); // get shapes
			int height = s.getHeight(); // save the height
			int width = s.getWidth(); // save the width

			/**
			 * lets begin by loop through each sheet within the map
			 */
			boolean notPlaced = true; // boolean variable denote a shape has not been place
			int nptr = 0;
			while (nptr < usedSheets.size() && notPlaced) {
				sheet = usedSheets.get(nptr); // point to first sheet initially then progress to other sheets.
				if (sheet.allShapes() >= 20) { // the added 1 is the shape were
					if (nptr + 1 < usedSheets.size()) {
						// if its less than continue to the other sheet
						nptr++;
						sheet = (usedSheets.get(nptr));
					} else {
						break; // bad practice but need to escape this loop; change later
					}
				}
				/**
				 * now loop through the shelves of the sheet, while checking they can fit
				 */
				int sptr = 0;
				List<Shelf> shelves = sheet.getShelves();
				while (sptr < shelves.size() && notPlaced) {
					shelf = shelves.get(sptr);
					maxHeight = shelf.getHeight();
					if (width + shelf.getWidth() <= Sheet.SHEET_WIDTH && height <= maxHeight) {
						shelf.place(s);
						notPlaced = false;
					} else if ((width + shelf.getWidth() > Sheet.SHEET_WIDTH) // try rotating it
							&& (height + shelf.getWidth() <= Sheet.SHEET_WIDTH) && (width <= maxHeight)) {
						s.rotate();
						shelf.place(s);
						notPlaced = false;
					} else if ((height > maxHeight) && (width <= maxHeight) // try rotating it
							&& (height + shelf.getWidth() <= Sheet.SHEET_WIDTH)) {
						s.rotate();
						shelf.place(s);
						notPlaced = false;

					} else {
						sptr++;
					}
				}
				/**
				 * Once finished the second loop that is going through this code below tries
				 * creating a shelf in a new remaining sheet.
				 */
				if (notPlaced) {
					if ((height + sheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT)
							|| (width + sheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT)) {
						if (height + sheet.allShelvesHeight() > Sheet.SHEET_HEIGHT) {
							s.rotate();
						}
						shelf = new Shelf();
						shelf.place(s);
						sheet.addShelf(shelf);
						notPlaced = false;
					}
				}
				nptr++;
			}
			/**
			 * Once finished from the first loop that is going through all the sheets and
			 * still cannot be placed. it would make a new sheet to place and shelf and
			 * place the shape.
			 */
			if (notPlaced) {
				sheet = new Sheet();
				shelf = new Shelf();
				shelf.place(s);
				sheet.addShelf(shelf);
				usedSheets.add(sheet);
			}
		}

		return usedSheets;
	}
}
