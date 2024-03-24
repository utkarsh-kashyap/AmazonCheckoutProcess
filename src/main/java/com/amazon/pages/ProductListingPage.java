package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ReusableMethods;

public class ProductListingPage {
WebDriver driver;
	
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@data-image-index='1']")
	private WebElement firstResultImage;
	
	
	public void clickOnFirstSearchResult() {
		ReusableMethods.clickElement(firstResultImage, "Product");
	}

}
