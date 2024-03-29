package sherwinw;

public class ThreeNumbers {

	private double a;
	private double b;
	private double c;
	
	public ThreeNumbers(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;

	}
	
	public double getSmallest() {
		if (a < b && a < c) {
			return a;
		}
		
		if (b < a && b < c) {
			return b;
		}
		else {
			return c;
		}
	}
	
	public double getMiddle() {
		if ((a < b || a < c) && (a > c || a > b)) {
			return a;
		}

		if ((b < a || b < c) && (b > c || b > a)) {
			return b;
		}
		else {
			return c;
		}
	}
	
	public double getLargest() {
		if (a > b &&a > c) {
			return a;
		}
		
		if (b > a && b > c) {
			return b;
		}
		else {
			return c;
		}
	}
}
