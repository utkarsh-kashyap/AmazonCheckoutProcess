package com.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.logging.log4j.LogManager;

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

    public static void logPass(String message) {
        logger.info(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            extentTest.log(Status.PASS, message);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }

    public static void logFail(String message) {
        logger.error(message);
        ExtentTest extentTest = getExtentTest();
        if (extentTest != null) {
            extentTest.log(Status.FAIL, message);
        } else {
            throw new IllegalStateException("ExtentTest instance is not initialized.");
        }
    }
}
