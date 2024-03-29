package sherwinw;

public class QuadraticEquationTest {
	
	public static void main(String [] args) {
		
		EasyReader kboard = new EasyReader();
		
		System.out.println("Enter the Coefficients of a quadratic: ");
		double a = kboard.readDouble();
		double b = kboard.readDouble();
		double c = kboard.readDouble();
		
		QuadraticEquation Equation1 = new QuadraticEquation(a,b,c);
		
		System.out.println("Equation:" + a + "x^2" + " + " + b + "x + " + c);
		
		if (Equation1.hasSolution() == true) {
		System.out.println("Roots: " + Equation1.getSolution());
		}
		else
			System.out.println("no real roots");
		
		
	}

}
