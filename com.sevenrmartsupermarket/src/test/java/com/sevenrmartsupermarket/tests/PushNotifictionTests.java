package com.sevenrmartsupermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotifictionPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class PushNotifictionTests extends Base {

	ExcelRead excelread = new ExcelRead();
	HomePage homepage;
	PushNotifictionPage pushnotificationpage;
	LoginPage loginpage;

	@Test
	public void verify_PushNotification_AlertMessage() {
		excelread.setExcelFile("PushNotification", "Notification");
		String notifdata1 = excelread.getCellData(0, 0);
		System.out.println(notifdata1);
		String notifdata2 = excelread.getCellData(1, 0);
		System.out.println(notifdata2);
		String notifdata3 = excelread.getCellData(2, 0);
		System.out.println(notifdata3);
		String notifdata4 = excelread.getCellData(0, 1);
		System.out.println(notifdata4);
		String notifdata5 = excelread.getCellData(1, 1);
		System.out.println(notifdata5);
		String notifdata6 = excelread.getCellData(2, 1);
		System.out.println(notifdata6);
		System.out.println();
		excelread.setExcelFile("LoginData", "Login Credentials");
		String logindata1 = excelread.getCellData(0, 0);
		System.out.println(logindata1);
		String logindata2 = excelread.getCellData(1, 0);
		System.out.println(logindata2);
		String logindata3 = excelread.getCellData(2, 0);
		System.out.println(logindata3);
		String logindata4 = excelread.getCellData(0, 1);
		System.out.println(logindata4);
		String logindata5 = excelread.getCellData(1, 1);
		System.out.println(logindata5);
		String logindata6 = excelread.getCellData(2, 1);
		System.out.println(logindata6);
		
		

	}
	@Test(groups = "smoke")
	public void verify_AlertMessage()
	{
		loginpage = new LoginPage(driver);
		loginpage.login("admin","admin");
		homepage=new HomePage(driver);
		pushnotificationpage=new PushNotifictionPage(driver);
		pushnotificationpage.click_On_PushButton();
		pushnotificationpage.sendNotification("title1", "description1");
		pushnotificationpage.clickOn_Send();
		pushnotificationpage.check_alertMess("Message send successfully");
		boolean actualresult=pushnotificationpage.check_alertMess("Message send successfully");
		Assert.assertTrue(actualresult);
		
		
		
	}

}
