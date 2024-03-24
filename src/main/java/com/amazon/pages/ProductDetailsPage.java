package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ReusableMethods;

public class ProductDetailsPage {
WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[normalize-space()='Go to Cart' and @data-csa-c-slot-id='sw-gtc']")
	private WebElement goToCartButton;
	
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	private WebElement cartCount;
	
	@FindBy(xpath = "//h1[normalize-space()='Added to Cart']")
	private WebElement addedCartText;
	
	
	public void clickOnAddToCartButton() {
		ReusableMethods.clickElement(addToCartButton, "Add To Cart Button");
	}
	
	public void clickOnGoToCartButton() {
		ReusableMethods.clickElement(goToCartButton, "Go To Cart Button");
	}
	
	public String getCartCount() {
		return ReusableMethods.getElementText(cartCount, "Cart Count");
	}
	
	public boolean isItemAddedToCartMessageDisplayed() {
		return ReusableMethods.isElementDisplayed(addedCartText, "Added To Cart Message");
	}
}
