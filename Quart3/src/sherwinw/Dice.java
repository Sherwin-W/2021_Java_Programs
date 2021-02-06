package sherwinw;

public class Dice {
	private int tosses;
	private int[] nums;
	
	public Dice()
	{
		this.tosses = 0;
		nums = new int[12];
	}
	public int getNum(int pos)
	{
		return nums[pos-1];
	}
	public void combine(int r1, int r2)
	{
		nums[r1 + r2 - 1] += 1;
	}
	public String makeBars(int total,int factor,int number)
	{
		String bar = "";
		for(int i = 0;i < number / factor; i++)
		{
			bar += "*";
		}
		double percent = number * 100.00/total;
		bar += "     " + percent + "%";
		return bar;
	}
}


