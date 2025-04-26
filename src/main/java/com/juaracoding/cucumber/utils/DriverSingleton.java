package com.juaracoding.cucumber.utils;

import com.juaracoding.cucumber.strategies.DriverStrategies;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            throw new IllegalStateException("Driver not initialized");
        }

        return driver;

    }

    public static void setDriver(String browser){
        if (driver == null){
            driver = DriverStrategies.setStrategy(browser);
        }
    }


    public static void exit(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}