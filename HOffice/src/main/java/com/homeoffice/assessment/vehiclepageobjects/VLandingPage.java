package com.homeoffice.assessment.vehiclepageobjects;

import com.homeoffice.assessment.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VLandingPage {

    private WebDriver driver;
    private static final By startButtonLocator = By.cssSelector("a[class$='pub-c-button--start']");

    public VLandingPage(WebDriver driver) {
        this.driver = driver;
    }


    public VEnquiryPage navigateToVehicleEnquiryPage(){
        Utility.linkOrButtonClick(driver, startButtonLocator);
        return new VEnquiryPage(driver);
    }

}
