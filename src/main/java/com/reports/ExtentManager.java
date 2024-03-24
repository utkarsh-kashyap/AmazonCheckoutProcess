package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance("test-output/Test-Report-Extent.html");
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
    	ExtentSparkReporter spark = new ExtentSparkReporter(fileName).viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST}).apply();
        spark.config().setDocumentTitle("Amazon Process Testing");
        spark.config().setReportName("Test Report");
        spark.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }
}
