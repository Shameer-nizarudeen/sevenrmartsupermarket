package com.sevenrmartsupermarket.tests;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliverBoyPage;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class ManageDeliverBoyTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	ManageDeliverBoyPage managedeliverboy;

	@Test
	public void navigateTo_ManagaeDeliveryBoy() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		homepage = new HomePage(driver);

		managedeliverboy = new ManageDeliverBoyPage(driver);
		managedeliverboy.clickon_ManageDeliveryBoyOption();
	}

	@Test
	public void new_Delivery_Boy() {
		navigateTo_ManagaeDeliveryBoy();
		managedeliverboy = new ManageDeliverBoyPage(driver);
		managedeliverboy.create_DeliveryBoy("Shameer", "Shameer123@gmail.com", "1234567810", "Trivandrum",
				"Shameer Nizar", "1234ABCD");
		String expectedResult = "Enter Delivery Boy Informations";
		String actualResult = managedeliverboy.get_UserInfo_print();
		;
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(groups = "sanity")
	public void verify_DeliveryBoysNames() {
		navigateTo_ManagaeDeliveryBoy();
		managedeliverboy = new ManageDeliverBoyPage(driver);
		managedeliverboy.print_BoysNames();
		String expectedResult = "List Delivery Boy";
		String actualResult = managedeliverboy.get_UserList_Heading();
		Assert.assertEquals(actualResult, expectedResult);

	}

}
