package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.listeners.Reporting;
import com.setup.BaseClass;
import com.utilities.ReusableMethods;

public class AmazonHomePage {
	WebDriver driver;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTextbox;

	@FindBy(xpath = "//input[@type='submit' and @value='Go']")
	private WebElement searchSubmitButton;

	@FindBy(xpath = "//a[@id='nav-cart']")
	private WebElement cartButton;

	public void navigatedToBaseURL() {
		driver.get(BaseClass.baseURL);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, BaseClass.baseURL);
		Reporting.logInfo("Navigated to " + currentURL + " Successfully");
	}

	public void enterProductNameInSearchBox(String productName) {
		try {
			ReusableMethods.enterText(searchTextbox, productName, "Search Box");
		} catch (Exception e) {
			driver.navigate().refresh();
			ReusableMethods.enterText(searchTextbox, productName, "Search Box");
		}
	}

	public void clickOnSearchButton() {
		ReusableMethods.clickElement(searchSubmitButton, "Submit Search Button");
	}

	public void clickOnCartButton() {
		ReusableMethods.clickElement(cartButton, "Cart Button");
	}

}
