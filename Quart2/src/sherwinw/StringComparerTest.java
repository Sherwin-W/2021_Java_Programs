package sherwinw;

public class StringComparerTest {
	
	public static void main (String [] args) {
		
		EasyReader kboard = new EasyReader();
		System.out.println("Enter 4 strings: ");
		String a = kboard.readWord();
		String b = kboard.readWord();
		String c = kboard.readWord();
		String d = kboard.readWord();
		
		StringComparer first = new StringComparer();
		first.addString(a);
		first.addString(b);
		first.addString(c);
		first.addString(d);
		
		System.out.println("The lexicographic minimum is " + first.getMinString());
		System.out.println("The lexicographic maximum is " + first.getMaxString());
		
		
			
	}
}
