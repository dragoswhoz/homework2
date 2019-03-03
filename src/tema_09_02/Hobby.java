package tema_09_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hobby {
	private String hobbyName;
	private int frequency;
	private List<Address> hobbyAddresses = new ArrayList<>();

	public Hobby(String hobbyName, int frequency) {
		this.hobbyName = hobbyName;
		this.frequency = frequency;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public List<Address> getHobbyAddresses() {
		return hobbyAddresses;
	}

	public void setHobbyAddresses(List<Address> hobbyAddresses) {
		this.hobbyAddresses = hobbyAddresses;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "\t" + "- " + hobbyName;
	}

	public void addAddress(Address address) {
		if (!getHobbyAddresses().contains(address)) {
			getHobbyAddresses().add(address);
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(hobbyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Hobby)) {
			return false;
		}
		Hobby other = (Hobby) obj;
		return hobbyName.equalsIgnoreCase(other.hobbyName);
	}

}
