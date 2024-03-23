package com.amazon.tests;

import org.testng.annotations.Test;

import com.amazon.pages.AmazonHomePage;
import com.setup.BaseClass;

public class AddToCartTest extends BaseClass {
	
	AmazonHomePage amazonHomePage;
	
	@Test(priority=1, enabled=true)
	public void addToCartTest() {
		
		amazonHomePage  = new AmazonHomePage(driver);
		
		amazonHomePage.enterProductNameInSearchBox();
		amazonHomePage.clickOnSearchButton();
	}

}
