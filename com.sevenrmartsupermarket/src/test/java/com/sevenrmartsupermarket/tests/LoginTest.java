package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verify_Login() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		String expectedProfileName = "Admin";
		loginpage.login();
		String actualProfileName = homepage.get_ProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

	@Test(groups = "smoke",retryAnalyzer = RetryAnalyzer.class)
	public void verify_Invalid_Login_Errormessage() {

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("shameer", "123");
		boolean actualresult=loginpage.check_ErrorMessage("Invalid Username/Password");
		Assert.assertTrue(actualresult);
		
		
		

	}

}
