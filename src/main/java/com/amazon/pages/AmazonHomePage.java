package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ReusableMethods;
import com.utilities.TestConstants;

public class AmazonHomePage  {
	WebDriver driver;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Go']")
	private WebElement searchSubmitButton;
	
	
	public void enterProductNameInSearchBox() {
		ReusableMethods.enterText(searchTextbox, TestConstants.PRODUCT_NAME, "Product Name");
	}
	
	public void clickOnSearchButton() {
		ReusableMethods.clickElement(searchSubmitButton, "Submit Search Button");
	}

}
