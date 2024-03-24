package com.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.Reporter;

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

    public static void logInfo(String message) {
        Reporter.log(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            extentTest.log(Status.INFO, message);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }

    public static void logPass(String message) {
        Reporter.log(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            extentTest.log(Status.PASS, message);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }

    public static void logFail(String message) {
        Reporter.log(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            extentTest.log(Status.FAIL, message);
            Assert.fail(message);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }
}
