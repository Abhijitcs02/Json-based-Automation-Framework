package com.automation.pages;

import com.automation.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class LoginPage {
    public void navigateToLogin() {
        System.out.println(Runner.globalSettings.get("wms.url"));
        Assert.assertEquals("fffff", "hjhjhhj");
        System.out.println("Navigatetologin------.............");
    }

    public void login(WebDriver driver) throws Exception {
//        Runner.dataReserver.put("testdata3","val1");
//        driver.findElement(By.id("id"));
        System.out.println("login------.............");
        DataManager.putDataReserverForNextTC("testdataNEWDATASAME","tytwer454545458989333333333333333344DONE");
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        BaseTest.logger.log(LogStatus.PASS, DataManager.getTestData("outbound:testcase1.json").get("td1").toString());
    }

    public void method1(WebDriver driver)  {

        System.out.println("METHOD11111");
//        Runner.dataReserver.put("testdata4","testing");
        WebElement element = driver.findElement(By.name("q"));
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        // Enter something to search for
//        element.sendKeys(Runner.getSavedData.get("testdata4").toString());
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith(Runner.getSavedData.get("testdata4").toString());
//            }
//        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        BaseTest.logger.log(LogStatus.INFO, "Extent report successs");
        String se = driver.getTitle();

        BaseTest.Status &= true;
        BaseTest.logger.log(LogStatus.PASS, "Passed the condition this");
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
//        if(se.equalsIgnoreCase("random word fail test")){
//            ApplicationSettings.Status &= true;
//            BaseTest.logger.log(LogStatus.PASS, "Passed the condition this");
//            BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(ReportManager.CaptureScreen(driver,"imagepass")));
//        }else {
//            ApplicationSettings.Status &= false;
//            BaseTest.logger.log(LogStatus.FAIL, "Failed due to reason");
//            BaseTest.logger.log(LogStatus.FAIL, BaseTest.logger .addScreenCapture(ReportManager.CaptureScreen(driver,"imagefail")));
//        }
        BaseTest.Status &= true;
    }


    ////////////////////////////////////////////////////////////////


    public void applicationLogin(WebDriver driver) throws Exception  //Login
    {
        Thread.sleep(10000);
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='loginButton']"));
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));

        userName.sendKeys("jdatest");
        Thread.sleep(1000);
        password.sendKeys("jdatest");
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(5000);
    }

    // NTS Application Testing
    public void NTSapplicationLogin(WebDriver driver) throws Exception  //Login
    {
        BaseTest.logger.log(LogStatus.INFO, "NTS App URL LAUNCHED");
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger.addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        driver.findElement(By.cssSelector("#nav-bar>div.top-nav.hidden-xs.hidden-sm>span")).click();
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger.addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        driver.findElement(By.xpath("//input[@type='email']")).clear();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abhijit.mukherjee@nike.com");
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger.addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Nike1234");
        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger.addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        driver.findElement(By.xpath("//input[@value='LOG IN']")).click();
        //*[@id="nav-bar"]/div[1]/div[2]
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='nav-bar']/div[1]/div[2]")));
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'abhijit.mukherjee@nike.com')]")));
        String t=driver.findElement(By.xpath("//div[contains(text(),'abhijit.mukherjee@nike.com')]")).getText();
        if(t.equalsIgnoreCase("abhijit.mukherjee@nike.com")){
            BaseTest.logger.log(LogStatus.PASS, BaseTest.logger.addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        }
        else {
            BaseTest.logger.log(LogStatus.FAIL, BaseTest.logger.addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        }
    }


}
