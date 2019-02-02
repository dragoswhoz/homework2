package testare_02_02_2019;

import java.util.Objects;

public class Square implements Shape {

	private int side;

	public Square(int side) {
		this.side = side;
	}

	public Square() {
		this(0);
	}

	@Override
	public double calcArea() {
		return side * side;
	}

	@Override
	public double calcPerimeter() {
		return side * 4;
	}

	//nu uita de hashcode, de fiecare data equals si hashcode se suprascriu impreuna
	public int hashCode() {
		return ((int) side) * 31; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Square)) {
			return false;
		}
		Square other = (Square) obj;
		return side == other.side;
	}

}
