package sherwinw;

public class ApartmentTest {

	public static void main(String[] args) {
		EasyReader custReader = new EasyReader("Cust.dat");
		String custInfo = custReader.readLine();
		String custQualities = custInfo.substring(0,30);
		String name = custInfo.substring(30);
		char arrayCust [] = custQualities.toCharArray();
		
		Person Customer1 = new Person(name, arrayCust);
	
		EasyReader aptReader = new EasyReader("Apt.dat");
		String listInfo = "";
	
		String placeholder = aptReader.readLine();
		int numApt = Integer.parseInt(placeholder);

		for(int k = 0; k < numApt; k++) {
			String aptInfo = aptReader.readLine();
			String aptQualities = aptInfo.substring(0,30);
			String address = aptInfo.substring(30);
			char arrayApt [] = aptQualities.toCharArray();
			
			Apartment Apartment1 = new Apartment(address, arrayApt);
			int matches = Customer1.getMatches(arrayCust, arrayApt);
			String response = Customer1.getResponse(matches);

			listInfo += Apartment1.getAddress();
			listInfo += EasyFormat.format(matches, 20 + (19 - address.length()));
			listInfo += EasyFormat.format(response, 15);
			listInfo += '\n';
		}
		
		System.out.println("For: " + Customer1.getName() + '\n' );
		System.out.println(EasyFormat.format("Address", 13) + EasyFormat.format("Number of Matches", 26) + 
						   EasyFormat.format("% Response", 14));
		System.out.println(EasyFormat.format("-------------------", 19) + EasyFormat.format("-----------------", 20) + 
						   EasyFormat.format("------------", 15)); 
		System.out.println(listInfo);
	
	}
}
