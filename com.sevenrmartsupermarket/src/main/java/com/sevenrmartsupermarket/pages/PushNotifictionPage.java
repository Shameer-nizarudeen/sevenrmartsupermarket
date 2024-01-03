package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class PushNotifictionPage {

	WebDriver driver;
	GeneralUtility generalutility;
	WaitUtility waitUtility;

	@FindBy(xpath = "//input[@placeholder='Enter Title']")
	WebElement titlePath;
	@FindBy(xpath = "//input[@placeholder='Enter Description']")
	WebElement descriptionPath;
	@FindBy(xpath = "//i[@class='fa fa-bell']")
	WebElement sendPath;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications'])[1]")
	WebElement pushNotifButton;
	

	public PushNotifictionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void click_On_PushButton()
	{
		pushNotifButton.click();
	}

	public void enter_Title(String title) {
		titlePath.sendKeys(title);
	}

	public void enter_Description(String description) {
		descriptionPath.sendKeys(description);
	}

	public void clickOn_Send() {
		sendPath.click();
	}

	public void sendNotification(String titles, String descriptions) 
	{
		
		enter_Title(titles);
		enter_Description(descriptions);
		clickOn_Send();
	}
	public boolean check_alertMess(String expectedAlertMess)
	{
		generalutility=new GeneralUtility(driver);
		String expectedAlerMessage=generalutility.get_Textof_element(alertMessage);
		return generalutility.is_WordPresent(alertMessage, expectedAlerMessage);
		
	}
	

}
