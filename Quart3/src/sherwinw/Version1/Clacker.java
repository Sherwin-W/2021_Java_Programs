package sherwinw.Version1;
import java.util.Random;

public class Clacker {
	private int currentRoll;
	private int []numberLine;
	private int diceMax;
	private int diceMin = 1;
	private String board = "";
	
	public Clacker() {
		this.numberLine = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
		this.diceMax = 6;
	}
	
	public Clacker(int[] numberLine, int diceMax) { 
		this.numberLine = numberLine;
		this.diceMax = diceMax;
	}
	
	public int[] rollDice() {
		int [] result = new int[2];
		Random rand = new Random();
		result[0] = rand.nextInt((this.diceMax - this.diceMin) + 1) + this.diceMin;
		result[1] = rand.nextInt((this.diceMax - this.diceMin) + 1) + this.diceMin;
		return result;
	}
	
	public boolean isGameOver() {
		boolean result = true;;

		for(int i = 0; i < this.numberLine.length; i++) {
			if(numberLine[i] != -1) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public void displayNumberLine() {
		String result = "";
		String barLine = "";
		
		for(int i = 0; i < this.numberLine.length; i++) {
			barLine += "--------";
			if(this.numberLine[i] != -1) {
				result += this.numberLine[i] + "\t";
			}
			else {
				result += " \t";
			}
		}
		result = barLine + "\n" + result + "\n" + barLine;
		System.out.println(result);
	}
	
	public void showReminder(int [] rollRand, int turnCount) {
		System.out.println("You rolled " + rollRand[0] + " and " + rollRand[1] 
						 + " !(Current roll:" + turnCount + ")");
	}
	
	public void markTotal(int [] rollRand) {
		int totalValue = rollRand[0] + rollRand[1];
		int index = this.getIntArrIndex(this.numberLine, totalValue);
		if(index != -1) {
			this.numberLine[index] = -1;
		}
	}
	
	public void markIndiv(int [] rollRand) {
		int indexOne = this.getIntArrIndex(this.numberLine, rollRand[0]);
		int indexTwo = this.getIntArrIndex(this.numberLine, rollRand[1]);
		if(indexOne != -1) {
			this.numberLine[indexOne] = -1;
		}
		if(indexTwo != -1) {
			this.numberLine[indexTwo] = -1;
		}
	}
	
	private int getIntArrIndex(int[] arr, int target) {
		int index = -1;
		
		for(int ix = 0; ix < arr.length; ix++) {
			if(target == arr[ix]) {
				index = ix;
				break;
			}
		}
		return index;
	}
	
	public void playGame() {
		EasyReader reader = new EasyReader();

		String startWord = "===============\n"
						 + "Game of Clacker\n"
						 + "===============\n"
						 + "Let's play: Press enter to Roll\n\n";
		String promptMsg = "Would you like to cover the total value or individual values? (Enter T or I)";
		
		
		this.board += "\nGame of Clacker\n" +
					  "---------------";
		System.out.print(startWord);
		displayNumberLine();
		String line = reader.readLine();

		while(!isGameOver()) {
			int[] rollRandom = this.rollDice();
			this.showReminder(rollRandom, this.currentRoll);
			this.currentRoll++;

			System.out.println(this.board);
			this.displayNumberLine();
			System.out.println(promptMsg);

			line = reader.readLine();
			if(line.equals("i")) {
				this.markIndiv(rollRandom);
			}
			if(line.equals("t")) {
				this.markTotal(rollRandom);
			}
			this.displayNumberLine();
		}
		System.out.println("YOU WON!\n" + "YOUR SCORE: " + this.currentRoll);
	}
}
