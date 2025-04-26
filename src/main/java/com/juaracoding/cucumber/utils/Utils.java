package com.juaracoding.cucumber.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void delay (){
        try{
            Thread.sleep(second*2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static int tesCount = 0;
}