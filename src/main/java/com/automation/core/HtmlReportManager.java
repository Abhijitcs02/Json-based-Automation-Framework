package com.automation.core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by 543175 on 2/16/2018.
 */
public class HtmlReportManager {
    public static long val=0;
    public static ExtentReports Instance()
    {
        ExtentReports extent;
        String Path = "./ExtentReport.html";
        System.out.println(Path);
        extent = new ExtentReports(Path, false);
        extent.loadConfig(new File("extent-config.xml"));

        return extent;
    }
    public static String CaptureScreen(WebDriver driver)
    {
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        val++;
        File oDest = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Report_Images\\"+"\\img"+val+
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {System.out.println(e.getMessage());}


        return System.getProperty("user.dir")+"\\src\\test\\resources\\Report_Images\\"+"img"+val+
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+".jpg";
    }
}
