package com.juaracoding.cucumber.hooks;

import com.juaracoding.cucumber.utils.Browser;
import com.juaracoding.cucumber.utils.DriverSingleton;
import com.juaracoding.cucumber.utils.Screenshotutil;
import com.relevantcode.extentreports.ExtentReports;
import com.relevantcode.extentreports.ExtentTest;
import com.relevantcode.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.juaracoding.cucumber.utils.DateUtil.*;

public class Hooks {

    public static ExtentReports reports;
    public static ExtentTest extentTest;
    public static Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        DriverSingleton.setDriver(Browser.CHROME);
        String dateFolder = getTodayDateFolder();

        if (reports == null) {
            String reportPath = "target/reports/" + dateFolder + "/ExtentReportResults.html";
            reports = new ExtentReports(reportPath);
        }
        Hooks.scenario = scenario;
        extentTest = reports.startTest(scenario.getName());
    }

    @After
    public void endScenarioTest(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = Screenshotutil.takeScreenshot(DriverSingleton.getDriver(), scenario.getName());
            extentTest.log(LogStatus.FAIL, "Scenario Failed : " + scenario.getName());
            extentTest.log(LogStatus.FAIL,  extentTest.addScreenCapture(screenshotPath));
        } else {
            String screenshotPath = Screenshotutil.takeScreenshot(DriverSingleton.getDriver(), scenario.getName());
            extentTest.log(LogStatus.PASS, "Scenario Passed : " + scenario.getName());
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
        }// Add screenshot
        reports.endTest(extentTest);
        reports.flush();
        DriverSingleton.exit();
    }
}