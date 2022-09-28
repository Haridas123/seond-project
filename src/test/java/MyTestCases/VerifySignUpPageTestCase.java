package MyTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjectModel.LoginPage_pageObjects;
import pageObjectModel.SignupPageObject;
import resources.BaseClass;
import resources.Constants;

public class VerifySignUpPageTestCase extends BaseClass{
	
	@Test
	 public void signUP() throws IOException, InterruptedException {
		 
		/*
			// launch browser
		 	driverInitialization();
		 	//hit url
		 	driver.get("https://login.salesforce.com/?locale=in");	
		 */
		 
		 LoginPage_pageObjects lp= new LoginPage_pageObjects(driver); 
		 lp.signUp().click();
		 
		 SignupPageObject sg = new SignupPageObject(driver);
		 Thread.sleep(4000);
		 
		 sg.firstUsername().sendKeys(Constants.firstName);
		 sg.lastUsername().sendKeys(Constants.lastName);
		 sg.emailUser().sendKeys(Constants.userEmail);
		 sg.companyUser().sendKeys(Constants.userComp);
		 sg.userPhone().sendKeys(Constants.userPhone);
		 
		 
		 Select s = new Select(sg.userJobtitle());
		 
		 s.selectByIndex(3);
		 
		 Select s2= new Select(sg.userEmp());
		 s2.selectByIndex(3);
		 Thread.sleep(4000);
		 sg.userAgreement().click();
		
		
	}

}
