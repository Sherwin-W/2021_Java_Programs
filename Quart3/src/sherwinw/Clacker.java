package sherwinw;

import java.util.Arrays;
import java.util.Random;

public class Clacker {

	private int check = 12;
	private int currentRoll;
	private boolean [] checker;
	private boolean[] visible = new boolean [check];
	private String [] numberLine = new String [check];

	public Clacker(String[] num, boolean[] vis, boolean [] checker, int currentRoll) {
		this.checker = checker;
		this.currentRoll = currentRoll;
		
		for(int x = 0; x < check; x++) {
			this.numberLine[x] = num[x];
		}
		
		for(int x = 0; x < check; x++) {
			this.visible[x] = vis[x];
			
		}
	}
	
	public int rollDice() {
		int max = 6;
		int min = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	public String[] setNumbers() {
		for(int x = 0; x < check; x++) {
			if(visible[x] == false) {
				numberLine[x] = "   ";
			}
		}
		return numberLine;
	}
	public boolean[] coverInd(int a, int b) {
		visible[a - 1] = false;
		visible[b - 1] = false;
		return visible;
	}
	public boolean[] coverTotal(int sum) {
		visible[sum - 1] = false;
		return visible;
	}
	public boolean compare() {
		if(Arrays.equals(visible, checker)) {
			return true;
		}
		return false;
	}
}
