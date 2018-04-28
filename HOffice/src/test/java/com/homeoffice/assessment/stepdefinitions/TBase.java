package com.homeoffice.assessment.stepdefinitions;

import java.io.Reader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.homeoffice.assessment.data.VehicleInformation;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TBase {

	protected WebDriver driver;
	private boolean isInitialized;
	
	private Reader reader;
	public VehicleInformation[] allVehiclesInformation;

	@Before
	public void initializeEnvironment() {
		if (!isInitialized) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			

		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public VehicleInformation[] getAllVehiclesInformation() {
		return allVehiclesInformation;
	}

	@After
	public void tearDownEnvironment() {
		driver.quit();

	}
}
