package thread;
/**
 * 
 * @author HZD-PC
 *1.创建多线程，继承Thread + 重写run() 线程体
 *2.
 */
public class Tortoise extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
			System.out.println("tortoise has run "+i+"steps");
	}
}
