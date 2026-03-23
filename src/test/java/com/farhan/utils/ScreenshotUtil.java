package com.farhan.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    public static void takeScreenShot(WebDriver driver,String testName){
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);

        String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String path="screenshots/" +testName+ "_" +timestamp+ ".png";
        try{
            FileUtils.copyFile(src, new File(path));
            System.out.println("screenshot saved:"+path);
        }
        catch (IOException e){
            System.out.println("ScreenShot Failed: "+e.getMessage());

        }

    }
}
