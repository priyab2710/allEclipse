package PackageB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import PackageA.Base;
import PackageA.MysqlConnect;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObjects;

public class LoginPageTest extends Base{
public MysqlConnect conc;
public HomePageObject hpo;
public LoginPageObjects lpo;
	
@Test
	public void VerifyLogin() throws SQLException, IOException
	{
		driver=initializebrowser();
		driver.get(prop.getProperty("url"));
		 hpo=new HomePageObject(driver);
		 lpo=new LoginPageObjects(driver);
		hpo.signin().click();
		conc= new MysqlConnect();
		Statement st= conc.databaseconnection1();
		ResultSet rs= st.executeQuery("select * from employeelogin");
		rs.next();
		lpo.email().sendKeys(rs.getString("Username"));
		lpo.password().sendKeys(rs.getString("password")); 
		lpo.Submit().click();

		
		
	}
	
}
	

