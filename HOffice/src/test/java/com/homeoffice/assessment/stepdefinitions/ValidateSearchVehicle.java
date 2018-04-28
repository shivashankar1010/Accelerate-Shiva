package com.homeoffice.assessment.stepdefinitions;

import java.io.FileReader;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.homeoffice.assessment.data.VehicleInformation;
import com.homeoffice.assessment.vehiclepageobjects.VDetailsPage;
import com.homeoffice.assessment.vehiclepageobjects.VEnquiryPage;
import com.homeoffice.assessment.vehiclepageobjects.VLandingPage;
import com.opencsv.CSVReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ValidateSearchVehicle {

	private WebDriver driver;
	private TBase testBase;
	private VLandingPage vehicleInformationLandingPage;
	private VEnquiryPage vehicleEnquiryPage;
	private VDetailsPage vehicleDetailsPage;
	private VehicleInformation[] allVehicles;
	String CSV_file = System.getProperty("user.dir")+"\\src\\test\\resources\\ATestData.csv";

	public ValidateSearchVehicle(TBase testBase) {
		this.testBase = testBase;
		this.driver = testBase.getDriver();
		this.allVehicles = testBase.getAllVehiclesInformation();
	}

	@When("^I Start the process of searching for vehicle details$")
	public void i_Start_the_process_of_searching_for_vehicle_details() throws Throwable {
		vehicleInformationLandingPage = new VLandingPage(driver);
		vehicleEnquiryPage = vehicleInformationLandingPage.navigateToVehicleEnquiryPage();

	}

	@And("^I enter the vehicle registration number and submit to validate the details$")
	public void i_enter_the_vehicle_registration_number_and_submit() throws Throwable {
		
		
		 

		CSVReader reader = new CSVReader(new FileReader(CSV_file));
		String[] cell;
		while ((cell = reader.readNext()) != null) {

			vehicleEnquiryPage.enterVehicleRegistrationNumber(cell[0]);
			vehicleDetailsPage = vehicleEnquiryPage.submitVehicleDetailsSearchRequest();

			String vehicleRegistrationFromApplication = vehicleDetailsPage.getVehicleRegistrationNumber();
			String vehicleMakeFromApplication = vehicleDetailsPage.getMake();
			String vehicleColourFromApplication = vehicleDetailsPage.getColour();
			System.out.println("vehcile vehicleRegistrationFromApplication is  csv " + cell[0]);
			System.out.println("vehcile vehicleMakeFromApplication is  csv " + cell[1]);
			System.out.println("vehcile vehicleColourFromApplication is  csv " + cell[2]);
			System.out.println("vehcile number is   " + vehicleRegistrationFromApplication);
			System.out.println("vehcile number is   " + vehicleMakeFromApplication);
			System.out.println("vehcile number is   " + vehicleColourFromApplication);

			Assert.assertTrue(vehicleRegistrationFromApplication.equals(cell[0]));
			Assert.assertTrue(vehicleMakeFromApplication.equals(cell[1]));
			Assert.assertTrue(vehicleColourFromApplication.equals(cell[2]));
			driver.navigate().to("https://vehicleenquiry.service.gov.uk/");

		}
	}

}
