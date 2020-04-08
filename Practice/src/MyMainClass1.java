
public class MyMainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OuterClass o = new OuterClass();
		OuterClass.InnerClass i=o.new InnerClass();
		//InnerClass i1 = new InnerClass();
		System.out.println(i.y + " " + o.x);
	}

}
