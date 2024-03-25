package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.listeners.Reporting;
import com.setup.BaseClass;
import com.setup.WaitClass;

public class ReusableMethods extends BaseClass{
	
	public long measurePageLoadTime(String url) {
	    long startTime = System.currentTimeMillis();
	    driver.get(url);
	    long endTime = System.currentTimeMillis();
	    long pageLoadTime = endTime - startTime;
	    return pageLoadTime;
	}
	
	public long measureResponseTime(WebElement element) {
	    long startTime = System.currentTimeMillis();
	    element.click(); // Perform the action
	    long endTime = System.currentTimeMillis();
	    long responseTime = endTime - startTime;
	    return responseTime;
	}
	
	
	public static void clickElement(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		element.click();
		Reporting.logInfo("Clicked on "+ elementname);
	}
	
	public static void clickElementUsingFluentWaitForDuration(WebElement element, String elementname, int duration) {
		WaitClass.waitForClickabilityOfElementIgnoringExceptionForDuration(element,duration);
		element.click();
		Reporting.logInfo("Clicked on "+ elementname);
	}
	
	public static void enterText(WebElement element, String str, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		element.sendKeys(str);
		Reporting.logInfo("Entered "+ str+ " in "+ elementname);
	}
	
	public static void clearText(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		element.clear();
		Reporting.logInfo("Cleared text in "+elementname);
	}
	
	public static String getElementText(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		String elementText = element.getText();
		Reporting.logInfo("Fetch text of "+elementname);
		return elementText;
	}
	
	public static boolean isElementDisplayed(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		try {
			element.isDisplayed();
			Reporting.logInfo(elementname+" is displayed");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static void selectByValueInSelectBox(WebElement element, String value, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
		Reporting.logInfo("Selected "+value+" in the "+elementname);
	}
	
	public static void selectByViibletext(WebElement element, String text, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
		Reporting.logInfo("Selected "+text+" in the "+elementname);
	}
	
	public static void selectByIndexInSelectBox(WebElement element, int index, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		Reporting.logInfo("Selected "+index+" in the "+elementname);
	}
	
	public static void waitUntilTextIsPresent(WebElement element, String str) {
		WaitClass.waitForTextToAppear(element, str);
	}
	
	public static void moveToElement(WebElement element, String elementname) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			Reporting.logInfo("Hover over "+elementname+" Successfully");
		} catch (Exception e) {
			Reporting.logInfo("Hover over "+elementname+" Failed");
		}
	}
	
	public static void switchToWindowHandle() {
		WaitClass.waitForNewWindowToAppear();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			driver.manage().window().maximize();
		}
		Reporting.logInfo("Switched to window handle");
	}
	
	public static String getCurrentDateTime() {
		Date date = Calendar.getInstance().getTime();
		return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss z").format(date);
	}

}
