package day01;

import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
	public static void menu()
	{
		System.out.println("|1.����һ��ѧ��|");
		System.out.println("|2.��ʾȫ��ѧ��|");
		System.out.println("|3.�˳�|");
		System.out.print("|������ѡ��1-3��:");
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		menu();
		LinkedList<String> ls = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while(1==x||2==x){
			switch(x)
			{
			case 1: 
					System.out.println("����ѧ��������");
					String s = sc.next();
					ls.add(s);
					System.out.println("���ѧ���ɹ���");
					break;
			case 2: System.out.println(ls);break;
			}
			menu();
			x=sc.nextInt();
		}
		System.out.println("Bye!");
	}
}
