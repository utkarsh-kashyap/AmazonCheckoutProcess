package com.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


/**
 * BaseClass for test suite setup.
 * Initializes WebDriver, baseURL, and waits based on configuration properties.
 */

public class BaseClass {
    protected static WebDriver driver;
    protected String baseURL;
    protected int waitTimeInSeconds;

    @BeforeSuite()
    public void beforeSuite() {
        DriverSetup.browserSetup(getProperty("browser"), getProperty("headless"));
        waitTimeInSeconds = Integer.parseInt(getProperty("waitTime"));
    }

    @BeforeClass
    public void beforeClass() {
    	// Initialize WebDriver and navigate to the baseURL
        driver = DriverSetup.getDriver();
        baseURL = getProperty("baseURL");
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSeconds));
        System.out.println("Successfully navigated to "+ baseURL);
    }

    @AfterSuite
    public void afterSuite() {
    	//Teardown method for WebDriver
        DriverSetup.quitDriver();
    }

    public String getProperty(String key) {
    	//Method to read properties from config
        Properties config = new Properties();
        FileInputStream fis = null;
        String value = null;

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\property\\config.properties");
            config.load(fis);
            value = config.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return value;
    }
}
