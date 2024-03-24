package com.amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ReusableMethods;

public class CheckoutPage {
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@data-action='delete'])[1]")
	private WebElement itemDeleteButton;
	
	@FindBy(xpath = "(//span[@class='currencyINR']/following-sibling::text())[1]")
	private WebElement subTotal;
	
	public void clickOnDeleteItemButton() {
		ReusableMethods.clickElement(itemDeleteButton, "Delete Item Button");
	}
	
	public String getSubTotalAmount() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String value = (String) javascriptExecutor.executeScript(
		    "return document.evaluate(\"(//span[@class='currencyINR']/following-sibling::text())[1]\", document, null, XPathResult.STRING_TYPE, null).stringValue;"
		);
		return value;
	}
	
	public void refreshCheckoutPage() {
		driver.navigate().refresh();
	}

}
