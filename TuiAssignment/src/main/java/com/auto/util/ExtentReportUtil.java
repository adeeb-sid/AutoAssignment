package com.auto.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.auto.page.InitializePage;

public class ExtentReportUtil extends InitializePage {

	Logger log = LogManager.getLogger(ExtentReportUtil.class);

	private String fileName = System.getProperty("user.dir") + "\\Report\\extentreport.html";

	public void ExtentReport() {
		extent = new ExtentReports();

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(this.fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Automation Tests");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Report");
		extent.attachReporter(htmlReporter);
	}

	public void FlushReport() {
		extent.flush();
	}

}
