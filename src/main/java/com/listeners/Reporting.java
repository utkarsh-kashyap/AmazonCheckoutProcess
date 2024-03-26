package com.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.setup.BaseClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reporting {

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest test) {
    	 if (!(test == null)) {
    		 extentTestThreadLocal.set(test);
    	 }
    }

    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Reporting.class);

    public static void logInfo(String message) {
        logger.info(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            extentTest.log(Status.INFO, message);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }
    
    public static void logSkip(String message) {
        logger.info(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
        	String formattedMessage = "<b><font color='yellow'>" + message + "</font></b>";
            extentTest.log(Status.SKIP, formattedMessage);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }

    public static void logPass(String message) {
        logger.info(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
        	String formattedMessage = "<b><font color='green'>" + message + "</font></b>";
            extentTest.log(Status.PASS, formattedMessage);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }

    public static void logFail(String message) {
        logger.error(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
        	String formattedMessage = "<b><font color='red'>" + message + "</font></b>";
            extentTest.log(Status.FAIL, formattedMessage);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }
    
    public static void attachScreenshot() {
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            WebDriver driver = BaseClass.driver; // Assuming you have a method to get WebDriver instance
            if (driver instanceof TakesScreenshot) {
                // Capture screenshot
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                // Create screenshots directory if not exists
                createDirectoryIfNotExists("screenshots");
                // Define screenshot path
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String screenshotPath = "screenshots/" + timestamp + ".png";
                // Save the screenshot to the defined path and Add screenshot to the extent report
                try {
                	Files.copy(screenshotFile.toPath(), Paths.get(screenshotPath));
                    // Convert screenshot to Base64 string
                    String screenshotBase64 = convertToBase64(screenshotFile);
                    extentTest.fail("Click on base64 img to view screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
                } catch (Exception e) {
                	logger.error("Failed to attach screenshot to extent report: " + e.getMessage());
                }
            } else {
            	logger.error("WebDriver does not support taking screenshots.");
            }
        } else {
        	logger.error("ExtentTest instance is not initialized.");
        }
    }
    
    private static String convertToBase64(File file) {
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            logger.error("Failed to convert screenshot to Base64: " + e.getMessage());
            return null;
        }
    }

    private static void createDirectoryIfNotExists(String directoryPath) {
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
            	logger.error("Failed to create directory: " + e.getMessage());
            }
        }
    }
}
