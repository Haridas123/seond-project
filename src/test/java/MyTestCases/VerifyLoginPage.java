package MyTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPage_pageObjects;
import resources.BaseClass;
import resources.Constants;

public class VerifyLoginPage extends BaseClass{
 
	@Test(dataProvider = "loginData") 
	public void loginVerification(String userName, String password) throws IOException {
		/*
		//this driver has scope
		driver = driverInitialization();
		driver.get("https://login.salesforce.com/?locale=in");		*/
		
		
		System.out.println("project path -->" +System.getProperty("user.dir"));
		
		LoginPage_pageObjects lg = new LoginPage_pageObjects(driver);
		lg.userName().sendKeys(userName);
		lg.userPass().sendKeys(password);
		lg.clickOnLoginBtn().click();
		
		String actualString="https://login.salesforce.com/?locale=in";
		//String expectedString="https://apiserotechnogeek.my.salesforce.com/oc/trialExpired.jsp";
		//Assert.assertTrue(false, password);
		
		String expectedUrl=driver.getCurrentUrl();
		//hard assert  
		Assert.assertEquals(actualString ,
				expectedUrl ); //https://apiserotechnogeek.my.salesforce.com/oc/trialExpired.jsp
		/*  
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();// important line */
		
	}
	
	@DataProvider
	public Object[][] loginData(){
		
		Object[][] obj = new Object[2][2];
		
		obj[0][0]=Constants.userName1;
		obj[0][1]=Constants.password1;
		//obj[1][0]=Constants.userName2;
		//obj[1][1]=Constants.password2;
		
		return obj;
	}
	
	
}
