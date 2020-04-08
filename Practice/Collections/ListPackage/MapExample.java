package ListPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "test0");
		hm.put(1, "test1");
		hm.put(20, "test20");
		hm.put(2, "test02");
		hm.put(30, "");
		// System.out.println(hm);

		Set sm = hm.entrySet();
		Iterator i = sm.iterator();
		while (i.hasNext()) {

			Map.Entry me = (Map.Entry) i.next();
			// System.out.println("First print "+me);
			System.out.println("Second print " + me.getKey() + " " + me.getValue());
			

		}

	}

}
