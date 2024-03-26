package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.reports.ExtentManager;

public class ListenerClass implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        Reporting.setExtentTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporting.logPass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporting.logFail("Test failed");
        Reporting.attachScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporting.logSkip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
