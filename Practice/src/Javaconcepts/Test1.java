package Javaconcepts;


public class Test1 implements Client,Customer {

	public static void main(String[] args) {
	
		Test1 t= new Test1();
		t.checkbalance();
		t.transferbalance();
		t.paycredit();
		t.login();
		Customer c= new Test1();
		c.setdata();
		c.getdata();
		
	}

	@Override
	public int paycredit() {
		// TODO Auto-generated method stub
		System.out.println("paycredit implemented");
		return 0;
		
	}

	@Override
	public void transferbalance() {
		// TODO Auto-generated method stub
		System.out.println("transferbalance implemented");
	}

	@Override
	 public void checkbalance() {
		// TODO Auto-generated method stub
		System.out.println("checkbalance implemented");
	}
	
	public void login() {
		System.out.println("test login");
	}

	@Override
	public void getdata() {
	
		System.out.println("getdata implemented");
	}

	@Override
	public void setdata() {

		System.out.println("setdata implemented");
		
	}

	

}
