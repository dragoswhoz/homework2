package testare_02_02_2019;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShapeAppTest {
	
	private ShapeApp tool = new ShapeApp();
	
	@Before
	public void setUp() {
		tool.draw(new Circle(2));
		tool.draw(new Rectangle(4, 5));
		tool.draw(new Triangle(2, 3, 4));
		tool.draw(new Square(3));
		tool.draw(new Square(3));
		
	}

	@Test
	public void testCalculateTotalAreaOfShapes() {
		double result = tool.calculateTotalAreaOfShapes();
		assertEquals(44.47,result, 0.01);
	}
	
	@Test
	public void testCalculatePerimeter() {
		double result = tool.calculatePerimeter();
		assertEquals(51.57,result, 0.01);
	}
	
}
