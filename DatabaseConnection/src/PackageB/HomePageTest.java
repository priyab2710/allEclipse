package PackageB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import PackageA.Base;
import PackageA.MysqlConnect;
import PageObjects.HomePageObject;

public class HomePageTest extends Base {
public static MysqlConnect conc;
	
	@Test
	public void VerifyAllLinks() throws SQLException, IOException
	{
		driver=initializebrowser();
		driver.get(prop.getProperty("url"));
		HomePageObject hpo=new HomePageObject(driver);
		hpo.signin().click();
		conc= new MysqlConnect();
		Statement st= conc.databaseconnection1();
		ResultSet rs= st.executeQuery("select * from EmployeeInfo");
		while(rs.next())
		{
			
		}
		
		
	}
}
