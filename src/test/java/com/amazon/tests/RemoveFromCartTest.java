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

	@Test(priority = 1, enabled = true)
	public void verifyUserCanRemoveItemFromCart() {

		amazonHomePage = new AmazonHomePage(driver);
		productListingPage = new ProductListingPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);

		amazonHomePage.navigatedToBaseURL();
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_CLOUD_ATLAS);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		productListingPage.switchToProductDetailPageWindow();
		productDetailsPage.clickOnAddToCartButton();
		amazonHomePage.enterProductNameInSearchBox(TestConstants.PRODUCT_NAME_GONE_GIRL);
		amazonHomePage.clickOnSearchButton();
		productListingPage.clickOnFirstSearchResult();
		productListingPage.switchToProductDetailPageWindow();
		productDetailsPage.clickOnAddToCartButton();
		productDetailsPage.clickOnGoToCartButton();
		
		int initialCartCount = Integer.parseInt(productDetailsPage.getCartCount());
		double initialSubTotalAmount =Double.parseDouble(checkoutPage.getSubTotalAmount());
		
		checkoutPage.clickOnDeleteItemButton();
		
		int finalCartCount = Integer.parseInt(productDetailsPage.getCartCount());
		double finalSubTotalAmount =Double.parseDouble(checkoutPage.getSubTotalAmount());
		
		//checkoutPage.refreshCheckoutPage();
		Assert.assertEquals(finalCartCount, initialCartCount - 1, "The final cart count is not decreased by one");
		Assert.assertTrue(initialSubTotalAmount>finalSubTotalAmount,"The final sub total is not decremented after item removal");
		
	}

}
