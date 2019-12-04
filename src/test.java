import java.util.List;

public class test {

	public static void main(String[] args) {
		/*
		 * Testing generate
		 */

		Generator gShapes = new Generator();
		List<Shape> shapes = gShapes.generateShapeList(5);
		Shelf shelf = new Shelf();
		for (Shape s : shapes) {
			System.out.println(s);
			shelf.place(s);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		System.out.println(shelf);

		System.out.println("");
		System.out.println("");
		System.out.println("");

		Sheet sheet = new Sheet();
		sheet.addShelf(shelf);
		System.out.println(sheet);

		System.out.println("");
		System.out.println("");
		System.out.println("");

		shelf = new Shelf();
		shapes = gShapes.generateShapeList(5);
		for (Shape s : shapes) {
			shelf.place(s);
		}

		sheet.addShelf(shelf);
		System.out.println(sheet);

		System.out.println("");
		System.out.println("");
		System.out.println("");

		Algorithms a = new Algorithms();
		List<Sheet> sheets = a.nextFit(shapes);
		for (Shape s : shapes) {
			System.out.println(s);
			shelf.place(s);
		}

		for (Sheet s : sheets) {
			System.out.println(s);
		}

	}

}
