package sherwinw;

public class SodaCanTest {

	public static void main(String[] args) {
		EasyReader kboard = new EasyReader("Soda.dat");
		int id = 1;
		String name;
		int inventory;
		int transaction = 0;
		
		name = kboard.readWord();
		id = kboard.readInt();
		inventory = kboard.readInt();
		SodaCan coke =  new SodaCan(name, id, transaction, inventory);
		
		name = kboard.readWord();
		id = kboard.readInt();
		inventory = kboard.readInt();
		SodaCan pepsi =  new SodaCan(name, id, transaction, inventory);
		
		name = kboard.readWord();
		id = kboard.readInt();
		inventory = kboard.readInt();
		SodaCan diet =  new SodaCan(name, id, transaction, inventory);
		
		name = kboard.readWord();
		id = kboard.readInt();
		inventory = kboard.readInt();
		SodaCan sprite =  new SodaCan(name, id, transaction, inventory);
		
		id = kboard.readInt();
		while (id!= 0) {
			inventory = kboard.readInt();
			
			if (id == 1) {
				coke.adjustInventory(inventory);
			}
			else if (id == 2) {
				pepsi.adjustInventory(inventory);
			}
			else if (id == 3) {
				diet.adjustInventory(inventory);
			}
			else if (id == 4) {
				sprite.adjustInventory(inventory);
				
			
			}
			id = kboard.readInt();
		}
		
		System.out.println("Soft Drink" + EasyFormat.format("ID", 5) + EasyFormat.format("Transaction", 14) + EasyFormat.format("Inventory", 12));
		System.out.println("----------" + EasyFormat.format("---", 5) + EasyFormat.format("-----------", 14) + EasyFormat.format("---------", 12));
		System.out.println(coke.getName() + EasyFormat.format(coke.getID(), 5) + EasyFormat.format(coke.getTransactions(), 10) + EasyFormat.format(coke.getInventory(), 15));
		System.out.println(pepsi.getName() + EasyFormat.format(pepsi.getID(), 5) + EasyFormat.format(pepsi.getTransactions(), 10) + EasyFormat.format(pepsi.getInventory(), 15));
		System.out.println(diet.getName() + EasyFormat.format(diet.getID(), 5) + EasyFormat.format(diet.getTransactions(), 10) + EasyFormat.format(diet.getInventory(), 15));
		System.out.println(sprite.getName() + EasyFormat.format(sprite.getID(), 8) + EasyFormat.format(sprite.getTransactions(), 10) + EasyFormat.format(sprite.getInventory(), 15));
		System.out.println(EasyFormat.format("-------", 39));
		System.out.println("Total Inventory" + EasyFormat.format(coke.getInventory() + pepsi.getInventory() + diet.getInventory() + sprite.getInventory(), 24));

	}

}
