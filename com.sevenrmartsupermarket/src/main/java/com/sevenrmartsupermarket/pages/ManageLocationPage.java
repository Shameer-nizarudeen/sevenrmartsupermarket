package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']")
	WebElement pathClick;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/add']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='location']")
	WebElement locField;
	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> locationListSelect;
	@FindBy(xpath = "//h1[contains(text(),'Add Locations')]")
	WebElement printHeading;
	@FindBy(xpath = "//h1[contains(text(),'Edit Location')]")
	WebElement printEditHeading;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOn_DeliveryLocation() {
		pathClick.click();

	}

	public void clicOn_New() {
		newButton.click();
	}

	public void enter_LocationField() {
		locField.sendKeys("trivandrum");
	}

	public void enter_DeliveryCharge_Field() {
		deliveryChargeField.sendKeys("50");
	}

	public void clicOn_Save() {
		saveButton.click();
	}

	public void edit_Location(String editingLocations) {
		int index = 0;

		List<String> names = new ArrayList<String>();
		generalUtility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		names = generalUtility.getTextOfElements(locationListSelect);
		System.out.println(names);

		for (index = 0; index < names.size(); index++) {
			if (editingLocations.equals(names.get(index))) {
				index++;
				break;
			}
		}
		WebElement editbutton = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + index + "]//td[6]//a[1]"));
		pageutility.scrollAndClick(editbutton);

	}

	public String get_LocationList_Heading() {
		generalUtility = new GeneralUtility(driver);
		String print_LocationList_Heading = generalUtility.get_Textof_element(printHeading);
		System.out.println(print_LocationList_Heading);
		return print_LocationList_Heading;

	}
	public String get_EditLocation_Heading()
	{
		generalUtility = new GeneralUtility(driver);
		String print_EditLocationList_Heading = generalUtility.get_Textof_element(printEditHeading);
		System.out.println(print_EditLocationList_Heading);
		return print_EditLocationList_Heading;

	}

}
