package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriverWait wait;

	public static final long IMPLICIT_WAIT=10;
	public static final long EXPLICIT_WAIT=30;
	
	public void waitFor_ButtonToBe_Clickable(WebDriver driver,WebElement element) {
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
public void waitFor_ElementToBe_Visible(WebDriver driver,WebElement element) {
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
}
}
