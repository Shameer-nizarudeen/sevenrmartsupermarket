package com.sevenrmartsupermarket.pages;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageDeliverBoyPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	WebElement managedelivbutton;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement namefield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonefield;
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement addressfield;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	List<WebElement> deliveryBoyNames;

	 

	public ManageDeliverBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void create_DeliveryBoy(String names, String email, String phn, String address, String us, String pass) {
		clickOn_Edit();
		enter_Name(names);
		enter_Email(email);
		enter_PhoneNumber(phn);
		enter_Address(address);
		enter_UserName(us);
		enter_Password(pass);
		clickOn_Save();

	}

	public void clickon_ManageDeliveryBoyOption() {

		managedelivbutton.click();

	}

	public void clickOn_Edit() {
		newbutton.click();
	}

	public void enter_Name(String name) {
		namefield.sendKeys(name);
	}

	public void enter_Email(String email) {
		emailfield.sendKeys(email);
	}

	public void enter_PhoneNumber(String number) {
		phonefield.sendKeys(number);
	}

	public void enter_Address(String address) {

		addressfield.sendKeys(address);
	}

	public void enter_UserName(String username) {
		usernamefield.sendKeys(username);
	}

	public void enter_Password(String password) {
		passfield.sendKeys(password);

	}

	public void clickOn_Save() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement start = driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(start));

		savebutton.click();
	}

	public void print_BoysNames() {

		List<String> names = new ArrayList<String>();
		generalUtility = new GeneralUtility(driver);
		names = generalUtility.getTextOfElements(deliveryBoyNames);
		System.out.println(names);
	}

	public void edit_User(String editinguser) {
		int index = 0;

		List<String> names = new ArrayList<String>();
		generalUtility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		names = generalUtility.getTextOfElements(deliveryBoyNames);
		System.out.println(names);

		for (index = 0; index < names.size(); index++) {
			if (editinguser.equals(names.get(index))) {
				index++;
				break;
			}
		}
		WebElement editbutton = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr["+index+"]//td[8]//a[1]"));
		pageutility.scrollAndClick(editbutton);

	}

}
