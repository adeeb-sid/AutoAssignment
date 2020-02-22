package com.auto.listeners;

import static com.auto.page.InitializePage.features;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.auto.util.ExtentReportUtil;

public class TestListeners implements ITestListener {

	ExtentReportUtil extentReportUtil = new ExtentReportUtil();

	public void onFinish(ITestContext arg0) {
		extentReportUtil.FlushReport();
	}

	public void onStart(ITestContext arg0) {
		extentReportUtil.ExtentReport();
		features = extentReportUtil.extent.createTest(Feature.class, "Features");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult result) {
	}

	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestStart(ITestResult arg0) {

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
