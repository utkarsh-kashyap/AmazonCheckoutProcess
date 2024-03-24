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

	@Test(priority = 1, enabled = true)
	public void VerifyUserCanUpdateShippingInformation() {

		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage = new LoginPage(driver);
		
		loginPage.loginWithEmailAndPassword(TestConstants.LOGIN_EMAIL, TestConstants.LOGIN_PASSWORD);
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		productDetailsPage.clickOnBuyNowButton();
		checkoutPage.clickOnChangeAddressLink();
		checkoutPage.clickOnAddNewAddressLink();
		checkoutPage.enterFullName(TestConstants.FULLNAME_AUTO);
		checkoutPage.enterPhoneNumebr(TestConstants.PHONE_NUMBER);
		checkoutPage.enterAddressLine1(TestConstants.ADDRESS_LINE1_TEST);
		checkoutPage.enterCity(TestConstants.CITY_SACRAMENTO);
		checkoutPage.selectStateOrProvince();
		checkoutPage.enterZipCode(TestConstants.ZIPCODE_94203);
		checkoutPage.clickOnUseThisAddressLink();
		
		Assert.assertEquals(TestConstants.FULLNAME_AUTO, checkoutPage.getFullNameFromAddress(),"Assertion Failed for new address Full Name");
		Assert.assertEquals(TestConstants.ADDRESS_LINE1_TEST, checkoutPage.getAddressLine1FromAddress(),"Assertion Failed for new address");
	}
}
