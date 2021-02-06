package sherwinw;

import java.util.Random;
import javax.swing.JOptionPane;

public class DiceTest {
	public static void main (String[] args)
	{
		String input1=JOptionPane.showInputDialog("Enter Number of Tosses");
		int tosses=Integer.parseInt(input1);
		String input2=JOptionPane.showInputDialog("Enter Chart Size Factor");
		int factor = Integer.parseInt(input2);
		Dice one = new Dice();
		Random generate=new Random();
		
		
		for(int i=0;i<tosses;i++)
		{
			int r1=generate.nextInt(6)+1;
			int r2=generate.nextInt(6)+1;
			one.combine(r1,r2);
		}
		
		System.out.println("Processing your request...");
		System.out.println("Here are the results after "+tosses+" tosses of the dice.");
		System.out.println("Each asterisk equals "+factor+" rolls");
		for(int i=2;i<13;i++)
		{
			System.out.println(i+ ":"+one.makeBars(tosses,factor,one.getNum(i)));
		}
	}
}

