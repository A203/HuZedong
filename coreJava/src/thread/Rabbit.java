package thread;

public class Rabbit extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
			System.out.println("rabbit has run "+i+"steps");
	}
}
