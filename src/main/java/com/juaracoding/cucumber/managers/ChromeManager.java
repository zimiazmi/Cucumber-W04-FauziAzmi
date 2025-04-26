package com.juaracoding.cucumber.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeManager {

    public static WebDriver buildDriver() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //return new ChromeDriver(options);
        options.addArguments("--disable-blink-features-AutomationControlled");
        options.addArguments("--disable-password-generation");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs =  new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.default_content_setting_values.notifications",2);
        prefs.put("profile.default_content_setting_values.popups",2);

        options.setExperimentalOption("prefs",prefs);

        return  new ChromeDriver(options);

    }
}