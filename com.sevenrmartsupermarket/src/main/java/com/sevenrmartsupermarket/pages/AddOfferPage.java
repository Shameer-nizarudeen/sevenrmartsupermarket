package com.sevenrmartsupermarket.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AddOfferPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;
	WaitUtility waitutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']//i[@class='fas fa-arrow-circle-right']")
	WebElement selectButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='offer_code']")
	WebElement enterCode;
	@FindBy(xpath = "//input[@value='yes']")
	WebElement chooseYes;
	@FindBy(xpath = "//input[@id='offer_per']")
	WebElement enterPercentage;
	@FindBy(xpath = "//input[@id='offer_price']")
	WebElement enterPrice;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement enterDescription;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	@FindBy(xpath = "//h1[contains(text(),'Add Offercode')]")
	WebElement offerFill;

	public AddOfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOfferCode() {
		selectButton.click();
	}

	public void ClickOn_New() {
		newButton.click();
	}

	public void enter_OfferCode() {
		enterCode.sendKeys("offercode1");
	}

	public void choose_YesOrNo() {
		chooseYes.click();
	}

	public void enter_OfferPercentage() {
		enterPercentage.sendKeys("50%");
	}

	public void enterThe_Price() {
		enterPrice.sendKeys("1000");
	}

	public void enter_TheDdescription() {
		enterDescription.sendKeys("Test Description");
	}

	public void Choose_TheFile() {

		File file = new File(Constants.IMAGE_FILE_PATH);
		chooseFile.sendKeys(file.getAbsolutePath());

	}

	public void save_ButtonClick() {
		pageUtility=new PageUtility(driver);
		pageUtility.scrollAndClick(saveButton);
	}
	public String get_OfferCode_heading()
	{
		 generalUtility=new GeneralUtility(driver);
	     String printOfferCodeHeading=generalUtility.get_Textof_element(offerFill);
	     System.out.println(printOfferCodeHeading);
	     return printOfferCodeHeading;
	}
	
}
