package Javaconcepts;

public class ExceptionLearn {

	public static void main(String[] args) {
		int a=4;
		int b=7;
		int c=3;
		
		try 
		{
			int k=b/c;
			System.out.println(k);
			//int a1[]= new int[5];
			//System.out.println(a1[7]);
		}
		catch (ArithmeticException e1)
	    {
			System.out.println("It is an arithmetic exception");
		}
		catch (IndexOutOfBoundsException e2)
	    {
			System.out.println("It is an index exception");
		}
		catch (Exception e3)
	    {
			System.out.println("It is an simple exception");
		}
		finally
		{
			System.out.println("It is an finally block");
		}
	}

}
