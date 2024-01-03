package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage {

	WebDriver driver;
	GeneralUtility generalutility;
	Properties properties = new Properties();
	FileInputStream ip;

	@FindBy(xpath = "//input[@name='username']")
	WebElement usrName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pass;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement signinButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enter_Username(String user_name) {
		usrName.sendKeys(user_name);
	}

	public void enter_password(String user_pass) {
		pass.sendKeys(user_pass);
	}

	public void sign_In() {
		signinButton.click();

	}

	public void login() {
		String UserName = properties.getProperty("username");
		String PassWord = properties.getProperty("password");
		login(UserName, PassWord);
	}

	public void login(String User_Name, String Pass_Word) {
		enter_Username(User_Name);
		enter_password(Pass_Word);
		sign_In();

	}

	public boolean check_ErrorMessage(String expectedErrorMess) {
		generalutility = new GeneralUtility(driver);
		String expectedErrorMessage = generalutility.get_Textof_element(errorMessage);
		
		return generalutility.is_WordPresent(errorMessage, expectedErrorMessage);

	}

}
