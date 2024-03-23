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

public class BaseClass {
    protected static WebDriver driver;
    protected String baseURL;
    protected int waitTimeInSeconds;

    @BeforeSuite
    public void beforeSuite() {
        DriverSetup.browserSetup(getProperty("browser"), getProperty("headless"));
        waitTimeInSeconds = Integer.parseInt(getProperty("waitTime"));
    }

    @BeforeClass
    public void beforeClass() {
        driver = DriverSetup.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSeconds));
        baseURL = getProperty("baseURL");
    }

    @AfterSuite
    public void afterSuite() {
        DriverSetup.quitDriver();
    }

    public String getProperty(String key) {
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
