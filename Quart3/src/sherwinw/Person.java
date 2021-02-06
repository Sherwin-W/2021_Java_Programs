package sherwinw;

public class Person {
	private String name;
	private char[] preferences;
	private int count;
	private int check = 30;

	public Person(String name, char[] pref) {
		this.name = name;
		this.count = 0;
		this.preferences = new char[check];
	
		for(int x = 0; x < preferences.length; x++) {
			this.preferences[x] = pref[x];
		}
	}

	public int getMatches(char[] qual, char[] pref) {
		count = 0;
		for (int i = 0; i < check; i++) {
			char a = qual [i];
			char c = pref [i];

			if (a == c) {
				this.count ++;
			}
		}
		return this.count;
	}
	
	public String getResponse(int count) {
		if (count * 1.0 / check >= 0.8) {
			return "Possible";
		}
		
		return "Not Possible";
	}
	
	public String getName() {
		return this.name;
	}
	
	public char[] getPreferences() {
		return this.preferences;
	}
}
