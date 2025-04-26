package com.juaracoding.cucumber.strategies;

import com.juaracoding.cucumber.utils.Browser;
import com.juaracoding.cucumbermanager.ChromeManager;
import com.juaracoding.cucumbermanager.FirefoxManager;
import org.openqa.selenium.WebDriver;

public class DriverStrategies  {
    public static WebDriver setStrategy(String browser) {
        if (browser.equals(Browser.CHROME)) {
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        } else {
            return ChromeManager.buildDriver();
        }
    }
}