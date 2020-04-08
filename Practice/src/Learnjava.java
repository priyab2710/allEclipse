import Javaconcepts.Test1;

public class Learnjava {

	public static void main(String[] args) {
		mymethod();
		Learnjava j= new Learnjava();
		System.out.println("The value of x is " + j.x);
		j.mymethod1();
		j.mymethod2(10);
		Learnjava j1 = new Learnjava(50);
		System.out.println("The value of x in constructor of parameter is " + j1.x);
		Test1 t = new Test1();
  t.checkbalance();
	}
   public int x;
	public Learnjava() {
		x=20;
		
	}
	public Learnjava(int y) {
		
		x= y+10;
		
	}
	
	static void mymethod() {
		System.out.println("this is static method");
	}
	
	public void mymethod1() {
		System.out.println("this is public method");
	}
	public void mymethod2(int x) {
		System.out.println("The value of x is " + x);
	}
	
}
