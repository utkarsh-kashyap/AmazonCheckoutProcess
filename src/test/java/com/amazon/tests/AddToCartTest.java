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

	/*
	 * Test method to verify adding an item to the cart.
	 */
	@Test(priority = 1, enabled = true)
	public void verifyUserCanAddItemToCart() {

		// Instantiate page objects
		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		
		/*
		 * This section of code executes a test scenario where a user navigates to the base URL, searches for a product,
		 * adds it to the cart, and verifies if the cart count is incremented by one after adding the item.
		 */

		// Navigate to the Amazon home page
		amazonHomePage.navigatedToBaseURL();

		// Search for a product
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
		amazonHomePage.clickOnSearchButton();

		// Click on the first search result
		productListingPage.clickOnFirstSearchResult();

		// Get the initial cart count
		String initialCartCount = productDetailsPage.getCartCount();

		// Add the item to the cart
		productDetailsPage.clickOnAddToCartButton();

		// Get the final cart count
		String finalCartCount = productDetailsPage.getCartCount();

		// Convert counts to integers
		int initialCount = Integer.parseInt(initialCartCount);
		int finalCount = Integer.parseInt(finalCartCount);

		// Assertion for item added message
		Assert.assertTrue(productDetailsPage.isItemAddedToCartMessageDisplayed(),"Assertion failed for Item added to cart.");

		// Assertion for final cart count
		Assert.assertEquals(finalCount, initialCount + 1, "The final cart count is not incremented by one");
	}

}
