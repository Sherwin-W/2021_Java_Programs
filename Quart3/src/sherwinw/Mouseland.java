package sherwinw;

import java.util.Random;

public class Mouseland {
	private int[][] island;
	private int PERCENT_BRIDGES;
	private int rowL;
	private int columnL;
	private int turns;
	private int position = 0;
	
	public Mouseland(int row, int column, int percent, int turns) {
		this.position = 0;
		this.island = new int[row][column]; 
		this.PERCENT_BRIDGES = percent;
		this.rowL = this.island.length;
		this.columnL = this.island[0].length;
		this.turns = turns;
		//turns cannot be more than 99;
	}

	public Mouseland() {
		this.island = new int[10][15]; 
		this.PERCENT_BRIDGES = 30;
		this.rowL = this.island.length;
		this.columnL = this.island[0].length;
		this.turns = 50;
		
	}

	public void initIsland(){
		for(int i = 0; i < this.rowL; i++) {
			for(int x = 0; x < this.columnL; x++) {
				island[i][x] = -2;
			}
		}
	}

	public int rollRandom(int max, int min) {
		Random rand = new Random();
		int result = rand.nextInt((max - min) + 1) + min;
		return result;
	}

	public int decide(int value) {
		if(value > this.PERCENT_BRIDGES) {
			return -1;
		}
		return -3;
	}

	public void setBorders(int[][] island) {
		for(int i = 0; i < this.columnL; i++) {
			int value = rollRandom(100, 0);
			int value2 = rollRandom(100, 0);
			island[0][i] = decide(value);
			island[rowL-1][i] = decide(value2);
		}
		for(int x = 0; x < this.rowL; x++) {
			int value3 = rollRandom(100, 0);
			int value4 = rollRandom(100, 0);
			if(x != 0 || x != this.columnL) {
				island[x][0] = decide(value3);
				island[x][this.columnL-1] = decide(value4);
			}
		}
	}
	
	public String mouseConditon(int pos) {
		String condition = "";
		if(pos == -2) {
			condition += "The mouse has run out of food and starved";
		}
		if(pos == -1) {
			condition += "The mouse has unfortunately drowned";
		}
		if(pos == 0) {
			condition += "The mouse has escaped";
		}
		return condition;
	}
	
	public void moveMouse(int[][] island) {
		int direction;
		int row = rowL /2;
		int column = columnL /2;

		for(int i = 0; i < this.turns; i++) {
			direction = this.rollRandom(4, 1);
			if(row != 0 && row != rowL-1) {
				if(column != 0 && column != columnL-1) {
					island[row][column] = i;
					if(direction == 1) {
						row++;
					}
					else if(direction == 2) {
						column++;
					}
					else if(direction == 3) {
						row--;
					}
					else if(direction == 4) {
						column--;
					}
				}
				else {
					this.position = island[row][column];
				}
			}
		}
	}
	
	public String[][] convertBorders(int[][] island) {
		String[][] result = new String[this.rowL][this.columnL];
		
		for(int i = 0; i < this.rowL; i++) {
			for(int x = 0; x < this.columnL; x++) {
				if(island[i][x] == -1) {
					result[i][x] = "W";
				}
				else if(island[i][x] == -3){
					result[i][x] = "B";
				}
				else if(island[i][x] == -2){
					result[i][x] = "O";
				}
				else {
					result[i][x] = Integer.toString(island[i][x]);
				}
			}
		}
		return result;
	}
	
	public void spacing(String[][] strBoard) {
		for(int i = 0; i < this.rowL; i++) {
			for(int x = 0; x < this.columnL; x++) {
				String str = strBoard[i][x];
				if(str.length() == 2) {
					System.out.print("  " + str + " ");
				}
				else {
					System.out.print("  " + str + "  ");
				}
			}
			System.out.println("");
		}
	}
	
	public void startSim() {
//		for(int y = 0; y < 1000; y++) {
			this.initIsland();
			this.setBorders(island);
			this.moveMouse(island);
			String[][] strBoard = this.convertBorders(island);
//		if(y < 3) {
			this.spacing(strBoard);
			System.out.println("\n\n" + this.mouseConditon(this.position) + "\n\n");
//		}
	}
}
