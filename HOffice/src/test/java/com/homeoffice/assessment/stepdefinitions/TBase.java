package com.homeoffice.assessment.stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.Gson;
import com.homeoffice.assessment.data.VehicleInformation;
import com.homeoffice.assessment.files.AllFilesnotnull;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TBase {

    protected WebDriver driver;
    private boolean isInitialized;
    private FileInputStream fileInputStream;
    private Reader reader;
    public VehicleInformation[] allVehiclesInformation;
   


    @Before
    public void  initializeEnvironment(){
        if(!isInitialized) {
            File file = new File(System.getProperty("user.dir")+"//report.html");
            file.delete();
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            isInitialized = true;
            AllFilesnotnull excelToJSON = new AllFilesnotnull();
            excelToJSON.convertExcelToJsonTestData("Files", "sheet");
            try {
                fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\testdata\\Vehicle Information.json"));
                reader = new InputStreamReader(fileInputStream, "UTF8");
                allVehiclesInformation = new Gson().fromJson(reader, VehicleInformation[].class);
                fileInputStream.close();
                reader.close();
            } catch (Exception e){
                e.printStackTrace();
            }


        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public VehicleInformation[] getAllVehiclesInformation() {
        return allVehiclesInformation;
    }

    

   

    @After
    public void tearDownEnvironment(){
        driver.quit();
        
    }
}
