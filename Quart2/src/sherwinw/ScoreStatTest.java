package sherwinw;

public class ScoreStatTest {

	public static void main(String []args) {
		
		String score;
				
		EasyReader grades = new EasyReader("Scores.dat");
		
		System.out.println("Summary of test score data\n\n");
		
		int horizontal = 20;
		
		ScoreStat practice = new ScoreStat();
				
		score = grades.readWord();
		
		while(!score.equals("-1")){
			
			for(int i = 0; i < horizontal; i++) {
				if (i != horizontal-1) {
					practice.addScore(Integer.parseInt(score));
					System.out.print(score + " ");
				}
				else {
					practice.addScore(Integer.parseInt(score));
					System.out.print(score + "\n");
				}
				score = grades.readWord();
				if (score.equals("-1")) {
					i = horizontal+1;;
				}
			}
			
		}
		
		double sumOfScores = practice.getTotalScore();
		double sumScore = practice.getSquare();
		int totalScoreCount = practice.getNumTests();
		int maxScore = practice.getMax();
		int minScore = practice.getMin();
		int A = practice.getA();
		int B = practice.getB();
		int C = practice.getC();
		int D = practice.getD();
		int F = practice.getF();
		
		ScoreStat SetOne = new ScoreStat(sumOfScores, sumScore, totalScoreCount, maxScore, minScore, A, B, C, D, F);
		
		System.out.println(SetOne.DataSet());
		System.out.println(SetOne.Chart());
	}
}
