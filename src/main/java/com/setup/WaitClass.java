package com.setup;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass extends BaseClass {
	
	public static  void waitForVisibilityOfElement(WebElement element) throws Error{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static  void waitForClickabilityOfElement(WebElement element) throws Error{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForClickabilityOfElementIgnoringExceptionForDuration(WebElement element, int duration) throws Error{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(duration)).pollingEvery(Duration.ofMillis(2500)).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForTextToAppear(WebElement element, String str) throws Error{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element, str));
	}

}
