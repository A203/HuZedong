package day01;

import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
	public static void menu()
	{
		System.out.println("|1.增加一个学生|");
		System.out.println("|2.显示全部学生|");
		System.out.println("|3.退出|");
		System.out.print("|请输入选择（1-3）:");
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
					System.out.println("输入学生姓名：");
					String s = sc.next();
					ls.add(s);
					System.out.println("添加学生成功！");
					break;
			case 2: System.out.println(ls);break;
			}
			menu();
			x=sc.nextInt();
		}
		System.out.println("Bye!");
	}
}
