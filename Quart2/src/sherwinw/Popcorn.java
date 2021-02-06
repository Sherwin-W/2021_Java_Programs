package sherwinw;

public class Popcorn {

	private String name;
	private double acres;
	private double jars;
	
	public Popcorn (String name, double acres, double jars) {
		this.name = name;
		this.acres = acres;
		this.jars = jars;
	}
	
	public int calculate() {
		double JPA = this.jars / this.acres;
		int bars = (int)(JPA/250.0);
		return bars;
		
	}
	
	public String getName() {
		return name;
	}
	
	
}
