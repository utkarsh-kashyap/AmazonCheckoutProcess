package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.setup.BaseClass;
import com.setup.WaitClass;

public class ReusableMethods extends BaseClass{
	
	public static void clickElement(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		element.click();
		System.out.println("Clicked on "+ elementname);
	}
	
	public static void clickElementUsingFluentWaitForDuration(WebElement element, String elementname, int duration) {
		WaitClass.waitForClickabilityOfElementIgnoringExceptionForDuration(element,duration);
		element.click();
		System.out.println("Clicked on "+ elementname);
	}
	
	public static void enterText(WebElement element, String str, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		element.sendKeys(str);
		System.out.println("Entered "+ str+ " as "+ elementname);
	}
	
	public static void clearText(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		element.clear();
		System.out.println(elementname);
	}
	
	public static String getElementText(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		String elementText = element.getText();
		System.out.println(elementname);
		return elementText;
	}
	
	public static boolean isElementDisplayed(WebElement element, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		try {
			element.isDisplayed();
			System.out.println(elementname);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static void selectByValueInSelectBox(WebElement element, String value, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
		System.out.println(elementname);
	}
	
	public static void selectByViibletext(WebElement element, String text, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
		System.out.println(elementname);
	}
	
	public static void selectByIndexInSelectBox(WebElement element, int index, String elementname) {
		WaitClass.waitForVisibilityOfElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		System.out.println(elementname);
	}
	
	public static void waitUntilTextIsPresent(WebElement element, String str) {
		WaitClass.waitForTextToAppear(element, str);
	}
	
	public static void moveToElement(WebElement element, String elementname) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			System.out.println(elementname);
		} catch (Exception e) {
			System.out.println(elementname+" Hover Failed");
		}
	}
	
	public static void switchToWindowHandle() {
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			driver.manage().window().maximize();
		}
	}
	
	public static String getCurrentDateTime() {
		Date date = Calendar.getInstance().getTime();
		return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss z").format(date);
	}

}
