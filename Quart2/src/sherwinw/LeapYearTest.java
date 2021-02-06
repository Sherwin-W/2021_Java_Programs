package sherwinw;

public class LeapYearTest {
	public static void main (String [] args) {
		
		EasyReader kboard = new EasyReader("Dates.dat");
		int a = kboard.readInt();
		int b = kboard.readInt();
		int c = kboard.readInt();
		int d = kboard.readInt();
		int e = kboard.readInt();
		
		LeapYear first = new LeapYear(a); 
		LeapYear second = new LeapYear(b); 
		LeapYear third = new LeapYear(c); 
		LeapYear fourth = new LeapYear(d); 
		LeapYear fifth = new LeapYear(e); 
		
		System.out.println(first.getResult());
		System.out.println(second.getResult());
		System.out.println(third.getResult());
		System.out.println(fourth.getResult());
		System.out.println(fifth.getResult());
		
		
	}
}
