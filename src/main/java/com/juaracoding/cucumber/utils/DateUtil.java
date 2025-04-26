package com.juaracoding.cucumber.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static  String getTodayDateFolder(){
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }
    public static String getTimeStamp(){
        return new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
    }
}