package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ReusableMethods;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement navAccountList;
	
	@FindBy(xpath = "(//span[normalize-space()='Sign in'])[1]")
	private WebElement signInButton;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement login;
	
	@FindBy(xpath = "//a[@id='ap-account-fixup-phone-skip-link']")
	private WebElement notNowLink;
	
	private void hoverOverSignInButton() {
		ReusableMethods.moveToElement(navAccountList, "Sign In Button");
	}
	
	private void clickOnSignInButton() {
		ReusableMethods.clickElement(signInButton, "Sign In Button");
	}
	
	private void enterEmail(String password) {
		ReusableMethods.enterText(emailField, password, "Email Field");
	}
	
	private void clickOnContinueButton() {
		ReusableMethods.clickElement(continueButton, "Continue Button");
	}
	
	private void enterPassword(String password) {
		ReusableMethods.enterText(passwordField, password, "Password Field");
	}
	
	private void clickOnNotNowLink() {
		ReusableMethods.clickElement(notNowLink, "Not Now Link");
	}
	
	private void clickOnLoginButton() {
		ReusableMethods.clickElement(login, "LoginIn");
	}
	
	public void loginWithEmailAndPassword(String email, String password) {
		hoverOverSignInButton();
		clickOnSignInButton();
		enterEmail(email);
		clickOnContinueButton();
		enterPassword(password);
		clickOnLoginButton();
		try {
			clickOnNotNowLink();
		} catch (Exception e) {
			System.out.println("Add Mobile Number Message Not Present while Login");
		}
	}

}
