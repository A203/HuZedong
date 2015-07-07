package day02;

import java.util.Random;

public class Array {
	public static void main(String[] args) {
		String[] course = { "core C++", "core Java", "Servlet", "JSP", "EJB" ,"Total"};
		for (String x : course)
			System.out.printf("%10s",x + "|");
		System.out.println();

		int[][] stus = new int[20][5];
		int[] total = new int[20];
		double[] average = new double[5];
		Random rand = new Random(47);
		
		//initialization
		for (int i = 0; i < 20; ++i)
			for (int j = 0; j < 5; ++j)
				stus[i][j] = rand.nextInt(100);
		
		//total scores 
		for(int i = 0;i<20;++i)
		{
			for(int j=0;j<5;++j)
				total[i]+=stus[i][j];
		}
		
		//average scores
		for(int j=0;j<5;++j)
		{
			for(int i=0;i<20;++i)
			{
				average[j]+=stus[i][j];
			}
			average[j]/=20;
		}
		
		//print
		for (int i = 0; i < 20; ++i) 
		{
			for (int j = 0; j < 5; ++j) 
			{
				System.out.printf("%8s",stus[i][j]);
				System.out.print("  ");
			}
			System.out.printf("%8s",total[i]);
			System.out.print("  ");
			System.out.println();
		}// end of for block
		
		System.out.println("Average:");
		for(double x:average)
			System.out.printf("%10.2f",x);

	}// end of main block
}
