package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ReusableMethods;

public class CheckoutPage {
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@data-action='delete'])[1]")
	private WebElement itemDeleteButton;
	
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']/child::*[1]")
	private WebElement subTotal;
	
	@FindBy(xpath = "//a[@id='addressChangeLinkId']")
	private WebElement changeAddressLink;
	
	@FindBy(xpath = "//a[@id='add-new-address-popover-link']")
	private WebElement addNewAddressLink;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	private WebElement fullName;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
	private WebElement addressLine1;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	private WebElement city;
	
	@FindBy(xpath = "//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@data-action='a-dropdown-button']")
	private WebElement state;
	
	@FindBy(xpath = "//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_5' and @class='a-dropdown-link']")
	private WebElement california;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	private WebElement zipCode;
	
	@FindBy(xpath = "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	private WebElement useThisAddressButton;
	
	@FindBy(xpath = "//li[@class='displayAddressLI displayAddressFullName']")
	private WebElement li_FullName;
	
	@FindBy(xpath = "//li[@class='displayAddressLI displayAddressAddressLine1']")
	private WebElement li_AddressLine1;
	
	public void clickOnDeleteItemButton() {
		ReusableMethods.clickElement(itemDeleteButton, "Delete Item Button");
	}
	
	public String getSubTotalAmount() {
		String valueWithDollar=ReusableMethods.getElementText(subTotal, "Sub Total");
		String value = valueWithDollar.replaceAll("\\$", "");
		return value;
	}
	
	public void refreshCheckoutPage() {
		driver.navigate().refresh();
	}
	
	public void clickOnChangeAddressLink() {
		ReusableMethods.clickElement(changeAddressLink, "Change Address Link");
	}
	
	public void clickOnAddNewAddressLink() {
		ReusableMethods.clickElement(addNewAddressLink, "Add New Address");
	}
	
	public void enterFullName(String str) {
		ReusableMethods.clearText(fullName, "Full Name");
		ReusableMethods.enterText(fullName, str, "Full Name");
	}
	
	public void enterPhoneNumebr(String str) {
		ReusableMethods.enterText(phoneNumber, str, "Phone Number");
	}
	
	public void enterAddressLine1(String str) {
		ReusableMethods.enterText(addressLine1, str, "AddressLine");
	}
	
	public void enterCity(String str) {
		ReusableMethods.enterText(city, str, "City");
	}
	
	public void selectStateOrProvince() {
		ReusableMethods.clickElement(state, "State");
		ReusableMethods.clickElement(california, "California");
	}
	
	public void enterZipCode(String str) {
		ReusableMethods.enterText(zipCode, str, "Zip Code");
	}
	
	public void clickOnUseThisAddressLink() {
		ReusableMethods.clickElement(useThisAddressButton, "Use This Address Link");
	}
	
	public String getFullNameFromAddress() {
		return ReusableMethods.getElementText(li_FullName, "Full Name");
	}
	
	public String getAddressLine1FromAddress() {
		return ReusableMethods.getElementText(li_AddressLine1, "Address Line 1");
	}

}
