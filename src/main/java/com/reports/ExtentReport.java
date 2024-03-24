package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReport {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void startTest(String testName, String description) {
        ExtentTest extentTest = extent.createTest(testName, description);
        test.set(extentTest);
    }

    public static void logStatus(Status status, String message) {
        test.get().log(status, message);
    }

    public static void flushReport() {
        extent.flush();
    }
}
