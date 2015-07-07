package day02;

public class TriglePrint {
	public static void main(String[] args) {
		char[] ch = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
				'C', 'D' };
		for (int i = 0; i < ch.length; ++i) {
			printSpace(2*ch.length-i);
			printChar(ch[i], i+1);
		}

	}

	public static void printSpace(int n) {
		for (int i = 0; i < n; i++)
			System.out.print(' ');
	}
	
	public static void printChar(char ch,int n)
	{
		for(int i=0;i<n;++i)
			System.out.print(ch+" ");
		System.out.println();
	}
}
