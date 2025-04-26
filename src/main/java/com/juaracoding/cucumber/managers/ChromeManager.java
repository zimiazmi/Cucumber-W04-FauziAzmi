package com.juaracoding.cucumber.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeManager {

    public static WebDriver buildDriver() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //return new ChromeDriver(options);
        options.addArguments("--disable-blink-features-AutomationControlled");
        options.addArguments("--disable-password-generation");
        options.addArguments("--disable-save-password-bubble");

        Maps<String, Object> prefs =  new HasMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.default_content_setting_values.notifications",false);
        prefs.put("profile.default_content_seeting_values.popups",false);

        options.setExperimentalOption("Prefs",prefs);

        return  new ChrmeDriver(options);

    }
}