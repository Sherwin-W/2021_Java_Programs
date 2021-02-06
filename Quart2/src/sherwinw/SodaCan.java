package sherwinw;

public class SodaCan {
	
	private String name;
	private int ID;
	private int transaction;
	private int inventory;
	
	
	public SodaCan(String name, int ID, int transactions, int inventory) {
		this.name = name;
		this.ID = ID;
		this.transaction = transactions;
		this.inventory = inventory;
	}
	

	public void adjustInventory(int inventory) {
		this.inventory += inventory;
		this.transaction++;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getTransactions() {
		return transaction;
	}
	
	public int getInventory() {
		return inventory;
	}
}

