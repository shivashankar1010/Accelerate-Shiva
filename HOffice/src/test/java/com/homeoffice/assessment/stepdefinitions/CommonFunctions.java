package com.homeoffice.assessment.stepdefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonFunctions {


    private WebDriver driver;
    private TBase testBase;

    public CommonFunctions(TBase testBase) {
        this.testBase = testBase;
        driver = testBase.getDriver();
    }


    @Given("^I launch the government DVLA URL$")
    public void i_launch_the_government_DVLA_URL() throws Throwable {
        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
    }


}