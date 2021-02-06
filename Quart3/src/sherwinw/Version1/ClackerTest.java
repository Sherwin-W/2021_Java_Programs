package sherwinw.Version1;

public class ClackerTest {

	public static void main(String[] args) {
		Clacker clack = new Clacker();
		clack.playGame();

		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		Clacker clack2 = new Clacker(arr, 8);
		clack2.playGame();
	}

}
