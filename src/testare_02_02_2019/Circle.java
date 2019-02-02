package testare_02_02_2019;

import java.util.Objects;

public class Circle implements Shape {
	public static final double PI = Math.PI;
	private double radius;
	
	public Circle() {
		this(0);
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	

	@Override
	public double calcArea() {
		return PI*radius*radius;
		
		
	}

	@Override
	public double calcPerimeter() {
		return 2*PI*radius;
	
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Circle)) {
			return false;
		}
		Circle other = (Circle) obj;
		return radius == other.radius;
	}


}
