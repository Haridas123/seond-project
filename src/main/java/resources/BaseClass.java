package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver driverInitialization() throws IOException
	{
		// To read the file. we are reading here data.properties file
	//	FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\E2EtestNGFramework2\\src\\main\\java\\resources\\data.properties");
		
		// To read the file. we are reading here data.properties file.system takes direct path of the project
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		
		// to access the data.properties
		   prop = new Properties();
			prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_ver 105\\chromedriver.exe");
			 
			// we have added third party WebDriverManager dependency in pom.xml file.to get the browser path
			
			WebDriverManager.chromedriver().setup();//WebDriverManager detect latest browser version
			
			//if you want to run code on specific browser then use below line 
			//WebDriverManager.chromedriver().browserVersion("100.0.1").setup();  
			
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			// fireFox code
			//System.setProperty("Webdriver.firefox.driver", "E:\\chromedriver_ver 105\\chromedriver.exe");
			//WebDriver driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//edge code
			//System.setProperty("Webdriver.chrome.driver", "E:\\chromedriver_ver 105\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		
		return driver;
	}
	
	@BeforeMethod
	public void browserLaunch() throws IOException {
		//this driver has scope
				driver = driverInitialization();
				driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void browserClose() throws IOException {
	//	driver.quit();
		//driver.close();
		
	}
}
