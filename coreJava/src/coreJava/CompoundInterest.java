package coreJava;

/*
 * double[][] balances = new double[10][6]; //Java
 * differ double balances[10][6]   //C++
 * differ double (*balances)[6] = new double[10][6] //C++
 * same as double** balance = new double*[10]; //C++
 * && for(i=0;i<10;i++)
 * 		balances[i]=new double[6];
 */
public class CompoundInterest {
	public static void main(String[] args) {
		final double STARTRATE = 10;
		final int NRATES = 6;
		final int NYEARS = 10;
		
		//set interest rates to 10 ... 15%
		double[] interestRate = new double[NRATES];
		for(int j=0;j<interestRate.length;++j)
			interestRate[j] = (STARTRATE+j)/100.0;
		
		double[][] balances = new double[NYEARS][NRATES];
		
		//set initial balances to 10000
		for(int j=0;j<balances[0].length;++j)
			balances[0][j] = 10000;
		
		for(int i=1;i<balances.length;++i)
		{
			for(int j=0;j<balances[i].length;++j)
			{
				//get last year's balances from previous row
				double oldBalance = balances[i-1][j];
				
				//compute interest
				double interest = oldBalance*interestRate[j];
				
				//compute this year's balances
				balances[i][j] = oldBalance+interest;
			}//end of for block
		}//end of for block
		
		for(int j = 0;j<interestRate.length;++j)
			System.out.printf("%9.0f%%",100*interestRate[j]);
		
		System.out.println();
		
		//print balance table
		for(double[] row : balances)
		{
			//print table row
			for(double b : row)
			{
				System.out.printf("%10.2f",b);
			}
			System.out.println();
		}//end of for block
		
		
	}//end of main block
}
