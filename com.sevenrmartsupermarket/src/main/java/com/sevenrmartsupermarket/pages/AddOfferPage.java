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

public class AddOfferPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']//i[@class='fas fa-arrow-circle-right']")
	WebElement selectbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='offer_code']")
	WebElement entercode;
	@FindBy(xpath = "//input[@value='yes']")
	WebElement chooseyes;
	@FindBy(xpath = "//input[@id='offer_per']")
	WebElement enterpercentage;
	@FindBy(xpath = "//input[@id='offer_price']")
	WebElement enterprice;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement enterdescription;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement savebutton;

	public AddOfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOfferCode() {
		selectbutton.click();
	}

	public void ClickOn_New() {
		newbutton.click();
	}

	public void enter_OfferCode() {
		entercode.sendKeys("offercode1");
	}

	public void choose_YesOrNo() {
		chooseyes.click();
	}

	public void enter_OfferPercentage() {
		enterpercentage.sendKeys("50%");
	}

	public void enterThe_Price() {
		enterprice.sendKeys("1000");
	}

	public void enter_TheDdescription() {
		enterdescription.sendKeys("Test Description");
	}

	public void Choose_TheFile() {

		File file = new File(Constants.IMAGE_FILE_PATH);
		choosefile.sendKeys(file.getAbsolutePath());

	}

	public void save_ButtonClick() {
		pageUtility=new PageUtility(driver);
		pageUtility.scrollAndClick(savebutton);
	}
}
