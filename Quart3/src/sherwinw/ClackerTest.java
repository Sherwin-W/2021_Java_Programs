package sherwinw;

public class ClackerTest {
			
	public static void main(String []args) {
		String []nums = {"  1","  2","  3","  4","  5","  6","  7","  8","  9"," 10"," 11"," 12"};
		boolean []vis = {true,true,true,true,true,true,true,true,true,true,true,true};
		boolean []checker = {false,false,false,false,false,false,false,false,false,false,false,false};
		int numRoll = -1;
		String board = "";
		String message = "";
		String decision = "Would you like to cover the total value or individual values? (Enter T or I)";
		String separator = "  ----------------------------------";
		EasyReader reader = new EasyReader();
		
		Clacker game = new Clacker(nums, vis, checker, numRoll);
		
		while(game.compare() == false) {
			board = "";
			nums = game.setNumbers();
			for(int i = 0; i < nums.length; i++) {
				board += nums[i];
			}
			numRoll++;

			int a = game.rollDice();
			int b = game.rollDice();
			int sum = a + b;
			if(numRoll == 0) {
				message = "Let's play: Press enter to Roll";
			}
			else{
				message = "You rolled " + a + " and " + b + "!" + "(Current roll:" + numRoll + ")";
			}
			
			System.out.println("Game of Clacker" + '\n' + "---------------");
			System.out.println(message);
			System.out.println(separator);
			System.out.println(board);
			System.out.println(separator);
			System.out.println(decision);
			
			String line = reader.readLine();
			if(line.equals("i")) {
				vis = game.coverInd(a, b);
			}
			if(line.equals("t")) {
				vis = game.coverTotal(sum);
			}
					
		}
			System.out.println("YOU WON!" + '\n' + "YOUR SCORE: " + numRoll);
	}

}
