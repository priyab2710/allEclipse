package ListPackage;

import java.util.HashSet;
import java.util.Iterator;

public class SetExample {

	public static void main(String[] args) {

		// hashset, LinkedHashSet, TreeSet example

		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(12);
		hs.add(16);
		hs.add(90);
		hs.add(12);
		System.out.println(hs);
		
		System.out.println(hs.contains(10));
		System.out.println(hs.isEmpty());
		System.out.println(hs.size());
		Iterator<Integer> i = hs.iterator();

		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("End of set");
	}

}
