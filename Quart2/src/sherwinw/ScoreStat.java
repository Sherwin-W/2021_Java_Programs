package sherwinw;

public class ScoreStat {
	
	private double totalScore;
	private double sumOfSquare;
	private int min;
	private int max;
	private int numOfScores;
	private int A;
	private int B;
	private int C;
	private int D;
	private int F;
	
	public ScoreStat() {
		this.totalScore = 0; 
		this.sumOfSquare = 0;
		this.numOfScores = 0;
		this.max = Integer.MIN_VALUE;
		this.min = Integer.MAX_VALUE;
		this.A = 0;
		this.B = 0;
		this.C = 0;
		this.D = 0;
		this.F = 0;
	}
	
	public ScoreStat(double totalScore, double sumOfSquare, int numOfScores, 
					 int max, int min, int A, int B, int C, int D, int F) {
		this.totalScore = totalScore; 
		this.sumOfSquare = sumOfSquare;
		this.numOfScores = numOfScores;
		this.max = max;
		this.min = min;
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.F = F;
	}
	
	public void addScore(int score) {
		this.numOfScores++;
		this.totalScore += score;
		this.sumOfSquare += score * score;
		
		if (score < this.min) {
			this.min = score;
		}
		
		if (score > this.max) {
			this.max = score;
		}
		
		if (score <= 100 && score >= 90) {
			this.A++;
		}
		else if (score < 90 && score >= 80) {
			this.B++;
		}
		else if (score < 80 && score >= 70) {
			this.C++;
		}
		else if (score <70 && score >= 60) {
			this.D++;
		}
		else {
			this.F++;
		}
	}
		
	public double getTotalScore() {
		return this.totalScore;
	}
	
	public double getSquare() {
		return this.sumOfSquare;
	}
	
	public int getNumTests() {
		return this.numOfScores;
	}
	
	public int getMax() {
		return this.max;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public double getAverageScore() {
		double average = (totalScore * 1.0)/numOfScores;
		return average;
	}
	
	public double calculateSD() {
		double standardDev = Math.sqrt(
			(sumOfSquare - (totalScore * totalScore)/numOfScores)/(numOfScores -1));
		return standardDev;
		
	}
	
	public int getA() {
		return this.A;
	}
	

	public int getB() {
		return this.B;
	}
	

	public int getC() {
		return this.C;
	}
	

	public int getD() {
		return this.D;
	}
	

	public int getF() {
		return this.F;
	}
	
	public String getBar(int letter) {
		String barChart = "";
		for (int j = 0; j < letter; j++) {
			if (j == 9 || j == 19 || j == 29 || j == 39) {
				barChart += "|";
			}
			else{
				barChart += "*";
			}
		}
		
		if (letter > 30) {
			for (int k = 0; k < (10 - (letter % 30))-1; k++) {
				barChart += " ";
			}
			barChart += "|";
		}
		else if (letter > 20) {
			for (int l = 0; l < (10 - (letter % 20))-1; l++) {
				barChart += " ";
			}
			barChart += "|         |";
		}
		else if (letter > 10) {
			for (int l = 0; l < (10 - (letter % 10))-1; l++) {
				barChart += " ";
			}
			barChart += "|         |         |";
		}
		return barChart;
	}
	
	public void reset() {
		this.totalScore = 0; 
		this.sumOfSquare = 0;
		this.numOfScores = 0;
		this.max = 0;
		this.min = 0;
	}
	
	public String DataSet() {
		String result = "";
		result += "\nThe number of scores: " + this.numOfScores;
		result += "\nThe number of average score: " + String.format("%.2f", getAverageScore());
		result += "\nThe maximum score: " + this.max;
		result += "\nThe minimum score: " + this.min;
		result += "\nThe standard deviation: " + String.format("%.2f", calculateSD());		
		return result;
	}
	
	public String Chart() {
		String chart = "";
		chart += "\n\nBar Chart";
		chart += "\n" + EasyFormat.format("10", 13) + EasyFormat.format("20", 10) +
				 EasyFormat.format("30", 10) + EasyFormat.format("40", 10);
		chart += "\n" + EasyFormat.format("|", 13) + EasyFormat.format("|", 10) +
				 EasyFormat.format("|", 10) + EasyFormat.format("|", 10);
		
		chart += "\nA: " + getBar(this.A);
		chart += "\nB: " + getBar(this.B);
		chart += "\nC: " + getBar(this.C);
		chart += "\nD: " + getBar(this.D);
		chart += "\nF: " + getBar(this.F);
		
		chart += "\n" + EasyFormat.format("|", 13) + EasyFormat.format("|", 10) +
				 EasyFormat.format("|", 10) + EasyFormat.format("|", 10);
		chart += "\n" + EasyFormat.format("10", 13) + EasyFormat.format("20", 10) +
				 EasyFormat.format("30", 10) + EasyFormat.format("40", 10);
		return chart;
	}

}
