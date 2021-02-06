package sherwinw;

public class Apartment {
	private String address;
	public char[] qualities;

	public Apartment (String address, char[] qual) {
		this.address = address;
		this.qualities = new char[30];

		for(int x = 0; x < qualities.length; x++) {
			this.qualities[x] = qual[x];
		}	
	}

	public String getAddress() {
		return this.address;
	}

	public char[] getQualities() {
		return this.qualities;
	}
	
}
