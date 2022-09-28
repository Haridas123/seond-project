package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPageObject {
	
	public WebDriver driver;
	
	private By firstName= By.xpath("//input[@name='UserFirstName']");
	private By lastName= By.xpath("//input[@name='UserLastName']");
	private By email= By.xpath("//input[@name='UserEmail']");
	private By company= By.xpath("//input[@name='CompanyName']");
	private By phone = By.xpath("//input[@name='UserPhone']");
	private By jobTitle = By.xpath("//select[@name='UserTitle']");
	private By emp= By.xpath("//select[@name='CompanyEmployees']");
	private By agreement = By.xpath("(//div[@class='checkbox-ui'])[1]");
	
	
	
	public SignupPageObject(WebDriver driver2) {
		 this.driver=driver2;
	}

	public WebElement firstUsername()
	{
		return driver.findElement(firstName);
	}
	
	public WebElement lastUsername() {
		return driver.findElement(lastName);
	}
	
	public WebElement emailUser() {
		return driver.findElement(email);
		
	}

	public WebElement companyUser() {
		
		return driver.findElement(company);
	}
	
	public WebElement userPhone() {
		
		return driver.findElement(phone);
	}
	
	public WebElement userJobtitle() {
		return driver.findElement(jobTitle);
	}
	
	public WebElement userEmp()
	{
		return driver.findElement(emp);
	}
	
	public WebElement userAgreement() {
		return driver.findElement(agreement);
		
	}
}
