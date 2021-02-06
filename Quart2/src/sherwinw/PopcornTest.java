package sherwinw;

public class PopcornTest {

	public static void main(String[] args) {
		EasyReader kboard = new EasyReader("Popcorn.dat");
		int farms;
		String name;
		String letters;
		double acres = 0;
		double jars = 0;
		String bars = "";
		
		farms = kboard.readInt();
		
		System.out.println(EasyFormat.format("Popcorn Co-Op", 39));
		System.out.println(EasyFormat.format("Production in", 39));
		System.out.print(EasyFormat.format("Farm Name", 9));
		System.out.println(EasyFormat.format("Thousands of", 29));
		System.out.println(EasyFormat.format("Pint Jars per Acre", 44));
		System.out.println(EasyFormat.format("   1   2   3   4   5   6", 50));
		System.out.println(EasyFormat.format("   |   |   |   |   |   |", 50));
		System.out.print(EasyFormat.format("---|---|---|---|---|---|", 50));
		
		for(int i = 0; i < farms; i++) {
			name = "";
			letters = Character.toString(kboard.readChar());
			
			do {
				name = name + letters;
				letters = Character.toString(kboard.readChar());
			}while(!letters.equals("*"));
			
			acres = kboard.readDouble();
			jars = kboard.readDouble();
			char placeholder = kboard.readChar();
			Popcorn f = new Popcorn(name, acres, jars);
			
			for (int j = 0; j<f.calculate(); j++) {
				 bars += "*";
				 if(j == 18) {
					 bars += "#";
				 }
			}
			if (f.calculate() < 19) {
				for(int k = 0; k < (19-f.calculate()); k++) {
					bars+= " ";
				}
				bars += "|";
			}
			System.out.print(EasyFormat.format(f.getName(), 28, 'L', 0) + bars);
			bars = "";
		}
		
		
	}	
}
