package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.CheckoutPage;
import com.amazon.pages.ProductDetailsPage;
import com.amazon.pages.ProductListingPage;
import com.setup.BaseClass;
import com.utilities.TestConstants;

public class RemoveFromCartTest extends BaseClass {

	AmazonHomePage amazonHomePage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailsPage;
	CheckoutPage checkoutPage;
	
	/*
     * Test method to verify if a user can remove an item from the cart successfully.
     */

	@Test(priority = 1, enabled = true)
	public void verifyUserCanRemoveItemFromCart() {

		// Instantiate page objects
		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);
		
		/*
		 * This section of code executes a test scenario where items are added to the cart and then one item is removed.
		 * It verifies if the cart count is decreased by one after removal and if the subtotal is correctly updated.
		 */
		
		// Navigate to the Amazon home page
		amazonHomePage.navigatedToBaseURL();
		
		// Search and add the first product to the cart
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		productDetailsPage.clickOnAddToCartButton();
		
		// Search and add the second product to the cart
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_ATOMIC_HABITSL);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		productDetailsPage.clickOnAddToCartButton();
		
		// Go to the cart page
		productDetailsPage.clickOnGoToCartButton();
		
		// Get initial cart count and subtotal amount
		int initialCartCount = Integer.parseInt(productDetailsPage.getCartCount());
		double initialSubTotalAmount =Double.parseDouble(checkoutPage.getSubTotalAmount());
		
		// Remove an item from the cart
		checkoutPage.clickOnDeleteItemButton();
		
		// Get final cart count and subtotal amount after removal
		int finalCartCount = Integer.parseInt(productDetailsPage.getCartCount());
		double finalSubTotalAmount =Double.parseDouble(checkoutPage.getSubTotalAmount());
		
		// Assertion for final cart count
		Assert.assertEquals(finalCartCount, initialCartCount - 1, "The final cart count is not decreased by one");
		
		// Assertion for final subtotal amount
		Assert.assertTrue(initialSubTotalAmount>finalSubTotalAmount,"The final sub total is not decremented after item removal");
		
	}

}
