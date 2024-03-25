package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.CheckoutPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductDetailsPage;
import com.amazon.pages.ProductListingPage;
import com.setup.BaseClass;
import com.utilities.TestConstants;

public class NegativeTest extends BaseClass {

	AmazonHomePage amazonHomePage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailsPage;
	CheckoutPage checkoutPage;
	LoginPage loginPage;
	
	/*
     * Test method to verify error handling for empty shipping address fields.
     */
	
	@Test(priority = 1, enabled = true)
	public void verifyEmptyShippingAddressFieldsError() {

		// Instantiate page objects
		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage = new LoginPage(driver);
		
		/*
		 * This try block executes the test scenario to verify error handling for empty shipping address fields.
		 * It logs in, adds a product to the cart, proceeds to checkout, adds a new address, and verifies the error message.
		 * If any exception occurs during the execution, it is caught and handled.
		 */

		try {

			// Login to Amazon with valid email and password
			loginPage.loginWithEmailAndPassword(TestConstants.LOGIN_EMAIL, TestConstants.LOGIN_PASSWORD);
			
			// Search for a product and click on first search result
			amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
			amazonHomePage.clickOnSearchButton();
			productListingPage.clickOnFirstSearchResult();
			
			// Click on Buy Now Button
			productDetailsPage.clickOnBuyNowButton();
			
			// Click on change address and add new one
			checkoutPage.clickOnChangeAddressLink();
			checkoutPage.clickOnAddNewAddressLink();
			
			// Enter shipping address details
			checkoutPage.enterFullName(TestConstants.FULLNAME_AUTO);
			checkoutPage.enterPhoneNumebr(TestConstants.PHONE_NUMBER);
			checkoutPage.enterAddressLine1(TestConstants.ADDRESS_LINE1_TEST);
			checkoutPage.enterCity(TestConstants.CITY_SACRAMENTO);
			checkoutPage.selectStateOrProvince();
			checkoutPage.clickOnUseThisAddressLink();
			
			// Verify if error message is displayed for empty shipping address fields
			Assert.assertTrue(checkoutPage.isShippingAddressErrorDisplayed(), "Expected error message not displayed");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			
			// Handle any exception by printing the error message and marking the test as failed
			Assert.fail("Test failed: " + e.getMessage());
		}
	}
	
	/*
     * Test method to verify error handling for invalid promo codes.
     */
	
	@Test(priority = 2, enabled = true)
	public void verifyInvalidPromoCodeError() {

		// Instantiate page objects
		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage = new LoginPage(driver);
		
		/*
		 * This try block executes a test scenario where a gift code is entered during checkout.
		 * It verifies if the expected error message is displayed when an invalid gift code is applied.
		 * If any exception occurs during the execution, it prints out an error message and marks the test as failed.
		 */

		try {

			// Navigate to the Amazon home page
			amazonHomePage.navigatedToBaseURL();
			
			// Go to cart and proceed for checkout
			amazonHomePage.clickOnCartButton();
			productDetailsPage.clickOnProceedToCheckout();
			
			// Apply an invalid promo code
			checkoutPage.enterGiftCode(TestConstants.GIFTCODE_CODE);
			checkoutPage.clickOnApplyGiftCode();
			
			// Verify if error message is displayed for invalid promo code
			Assert.assertTrue(checkoutPage.isGiftCodeErrorDisplayed(), "Expected error message not displayed");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			
			// Handle any exception by printing the error message and marking the test as failed
			Assert.fail("Test failed: " + e.getMessage());
		}
	}

}
