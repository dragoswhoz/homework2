package tema_09_02;

import java.util.Objects;

public class Address {
	private String city;
	private String streetName;
	private String streetNo;
	
	public Address(String city, String streetName, String streetNo) {
		this.city = city;
		this.streetName = streetName;
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}


	public String getStreetName() {
		return streetName;
	}


	public String getStreetNo() {
		return streetNo;
	}

	@Override
	public String toString() {
		return "\t\t city=" + city + ", streetName=" + streetName + ", streetNo=" + streetNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, streetName, streetNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return city.equalsIgnoreCase(other.city) && streetName.equalsIgnoreCase(other.streetName)
				&& streetNo.equalsIgnoreCase(other.streetNo);
	}


}
