package Academy;

import java.io.IOException;
import org.apache.log4j.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{ // inherits the properties of base.java class so that we can use its methods
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest// to initialize the driver 
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		driver.get(Prop.getProperty("url"));
		log.info("navigated to home page");
	}
	@Test(dataProvider="getData") 
	
	public void basePageNavigation(String Username ,String Password) throws IOException
	{
		
		LandingPage l =new LandingPage(driver);
		l.getLogin().click();
		log.info("clicked on the login button");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		log.info("successfully entered the details");
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0]="dhiyanesh299@gmail.com";
		data[0][1]="123444";
		
		/*data[1][0]="dhiya@gmail.com";
		data[1][1]="12ddd";*/
		
		return data;
		
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	
	}
	

}
