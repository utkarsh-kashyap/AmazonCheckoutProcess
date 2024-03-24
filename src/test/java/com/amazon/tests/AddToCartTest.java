package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.ProductDetailsPage;
import com.amazon.pages.ProductListingPage;
import com.setup.BaseClass;
import com.utilities.TestConstants;

public class AddToCartTest extends BaseClass {
	
	AmazonHomePage amazonHomePage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailsPage;
	
	@Test(priority=1, enabled=true)
	public void verifyUserCanAddItemToCart() {
		
		amazonHomePage  = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		
		amazonHomePage.navigatedToBaseURL();
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		String initialCartCount = productDetailsPage.getCartCount();
		productDetailsPage.clickOnAddToCartButton();
		String finalCartCount = productDetailsPage.getCartCount();

		int initialCount = Integer.parseInt(initialCartCount);
		int finalCount = Integer.parseInt(finalCartCount);
		
		Assert.assertTrue(productDetailsPage.isItemAddedToCartMessageDisplayed(), "Assertion failed for Item added to cart.");
		Assert.assertEquals(finalCount, initialCount + 1, "The final cart count is not incremented by one");
	}

}
