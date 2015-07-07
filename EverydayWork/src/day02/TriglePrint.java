package day02;

import java.util.Scanner;

public class TriglePrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] ch = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
				'C', 'D' ,'E','F'};
		for (int i = 0; i < n; ++i) {
			printSpace(n-i);
			printChar(ch[i], 2*i+1);
		}

	}

	public static void printSpace(int n) {
		for (int i = 0; i < n; i++)
			System.out.print(' ');
	}
	
	public static void printChar(char ch,int n)
	{
		for(int i=0;i<n;++i)
			System.out.print(ch);
		System.out.println();
	}
}
