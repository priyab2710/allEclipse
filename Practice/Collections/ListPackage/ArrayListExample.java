package ListPackage;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();
		a.add("Priya");
		a.add("Bhamare");
		a.add("Bhamare");
		a.add(0, "Saurabh");
		ArrayList<String> b = new ArrayList<String>();
		b.add("Priya");
		b.add("Bhamare");
		b.add("Bhamare");
		b.add(0, "Saurabh");
		System.out.println("object"+b);
		System.out.println(a.equals(b));
	/*	System.out.println("Get " + b.get(2));
		System.out.println("Index " + b.indexOf("Priya"));
		System.out.println("contains-" + b.contains("Priya"));
		System.out.println("Is empty " + b.isEmpty());
		System.out.println("Size " + b.size());
	    	
		for(int i=0; i<b.size();i++)
		{
			System.out.println(b.get(i));
		}
		b.removeAll(b);
		System.out.println("After removeAll " + b);
		System.out.println("Is empty " + b.isEmpty());
*/
	}
}
