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

public class UpdateShippingInfoTest extends BaseClass {

	AmazonHomePage amazonHomePage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailsPage;
	CheckoutPage checkoutPage;
	LoginPage loginPage;
	
	/*
     * Test method to verify if a user can update their shipping address during checkout successfully.
     */


	@Test(priority = 1, enabled = true)
	public void VerifyUserCanUpdateShippingInformation() {

		// Instantiate page objects
		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage = new LoginPage(driver);
		
		/*
		 * This section of code executes a test scenario where a user logs in, makes a purchase, and adds a new address during checkout.
		 * It verifies if the entered address details match the expected values after adding the new address.
		 */
		
		// Login with email and password
		loginPage.loginWithEmailAndPassword(TestConstants.LOGIN_EMAIL, TestConstants.LOGIN_PASSWORD);
		
		// Search for a product and proceed to buy now
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		productDetailsPage.clickOnBuyNowButton();
		
		// Proceed to checkout and add a new address
		checkoutPage.clickOnChangeAddressLink();
		checkoutPage.clickOnAddNewAddressLink();
		checkoutPage.enterFullName(TestConstants.FULLNAME_AUTO);
		checkoutPage.enterPhoneNumebr(TestConstants.PHONE_NUMBER);
		checkoutPage.enterAddressLine1(TestConstants.ADDRESS_LINE1_TEST);
		checkoutPage.enterCity(TestConstants.CITY_SACRAMENTO);
		checkoutPage.selectStateOrProvince();
		checkoutPage.enterZipCode(TestConstants.ZIPCODE_94203);
		checkoutPage.clickOnUseThisAddressLink();
		
		// Assertion for the full name in the new address
		Assert.assertEquals(TestConstants.FULLNAME_AUTO, checkoutPage.getFullNameFromAddress(),"Assertion Failed for new address Full Name");
		
		// Assertion for the address line 1 in the new address
		Assert.assertEquals(TestConstants.ADDRESS_LINE1_TEST, checkoutPage.getAddressLine1FromAddress(),"Assertion Failed for new address");
	}
}
