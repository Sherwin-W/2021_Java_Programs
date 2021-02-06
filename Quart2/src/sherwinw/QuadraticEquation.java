package sherwinw;

public class QuadraticEquation {
	
	private double a;
	private double b;
	private double discriminant;

	public QuadraticEquation( double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.discriminant = (b * b) - (4 * a * c);
	}
	
	public boolean hasSolution() {
		if (this.discriminant < 0) {
			return false;
		}
		return true;
	}

	public String getSolution() {
		double[] result = new double[2];
		result[0] = (-b + this.discriminant)/ (2 * this.a);
		result[1] = (-b - this.discriminant)/ (2 * this.a);
		return result[0] + " " + result[1];
		
	}
//	public double getSolution1() {
//			return (-b + this.discriminant)/ (2 * a);
//	}
//
//	public double getSolution2() {
//			return (-b - this.discriminant)/ (2 * a);
//	}
}
