//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;

public class Arraytest {
	
	public Arraytest() {
		System.out.println("I am constructor");
	}
	public Arraytest(int a, int b) {
		System.out.println("I am parameterized constructor with " + (a+b));
	}
	
	public Arraytest(int a, int b, String c) {
		System.out.println("I am parameterized constructor with " + (a+b) + " " + c);
	}


	public static void main(String[] args) {
		
		
		Arraytest a= new Arraytest();
		Arraytest b= new Arraytest(4,5);
		Arraytest c= new Arraytest(4,5,"Priya");
		Learnjava l=new Learnjava();

	}
}
