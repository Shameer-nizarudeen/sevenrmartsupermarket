package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShot;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	ScreenShot screenshot = new ScreenShot();
	FileInputStream ip;

	/** initialising configfile **/

	public Base() {
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/** initialisation browser **/

	public void initialise(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));

	}

	@BeforeMethod
	public void launch_Browser() {

		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialise(browser, url);

	}

	@AfterMethod
	public void terminate_Sesssion(ITestResult itestresult) {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenshot.take_ScreenShot(driver, itestresult.getName());
		}
	}

}