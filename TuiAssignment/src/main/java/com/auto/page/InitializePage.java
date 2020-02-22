package com.auto.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.Scenario;

public class InitializePage {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(InitializePage.class);
	public static WebDriverWait wait = null;

	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;

	public static LandingPage landingPage = null;
    public static AuthenticationPage authenticationPage = null;
    public static AccountsPage accountsPage = null;
    public static CartSummaryPage cartSummaryPage = null;
    public static DressesPage dressesPage = null;

	public void setUp(Scenario scenario) {

		if (driver == null) {

			String browser = System.getProperty("browserName");

			if (browser == null || ("").equals(browser.trim())) {
				browser = "chrome";
			}

			log.info("Launcing browser : " + browser);

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				log.error("Error in finding configuration file" + e.getMessage());
			}
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				log.error("Error in loading configuration file" + e.getMessage());
			}

			if ("firefox".equals(browser)) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if ("chrome".equals(browser)) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if ("edge".equals(browser)) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir").concat("\\src\\test\\resources\\executables\\msedgedriver.exe"));
				driver = new EdgeDriver();
			} else {
				log.debug("Browser not supported : " + browser);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);
			scenarioDef = features.createNode(scenario.getName());
			
			landingPage = new LandingPage(driver);
			authenticationPage = new AuthenticationPage(driver);
			accountsPage = new AccountsPage(driver);
			cartSummaryPage = new CartSummaryPage(driver);
			dressesPage = new DressesPage(driver);
		}
	}

	public void tearDown(Scenario scenario) {
		if (scenario.isFailed() && driver != null) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String screenshot = System.getProperty("user.dir") + "\\ScreenShot\\screenshot_"
						+ Calendar.getInstance().getTimeInMillis() + ".png";
				FileUtils.copyFile(src, new File(screenshot));
				scenarioDef.fail("details").addScreenCaptureFromPath(screenshot);
			} catch (IOException exception) {
				log.error("Error in crrating screenshot : " + exception.getMessage());
			}
		}

		if (driver != null) {
			log.info("Quitting driver");
			driver.quit();
			driver = null;
		}
	}

	public void createScenarioDefNode(String keyWord, String stepName) {

		try {
			scenarioDef.createNode(new GherkinKeyword(keyWord), stepName);
		} catch (ClassNotFoundException e) {
			log.error("Error in creating scenario definition node for extent report" + e.getMessage());
		}
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
