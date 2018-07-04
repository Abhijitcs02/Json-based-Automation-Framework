package com.automation.pages;

import com.automation.core.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HomePage {
    public void method2(WebDriver driver){
        System.out.println("METHOD222222");

//        Runner.dataReserver.put("testdata1","DAtavalurana22222");
        DataManager.putDataReserverForNextTC("testdata1","DAytytyttyt11111");
        DataManager.putDataReserverForNextTC("testdataNEW","tytwer454545458989");
        DataManager.putDataForNotToBeSavedDataReserver("grr","rrrrrop");

//        ReportManager.CaptureScreen(driver,"test1");
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for

//        element.sendKeys(Runner.getSavedData.get("testdata1").toString());
        element.sendKeys(DataManager.getDataFromToBeSavedNextTC("testdata1"));

        BaseTest.logger.log(LogStatus.INFO, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
//        element.clear();

//        element.sendKeys(Runner.dataReserver.get("testdata1").toString());
        element.sendKeys(DataManager.getDataFromDataReserver("td1"));
        BaseTest.logger.log(LogStatus.INFO, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
//        element.clear();

        element.sendKeys(DataManager.getDataFromNotToBeSavedDataReserver("grr"));
        BaseTest.logger.log(LogStatus.INFO, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
//        element.clear();
//        DataManager.destroyNotToBeSavedData();
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
//          (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith(Runner.getSavedData.get("testdata1").toString());
//            }
//        });

        System.out.println("Page title is: " + driver.getTitle());

        String se = driver.getTitle();
//        Assert.assertEquals("fffff", "hjhjhhj");
        if(se.equalsIgnoreCase("random word fail test")){
            BaseTest.Status &= true;
            BaseTest.logger.log(LogStatus.PASS, "Passed the condition this");
            BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        }else {
            BaseTest.Status &= false;
            BaseTest.logger.log(LogStatus.FAIL, "Failed due to reason");
            BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        }
//        BaseTest.Status &= true;

//        String ss=ReportManager.CaptureScreen(driver,"test1");
//        BaseTest.logger.log(LogStatus.PASS, BaseTest.logger.addScreenCapture(ss));


    }

    public void method3(WebDriver driver){
        System.out.println("METHOD222222");
//        Runner.dataReserver.put("testdata2","uiuuipopop");
        DataManager.putDataReserverForNextTC("testdata2","uiuuipopop");
//        Assert.assertEquals("fffff", "hjhjhhj");
//        ReportManager.CaptureScreen(driver,"test1");
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
//        element.sendKeys(Runner.getSavedData.get("testdata2").toString());

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith(Runner.getSavedData.get("testdata2").toString());
//            }
//        });

        //BaseTest.test = BaseTest.extent.startTest("Secreenshot attch", "Verify HomePage");
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());


        BaseTest.logger.log(LogStatus.INFO, "Extent report successs");
        String se = driver.getTitle();

        if(se.equalsIgnoreCase("random word fail test")){
            BaseTest.Status &= true;
            BaseTest.logger.log(LogStatus.PASS, "Passed the condition this");
            BaseTest.logger.log(LogStatus.PASS, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        }else {
            BaseTest.Status &= false;
            BaseTest.logger.log(LogStatus.FAIL, "Failed due to reason");
            BaseTest.logger.log(LogStatus.FAIL, BaseTest.logger .addScreenCapture(HtmlReportManager.CaptureScreen(driver)));
        }


    }

    ////////////////////////////////////////////////////////////////


    public  void inboundShipmentClick(WebDriver driver) throws InterruptedException //Navigate to Inbound Shipment
    {
        WebElement menu = driver.findElement(By.xpath("//a[contains(@class,'page-menu-selector-expander')]"));
        menu.click();
        Thread.sleep(2000);
        WebElement inventory = driver.findElement(By.xpath("//span[text()='INVENTORY']"));
        inventory.click();
        Thread.sleep(2000);
        WebElement reciving = driver.findElement(By.xpath("//div[@class='menu-item root-item'][contains(text(),'RECEIVING')]"));
        reciving.click();
        Thread.sleep(2000);
        WebElement inboundShipment = driver.findElement(By.xpath("//a[text()='Inbound Shipments']"));
        inboundShipment.click();
        Thread.sleep(10000);
    }

    public void addInboundOrder(WebDriver driver) throws InterruptedException {
        driver.switchTo().frame("jdaIFrame-1536");
        WebElement inboundOrder = driver.findElement(By.xpath("//span[contains(text(),'Inbound Orders')]//parent::span[contains(@class,'x-btn-button')]"));
        inboundOrder.click();
        Thread.sleep(1000);
        WebElement action = driver.findElement(By.xpath("(//span[text()='Actions']//following-sibling::span[contains(@class,'x-btn-icon-el')])[2]"));
        action.click();
        Thread.sleep(1000);
        WebElement addInboundOrder = driver.findElement(By.xpath("//span[contains(text(),'Add Inbound Order')]"));
        addInboundOrder.click();
        Thread.sleep(2000);
        WebElement inboundOrders = driver.findElement(By.xpath("//input[@name='receiptNumber']"));


        GlobalSettings.order = genInbndOrdrNum();
        inboundOrders.sendKeys(GlobalSettings.order);
        Thread.sleep(2000);
        WebElement orderTypeDropdown = driver.findElement(By.xpath("//td[contains(@id,'wmReceivingOrderTypesCombo')]//following-sibling::td[@class=' x-trigger-cell x-unselectable']/div"));
        orderTypeDropdown.click();
        Thread.sleep(2000);
        WebElement clickInboundOrder = driver.findElement(By.xpath("//li[text()='Inbound Order']"));
        clickInboundOrder.click();
        Thread.sleep(2000);
        WebElement supplierLookUp = driver.findElement(By.xpath("//td[contains(@id,'supplierlookup')]//following-sibling::td[@class=' x-trigger-cell x-unselectable']/div"));
        supplierLookUp.click();
        Thread.sleep(2000);
        WebElement supplierClick = driver.findElement(By.xpath("(//td[@role='gridcell']/div[@class='x-grid-cell-inner ']/div[contains(text(),'SUP')])[1]"));
        supplierClick.click();
        Thread.sleep(2000);
        WebElement selectButton = driver.findElement(By.xpath("//span[text()='Select']//following-sibling::span"));
        selectButton.click();
        Thread.sleep(2000);
        WebElement rcptDatelookup = driver.findElement(By.xpath("//table[contains(@id,'datefield')][@class='x-form-trigger-wrap']//div[contains(@class,'x-form-date-trigger')]"));
        rcptDatelookup.click();
        Thread.sleep(4000);
        WebElement todaysDate = driver.findElement(By.xpath("//span[text()='Today'][@class='x-btn-inner x-btn-inner-center']//following-sibling::span"));
        todaysDate.click();
        Thread.sleep(4000);
        WebElement saveButton = driver.findElement(By.xpath("(//span[text()='Save']//following-sibling::span[contains(@id,'button')])[3]"));
        saveButton.click();
        Thread.sleep(2000);
    }

    public void addInboundOrderLine(WebDriver driver) throws InterruptedException {
        WebElement expectedQuantity = driver.findElement(By.xpath("//input[@name='expectedQuantity']"));
        expectedQuantity.sendKeys("1");
        Thread.sleep(2000);
        WebElement itemNumber = driver.findElement(By.xpath("//input[@name='itemNumber']"));
        itemNumber.sendKeys("12345");
        Thread.sleep(2000);
        WebElement itemSelect = driver.findElement(By.xpath("//div[contains(text(),'12345 - ----')]"));
        itemSelect.click();
        Thread.sleep(2000);

        WebElement nextLineCheckbox = driver.findElement(By.xpath("//label[text()='Add Next Line']//preceding-sibling::input[@role='checkbox']"));
        nextLineCheckbox.click();
        Thread.sleep(2000);
        WebElement saveButton = driver.findElement(By.xpath("(//span[text()='Save'][@class='x-btn-inner x-btn-inner-center']//following-sibling::span)[4]"));
        saveButton.click();
        Thread.sleep(2000);
        WebElement inboundOrder = driver.findElement(By.xpath("//span[contains(text(),'Inbound Order')][@class='x-header-text -text -text-default']"));
        WebElement backtoOrdr = driver.findElement(By.xpath("//a[@class='x-btn x-unselectable x-btn-default-small']//span[@class='x-btn-icon-el  ']"));
        backtoOrdr.click();
        Thread.sleep(4000);
        backtoOrdr.click();
        Thread.sleep(4000);


    }

    public void addInboundShipment(WebDriver driver) throws InterruptedException {
        WebElement action = driver.findElement(By.xpath("//span[text()='Actions']//following-sibling::span[contains(@class,'x-btn-icon-el')]"));
        action.click();
        Thread.sleep(1000);
        WebElement addInboundShip = driver.findElement(By.xpath("//span[text()='Add Inbound Shipment']"));
        addInboundShip.click();
        Thread.sleep(2000);
        WebElement inbndShipment = driver.findElement(By.xpath("//input[@name='masterReceiptId']"));

        GlobalSettings.ship = genInbndShipNum();
        inbndShipment.sendKeys(GlobalSettings.ship);
        Thread.sleep(2000);
        WebElement equipID = driver.findElement(By.xpath("//input[@name='trailerId']"));
        equipID.sendKeys("EQ00001");
        Thread.sleep(2000);
        WebElement clickequipID = driver.findElement(By.xpath("//li[text()='EQ00001']"));
        clickequipID.click();
        Thread.sleep(2000);
        WebElement receiptArea = driver.findElement(By.xpath("//input[@name='expectedReceiptArea']"));
        receiptArea.sendKeys("build");
        Thread.sleep(3000);
        WebElement clickreceiptArea = driver.findElement(By.xpath("//li[contains(text(),'Building 1')]"));
        clickreceiptArea.click();
        Thread.sleep(3000);
        WebElement saveButton = driver.findElement(By.xpath("(//span[text()='Save']//following-sibling::span)[3]"));
        saveButton.click();
        Thread.sleep(3000);
        WebElement backtoOrdr = driver.findElement(By.xpath("//a[@class='x-btn x-unselectable x-btn-default-small']//span[@class='x-btn-icon-el  ']"));
        backtoOrdr.click();
        Thread.sleep(2000);
    }

    public void mappingInboundShipment(WebDriver driver) throws InterruptedException {
        String inbShpmntLink = "//span[text()='%s']";
        String updatedXpath = String.format(inbShpmntLink, GlobalSettings.ship);
        List<WebElement> shpNumlist = driver.findElements(By.xpath(updatedXpath));

        if (shpNumlist.size() != 0) {
            WebElement shipmentNumber = driver.findElement(By.xpath(updatedXpath));
            shipmentNumber.click();
        } else {
            WebElement nextPage = driver.findElement(By.xpath("(//span[@class='x-btn-icon-el x-tbar-page-next x-btn-glyph'])[1]"));
            nextPage.click();
            Thread.sleep(4000);
            WebElement shipmentNumber = driver.findElement(By.xpath(updatedXpath));
            shipmentNumber.click();
        }
        //WebElement shipmentNumber = driver.findElement(By.xpath(updatedXpath));

        Thread.sleep(3000);
        WebElement actionClick = driver.findElement(By.xpath("(//span[text()='Actions']//following-sibling::span)[3]"));
        actionClick.click();
        Thread.sleep(2000);
        WebElement cpyInbndShip = driver.findElement(By.xpath("//span[text()='Copy Inbound Order to Shipment']"));
        cpyInbndShip.click();
        Thread.sleep(2000);
        String inbOrderLink = "//span[text()='%s']//parent::div//parent::td//preceding-sibling::td[contains(@class,'x-grid-cell-row-checker')]//div[@class='x-grid-row-checker']";
        updatedXpath = String.format(inbOrderLink, GlobalSettings.order);
        //WebElement orderNumberCheckBox = driver.findElement(By.xpath(updatedXpath));
        List<WebElement> ordNumlist = driver.findElements(By.xpath(updatedXpath));

        if (ordNumlist.size() != 0) {
            WebElement orderNumberCheckBox = driver.findElement(By.xpath(updatedXpath));
            orderNumberCheckBox.click();
        } else {
            WebElement nextPage = driver.findElement(By.xpath("(//span[@class='x-btn-icon-el x-tbar-page-next x-btn-glyph'])[3]"));
            nextPage.click();
            Thread.sleep(4000);
            WebElement orderNumberCheckBox = driver.findElement(By.xpath(updatedXpath));
            orderNumberCheckBox.click();
        }

        Thread.sleep(3000);
        WebElement addtoShipmentButton = driver.findElement(By.xpath("//span[text()='Add to Shipment']//following-sibling::span"));
        addtoShipmentButton.click();
        Thread.sleep(2000);
    }

    public void navigateToAppoinmentDoor(WebDriver driver) throws InterruptedException {
        driver.switchTo().defaultContent();
        WebElement menu = driver.findElement(By.xpath("//a[contains(@class,'page-menu-selector-expander')]"));
        menu.click();
        Thread.sleep(2000);
        WebElement appoinmentsClick = driver.findElement(By.xpath("//a[text()='Appointments']"));
        appoinmentsClick.click();
        Thread.sleep(2000);
        driver.switchTo().frame("jdaIFrame-1536");
        WebElement doorTab = driver.findElement(By.xpath("//span[text()='Doors']//following-sibling::span"));
        doorTab.click();
        Thread.sleep(3000);
    }

    public void createAppoinment(WebDriver driver) throws InterruptedException {

        WebElement appoClick = driver.findElement(By.xpath("(//div[@class='wm-click-target unavailable'])[1]"));
        appoClick.click();
        Thread.sleep(2000);
        WebElement carrierCode = driver.findElement(By.xpath("//input[@name='carrierCode']"));
        carrierCode.sendKeys("FDX");
        Thread.sleep(3000);
        WebElement clickCarrierFDX = driver.findElement(By.xpath("//li[text()='FDX']"));
        clickCarrierFDX.click();
        Thread.sleep(3000);
        WebElement trailerID = driver.findElement(By.xpath("//input[@name='trailerId']"));
        trailerID.sendKeys("IN");
        Thread.sleep(2000);
        WebElement clickTrailerId = driver.findElement(By.xpath("(//li[contains(text(),'FDX')][@class='x-boundlist-item'])[1]"));
        clickTrailerId.click();
        Thread.sleep(3000);
        WebElement saveButton = driver.findElement(By.xpath("(//span[text()='Save']//following-sibling::span)[4]"));
        saveButton.click();
        Thread.sleep(3000);
        WebElement yesButton = driver.findElement(By.xpath("//span[text()='Yes']//following-sibling::span"));
        yesButton.click();
        Thread.sleep(5000);

    }

    public void mappingAppoinment(WebDriver driver) throws InterruptedException {
        WebElement appoinmentClick = driver.findElement(By.xpath("(//div[@trailer-code='RCV'])[1]"));
        appoinmentClick.click();
        Thread.sleep(3000);
        WebElement checkINClick = driver.findElement(By.xpath("(//a[contains(text(),'Check In')])[1]"));
        checkINClick.click();
        Thread.sleep(4000);
        WebElement driverName = driver.findElement(By.xpath("//input[@name='driverName']"));
        driverName.sendKeys("QA");
        Thread.sleep(1000);
        WebElement licenseName = driver.findElement(By.xpath("//input[@name='driverName']"));
        licenseName.sendKeys("QA");
        Thread.sleep(1000);
        WebElement refName = driver.findElement(By.xpath("//input[@name='driverName']"));
        refName.sendKeys("QA");
        Thread.sleep(1000);
        WebElement appoCheckbox = driver.findElement(By.xpath("(//div[@trailer-code='RCV'])[2]//ancestor::tr[@class='  x-grid-data-row']/td/div[@class='x-grid-cell-inner ']//div[@class='x-grid-row-checker']"));
        appoCheckbox.click();
        Thread.sleep(2000);
        WebElement checkIn = driver.findElement(By.xpath("//span[text()='Check In']/following-sibling::span"));
        checkIn.click();
        Thread.sleep(3000);
    }


    public  String genInbndOrdrNum() {
        Random rand = new Random();
        int n = rand.nextInt(99999) + 1;
        String inb_Order = "INBORD" + n;
        return inb_Order;

    }


    public  String genInbndShipNum() {
        Random rand = new Random();
        int n = rand.nextInt(99999) + 1;
        String inb_Ship = "INBSHP" + n;
        return inb_Ship;

    }




}
