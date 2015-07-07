package day03;

public class Test {
	public static void main(String[] args) {
		Army army = new Army(10);
		army.addWeapon(new Tank());
		army.addWeapon(new Flighter());
		army.addWeapon(new Warship());
		army.attackAll();
		army.moveAll();
	}
}	
