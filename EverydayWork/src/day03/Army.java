package day03;

public class Army {
	Weapon[] w;
	private int count=0;
	public Army(int num)
	{
		w = new Weapon[num];
	}
	
	public void addWeapon(Weapon wa)
	{
		if(count<w.length)
			w[count++]=wa;
		else
			System.out.println("武器数量达到上限");
	}
	
	public void attackAll()
	{
		for(int i=0;i<count;++i)
			w[i].attack();
	}
	
	public void moveAll()
	{
		for(int i=0;i<count;++i)
			w[i].move();
	}
}
