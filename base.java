package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public static WebDriver driver;// the driver is made global
	public Properties Prop;
public WebDriver initializeDriver() throws IOException
{
	// to pull the browser details from data.properties file.
	 Prop = new Properties();
	FileInputStream Fis = new FileInputStream("C:\\Users\\User\\E2EProject\\src\\main\\java\\resources\\data.properties");
	Prop.load(Fis);	
	String browserName = Prop.getProperty("browser");

	System.out.println(browserName);
	
	if(browserName.equals("chrome"))
	{
		// to execute in chrome driver.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		// to execute in firefox
	}
	else if (browserName.equals("IE"))
	{
		// to execute in IE
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

}
