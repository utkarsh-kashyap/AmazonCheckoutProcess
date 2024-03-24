package com.amazon.tests;

import org.testng.annotations.Test;

import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.ProductListingPage;
import com.setup.BaseClass;

public class AddToCartTest extends BaseClass {
	
	AmazonHomePage amazonHomePage;
	ProductListingPage productListingPage;
	
	@Test(priority=1, enabled=true)
	public void addToCartTest() {
		
		amazonHomePage  = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		
		
		amazonHomePage.enterProductNameInSearchBox();
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		
	}

}
