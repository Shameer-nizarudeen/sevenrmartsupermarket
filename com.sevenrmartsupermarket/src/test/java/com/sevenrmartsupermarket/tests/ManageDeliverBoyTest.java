package com.sevenrmartsupermarket.tests;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
	public void add_New_DeliveryBoy()
	{
		navigateTo_ManagaeDeliveryBoy();
		managedeliverboy = new ManageDeliverBoyPage(driver);
		managedeliverboy.clickOn_Edit();
		managedeliverboy.enter_Name("Anju");
		managedeliverboy.enter_Email("anju123@gmail.com");
		managedeliverboy.enter_PhoneNumber("1234567810");
		managedeliverboy.enter_Address("Tycaud P.o,Trivandrum,Kerala");
		managedeliverboy.enter_UserName("Anju Ashok");
		managedeliverboy.enter_Password("12345678");
		managedeliverboy.clickOn_Save();
	}
	@Test
	public void new_Delivery_Boy() {
		navigateTo_ManagaeDeliveryBoy();
		managedeliverboy = new ManageDeliverBoyPage(driver);
		
		managedeliverboy.create_DeliveryBoy("AnjuAsokh", "anju@gmail.com", "1234", "tc123", "ushh", "ussp");
		
	}
	@Test
	public void verify_DeliveryBoysNames()
	{
		navigateTo_ManagaeDeliveryBoy();
		managedeliverboy = new ManageDeliverBoyPage(driver);
		managedeliverboy.print_BoysNames();
		managedeliverboy.edit_User("client28/12/2023 16:31:55");
		
		
		
	}
	
	

}
