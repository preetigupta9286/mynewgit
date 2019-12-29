package tesbBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testutility.Utilities;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{try
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\surbh\\eclipse-workspace\\yahoo.qa\\src\\main\\java\\yahoo\\config\\configOrProperty");
	prop.load(ip);
	}
	catch(FileNotFoundException e)	
	{e.printStackTrace();
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}}
	public static void initialization()
	{String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdrive.chromedriver","C:\\Program Files (x86)\\Micro Focus\\Unified Functional Testing\\bin\\WebDriver\\chromedriver.exe" );
	driver=new ChromeDriver();
	}
	
	else if(browsername.equals("firefox"))
			{
	
	//	System.setProperty("webdriver.gecho.driver","‪C:\\geckodriver.exe" );
		driver=new FirefoxDriver();
}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Utilities.page_load_time,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Utilities.implicit_wait,TimeUnit.SECONDS);
		
	}
	}


