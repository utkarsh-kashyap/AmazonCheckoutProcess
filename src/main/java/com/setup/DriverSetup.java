package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {
    public static WebDriver driver;
    
    /**
     * Sets up the WebDriver instance for the specified browser with or without headless mode.
     * @param browser The browser to be used (chrome, firefox, edge).
     * @param headless Whether to run in headless mode (true/false).
     */

    public static void browserSetup(String browser, String headless) {
        switch (browser.toLowerCase()) {
            case "chrome":
            	//Google Chrome Browser setup with headless option
                if (headless.equalsIgnoreCase("true")) {
                	//WebDriverManager.chromedriver().setup();
                   ChromeOptions chromeOptions = new ChromeOptions();
                   
                   chromeOptions.addArguments("--headless=new");
                   driver = new ChromeDriver(chromeOptions);
                }
              //Google Chrome Browser setup without headless option
                else {
                	//WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                break;
            case "firefox":
            	//Mozilla Firefox Browser setup with headless option
            	if (headless.equalsIgnoreCase("true")) {
                	//WebDriverManager.firefoxdriver().setup();
                   FirefoxOptions firefoxOptions = new FirefoxOptions();
                   
                   firefoxOptions.addArguments("-headless");
                    driver = new FirefoxDriver(firefoxOptions);
                }
            	//Mozilla Firefox Browser setup without headless option
                else {
                	//WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                break;
            case "edge":
                // Microsoft Edge Browser setup with headless option
            	if (headless.equalsIgnoreCase("true")) {
                	//WebDriverManager.edgedriver().setup();
                   EdgeOptions edgeOptions = new EdgeOptions();
                   
                   edgeOptions.addArguments("--headless");
                   driver = new EdgeDriver(edgeOptions);
                }
            	// Microsoft Edge Browser setup without headless option
                else {
                	//WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call browserSetup() before using this method.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
