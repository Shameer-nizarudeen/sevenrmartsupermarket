package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;


public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void verify_ProfileName()
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin","admin");
		homepage=new HomePage(driver);
		homepage.get_ProfileName();
		
		
	}

}
