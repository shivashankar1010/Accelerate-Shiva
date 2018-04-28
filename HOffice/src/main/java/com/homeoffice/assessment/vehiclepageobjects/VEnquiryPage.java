package com.homeoffice.assessment.vehiclepageobjects;

import com.homeoffice.assessment.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VEnquiryPage {

    private WebDriver driver;
    private static final By enterVehicleRegistrationNumberInputLocator = By.id("Vrm");
    private static final By continueButtonLocator = By.name("Continue");


    public VEnquiryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterVehicleRegistrationNumber(String vehicleREgistrationNumber){
        Utility.enterTextInTextBox(driver, enterVehicleRegistrationNumberInputLocator, vehicleREgistrationNumber);
    }

    public VDetailsPage submitVehicleDetailsSearchRequest(){
        Utility.linkOrButtonClick(driver, continueButtonLocator);
        return new VDetailsPage(driver);
    }
}
