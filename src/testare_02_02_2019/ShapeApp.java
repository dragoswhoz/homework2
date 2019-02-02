package testare_02_02_2019;

import java.util.*;

public class ShapeApp {

	public static void main(String[] args) {
		ShapeApp tool = new ShapeApp();

		tool.draw(new Circle(2));
		tool.draw(new Rectangle(4, 5));
		tool.draw(new Triangle(2, 3, 4));
		tool.draw(new Square(3));
		tool.draw(new Square(3));

		tool.shapesList.forEach(s -> {
			System.out.println(s.getClass().getSimpleName());
		});
	}

	private ArrayList<Shape> shapesList = new ArrayList<>();

	public void draw(Shape shape) {
		if (shapesList.contains(shape)) {
			System.out.println("The shape allready exist");
		} else {
			shapesList.add(shape);
		}

	}

	public double calculateTotalAreaOfShapes() {
		double totalArea = 0;
		for (Shape element : shapesList) {
			totalArea += element.calcArea();
		}
		return totalArea;

	}

	public double calculatePerimeter() {
		double totalPerimeter = 0;
		for (Shape element : shapesList) {
			totalPerimeter += element.calcPerimeter();
		}
		return totalPerimeter;

	}

}
