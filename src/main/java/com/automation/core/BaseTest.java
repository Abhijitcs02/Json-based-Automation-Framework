package com.automation.core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.automation.core.ExcelReader.ExecutionMngrMap;

public class BaseTest {
    WebDriver driver;
    public static Boolean Status =true;
    public Runner runner = new Runner();
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeSuite
    public void beforeSuit() throws Exception{
        ExcelReader excelReader = new ExcelReader();
        excelReader.readExcel();
        extent = HtmlReportManager.Instance();
    }

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() throws Exception{

        runner.initTest();
//        DataManager.setSavedDataForNextTC(new JsonLib().
//                jsonToMap(ApplicationSettings.TEST_RESOURCE_PATH +
//                        ApplicationSettings.path +ApplicationSettings.file));
        Status =true;

    }

    @AfterMethod
    public void getResult(ITestResult result){
//        if(result.getStatus() == ITestResult.FAILURE){
//            String ss=ReportManager.CaptureScreen(Runner.driver,result.getName());
//            BaseTest.logger.log(LogStatus.FAIL, BaseTest.logger .addScreenCapture(ss));
//        }
        extent.endTest(logger);
        extent.flush();
        runner.endTest();
        String testSuitName[] = ApplicationSettings.TestSuitName.split("/");
        if(ApplicationSettings.file.split(":").length == 1){
            String s= ApplicationSettings.TEST_RESOURCE_PATH + ApplicationSettings.path + ApplicationSettings.file;
            new JsonLib().mapToJsonString(ApplicationSettings.TEST_RESOURCE_PATH + ApplicationSettings.path +
                    ApplicationSettings.file,DataManager.getSavedDataForNextTC());
        }else{
//            String s=
            new JsonLib().mapToJsonString(ApplicationSettings.TEST_RESOURCE_PATH + "/" +
                    testSuitName[0]+"/"+ApplicationSettings.file.split(":")[0]+"/" + ApplicationSettings.file.split(":")[1],
                    DataManager.getSavedDataForNextTC());
        }
//        new JsonLib().mapToJsonString(ApplicationSettings.TEST_RESOURCE_PATH + ApplicationSettings.path +
//                ApplicationSettings.file,DataManager.getSavedDataForNextTC());
        HtmlReportManager.val=0;
        if(!DataManager.getNotToBeSavedData().isEmpty())
            DataManager.getNotToBeSavedData().clear();

    }

    @AfterTest(alwaysRun = true)
    protected void afterMethod() {

    }

    @AfterSuite(alwaysRun = true)
    protected void aftersuit() {
        extent.close();
    }

    /**
     * Method level annotation to specify input file
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface TestData {
        String fileName();
    }

    @DataProvider(name = "testData")
    public Object[][] xmlDataProvider(final Method testMethod)throws Exception{
        TestData testData = testMethod.getAnnotation(TestData.class);
        String testSuitName[] = testData.fileName().split("/");
        ApplicationSettings.TestSuitName = testData.fileName();
        ApplicationSettings.path = testSuitName[0]+"/"+testSuitName[1]+"/";
        String key = testSuitName[1]+":"+testSuitName[2].substring(0,testSuitName[2].length() -5).toLowerCase();
        String value = ExecutionMngrMap.get(key);
        if( value.equals("NO")  )
            throw new SkipException("Skipping this exception");

        //check for annotation for filename
        if (testData == null || testData.fileName() == null || testData.fileName().length() == 0) {
            throw new Exception(testMethod.getClass().getSimpleName() + ": File name missing in the test annotation!");
        }
        Map<String, Object> testdata = new JsonLib().jsonToMap(ApplicationSettings.TEST_RESOURCE_PATH + "/" + testData.fileName());
        return new Object[][]{{testdata}};
    }
}
