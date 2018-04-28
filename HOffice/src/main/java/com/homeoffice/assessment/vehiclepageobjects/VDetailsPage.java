package com.homeoffice.assessment.vehiclepageobjects;

import com.homeoffice.assessment.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VDetailsPage {

    private WebDriver driver;
    private static final By registrationNumberValueLocator = By.xpath("//*[@id='pr3']/div/ul/li[1]/span[2]");
    private static final By makeValueLocator = By.xpath("//*[@id='pr3']/div/ul/li[2]/span[2]/strong");
    private static final By colourValueLocator = By.xpath("//*[@id='pr3']/div/ul/li[3]/span[2]/strong");


    public VDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getVehicleRegistrationNumber(){
        return Utility.returnWebElement(driver, registrationNumberValueLocator).getText();
    }

    public String getMake(){
        return Utility.returnWebElement(driver, makeValueLocator).getText();

    }

    public String getColour(){
        return Utility.returnWebElement(driver, colourValueLocator).getText();
    }
}
