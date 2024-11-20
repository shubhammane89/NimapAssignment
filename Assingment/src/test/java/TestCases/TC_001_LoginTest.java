package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import TestBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public void testValidLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);

		
		loginPage.enterEmail("siddiqshaikh1@nimapinfotech.com");
		loginPage.enterPassword("admin@123");
		loginPage.clickLoginButton();
		
		boolean isMessageDisplayed = loginPage.isPunchedInMessageDisplayed();

	
		Assert.assertTrue(isMessageDisplayed, "'Punched In' message is not displayed after login!");
		Thread.sleep(5000);

		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		addCustomerPage.customerDashboard(); 
		addCustomerPage.AddNewCustomer(); 
		addCustomerPage.enterCustomerName("Shubham Mane"); 
		addCustomerPage.saveCustomer();
	}

}
