package com.juaracoding.cucumber.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDrivers;
import org.openqa.selenium.firefox.FireFaxOption;

public class FirefoxManager {
    public static WebDriver buildDriver(){
        FirefoxOption options = new FirefoxOption();
        options.addArguments("--start-maximized");

        return new FirefoxDriver(options);
    }
}