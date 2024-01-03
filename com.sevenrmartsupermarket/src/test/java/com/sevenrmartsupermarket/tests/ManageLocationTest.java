package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	ManageLocationPage managaelocation;

	@Test
	public void navigateTo_ManageLocation() {

		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		homepage = new HomePage(driver);
	
		managaelocation=new ManageLocationPage(driver);
		managaelocation.clickOn_DeliveryLocation();
		
		
	}
	@Test
	public void add_Locations()
	{
		navigateTo_ManageLocation();
		managaelocation.clicOn_New();
		managaelocation.enter_LocationField();;
		managaelocation.enter_DeliveryCharge_Field();
		managaelocation.clicOn_Save();
		String expectedResult="Add Locations";
		String actualResult=managaelocation.get_LocationList_Heading();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test
	public void verify_Editing_In_locations()
	{
		navigateTo_ManageLocation();
		managaelocation.edit_Location("Kashmir");
		String actualResult="Edit Location";
		String expectedResult=managaelocation.get_EditLocation_Heading();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	

}
