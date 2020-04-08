
public class MyClass1 {

	
	   private int age =10;
	   private String name;
	   
	   public int getAge()
	   {
		   return age;
		   
	   }
	   
	   public String getName()
	   {
		   return name;
		   
	   }
	   
	   public void setName(String ename)
	   {
		   this.name=ename;
	   }
	   
	   public static void main(String[] args) {

		   MyClass1 c1= new MyClass1();
		   int x= c1.getAge();
		   System.out.println(x);
		   c1.setName("Priya");
		   System.out.println(c1.getName());
		}

}

