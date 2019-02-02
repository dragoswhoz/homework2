package testare_02_02_2019;

import java.util.Objects;

public class Triangle implements Shape {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		this(0,0,0);
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public double calcArea() {
		double p = calcPerimeter() / 2;
		double area =  Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
		return area;
	}
		

	@Override
	public double calcPerimeter() {
		return side1 + side2 + side3;
		
	}

	@Override //nu uita de hashcode, de fiecare data equals si hashcode se suprascriu impreuna
	public int hashCode() {
		return Objects.hash(side1, side2, side3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Triangle)) {
			return false;
		}
		Triangle other = (Triangle) obj;
		return side1 == other.side1
				&& side2 == other.side2
				&& side3 == other.side3;
	}
	
	
	

	
	
	
	

}
