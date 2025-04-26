package com.juaracoding.cucumber.utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import com.juaracoding.cucumber.utils.DateUtil.*;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String scenarioName) {
        // Generate the screenshot file name
        String timestamp = getTimeStamp();
        String dateFolder = getTodayDateFolder();
        String screenshotName = scenarioName.replaceAll(" ", "_")+ "_" + timestamp + ".png";

        // Define the directory to save the screenshot
        String directoryPath = "target/report/" + dateFolder + "/screenshots/";
        String fullPath = directoryPath + screenshotName;

        try{
            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            // Take the screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,  new File(fullPath)); // Copy the screenshot to the destination

            // Return the absolute path of the saved screenshot
            return "screenshots/" + screenshotName;

        } catch (IOException e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
            return null
        }

    }

}