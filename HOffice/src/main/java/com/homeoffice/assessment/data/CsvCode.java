package com.homeoffice.assessment.data;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.CSVReader;

public class CsvCode {

	String CSV_file = "C:\\Users\\SHIVA\\Desktop\\ATestData.csv";

	@Test

	public void AssertMake() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(CSV_file));
		String[] cell;
		while ((cell = reader.readNext()) != null) {
			for (int i = 0; i < 3; ++i) {
				String DataSent = cell[i];
				String ExpectedMake = DataSent;
				// String ActualMake = driver.findElement(VehicleMake).getText();
				// Assert.assertEquals(ExpectedMake, ActualMake);
				System.out.println("text is  "+ExpectedMake);

			}
		}

	}

}
