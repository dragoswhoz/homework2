package testare_02_02_2019;

import java.util.Objects;

public class Rectangle implements Shape {
	
	private double l;
	private double L;
	
	public Rectangle(double lungime, double latime) {
		l = latime;
		L = lungime;
	}
	
	public Rectangle() {
		this(0,0);
	}

	@Override
	public double calcArea() {
		return l*L;
	}

	@Override
	public double calcPerimeter() {
		return (2*L+2*l);
	}

	//nu uita de hashcode, de fiecare data equals si hashcode se suprascriu impreuna
	public int hashCode() {
		return ((int)(l*L)) * 31;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rectangle)) {
			return false;
		}
		Rectangle other = (Rectangle) obj;
		return L == other.L
				&& l == other.l;
	}

}
