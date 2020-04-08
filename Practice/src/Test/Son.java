package Test;

public class Son extends Grandfather{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Son s = new Son();
     
     s.city();
     s.country();
	}

	
	public void city()
	{
		System.out.println("son city");
	}
	
	public void country()
	{
		System.out.println("son country");
	}
}
