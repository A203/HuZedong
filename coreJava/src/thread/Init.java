package thread;
/**
 * 
 * @author HZD-PC
 *	thread 1 Rabbit
 *  thread 2 Tortoise
 *  thread 3 main
 *  thread 4 exception
 *  thread 5 gc
 */
public class Init {
	public static void main(String[] args) {
		Rabbit ra = new Rabbit();
		Tortoise to = new Tortoise();
			
		ra.start();		//not ra.run();��Ҫ����run()����
		to.start();		//not to.run();
		for(int i=0;i<100;i++)
			System.out.println("main "+i+ " steps");
	}
}
