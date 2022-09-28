package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_pageObjects {
	//driver has not scope. or null driver
	public WebDriver driver;
	
	By userName= By.xpath("//input[@id='username']");
	By passWord = By.xpath("//input[@id='password']");
	By loginButton= By.xpath("//input[@id='Login']");
	By tryFree= By.xpath("//a[@id='signup_link']");
	
	
	
	public LoginPage_pageObjects(WebDriver driver2) {
		
		// we are giving the scope to driver from driver2. and now driver is not null
	 this.driver=driver2;
		
	}

	public WebElement userName() {
		
		return driver.findElement(userName);
	}
	
	public WebElement userPass()
	{
		return driver.findElement(passWord);
	}
	
	public WebElement clickOnLoginBtn() {
		
		return driver.findElement(loginButton);
	}
	
	public WebElement signUp() {
		
		return driver.findElement(tryFree);
		
	}

}
