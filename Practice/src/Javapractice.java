
public class Javapractice {

	public static void main(String[] args) {


		int a[] = {1,2,3,4};
		int sum =0;
        for(int i=0;i<a.length;i++)
        {
        	sum= sum+ a[i];
        	if(a[i]==3)
        	{
        		System.out.println(i);
        		break;
        	}
        	
        }
        System.out.println(sum);
	}  
	   
	  
	
	
	
	

}
