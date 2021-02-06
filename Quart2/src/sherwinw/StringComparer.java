package sherwinw;

public class StringComparer {

	private String max;
	private String min;
	
	public StringComparer() {
		max = null;
		min = null;
	}
	
	public void addString(String a) {
		if (max == null || max.compareTo(a)<0) 
			max = a;
		
		if (min == null || min.compareTo(a)>0) 
			min = a;
		
	}
	
	public String getMaxString() {
		return max;
	}
	public String getMinString() {
		return min;
	}
	
}
