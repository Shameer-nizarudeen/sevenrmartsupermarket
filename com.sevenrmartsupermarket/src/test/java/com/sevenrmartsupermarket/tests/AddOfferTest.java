package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AddOfferPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AddOfferTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	AddOfferPage addofferpage;
	
	
	@Test(groups = {"smoke","regression"})
	public void navigateTo_AddOfferCodeOption()
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		homepage = new HomePage(driver);
		addofferpage=new AddOfferPage(driver);
		addofferpage.clickOnManageOfferCode();
		addofferpage.ClickOn_New();
		addofferpage.enter_OfferCode();
		addofferpage.choose_YesOrNo();
		addofferpage.enter_OfferPercentage();
		addofferpage.enterThe_Price();
		addofferpage.enter_TheDdescription();
		addofferpage.Choose_TheFile();
		addofferpage.save_ButtonClick();
		String expectedResult="Add Offercode";
		String actualResult=addofferpage.get_OfferCode_heading();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}


}
