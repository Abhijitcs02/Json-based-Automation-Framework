package com.automation.core;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;



public class Runner {
    WebDriver driver;
    public static Map<String, String> globalSettings = new HashMap<>();
    public static Map<String, String> globalTestData = new HashMap<>();
    Map<String, Object> dataforNextTC = new HashMap<>();

    public void initTest() {
        loadSettings();
        loadGlobalTestData();
        initDriver();
    }


    public void endTest(){
        driver.quit();
    }

    public void initDriver(){
        driver = new BrowserFactory().initDriver();
        driver.get(ApplicationSettings.APPLICATION_URL);
    }

    public void loadSettings(){
        try {
            Properties property = new Properties();
            FileInputStream input = new FileInputStream(new File(ApplicationSettings.GLOBAL_SETTINGS));
            property.load(input);
            for (Map.Entry<Object, Object> x : property.entrySet()) {
                globalSettings.put((String) x.getKey(), (String) x.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGlobalTestData(){
        try {
            Properties property = new Properties();
            String fileName = ApplicationSettings.GLOBAL_TESTDATA;
            property.load(getClass().getClassLoader().getResourceAsStream(fileName));
            for (Map.Entry<Object, Object> x : property.entrySet()) {
                globalTestData.put((String) x.getKey(), (String) x.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadInputData(String fileName){
//        dataReserver = ;
        DataManager.setDataReserver(new JsonLib().jsonToMap(ApplicationSettings.TEST_INPUTDATA_PATH + "/" + fileName));
    }

    public void storeRunData(String fileName){
        new JsonLib().mapToJsonString(ApplicationSettings.TEST_INPUTDATA_PATH + "/" + fileName , DataManager.getSavedDataForNextTC());
    }

    public void run(Map<String, Object> params) {
//        loadInputData( params.get("inDataFileName").toString());
//        System.out.println(params.get("steps"));
//        dataReserver.put("runData","rdata1");
//        getSavedData = params;
        DataManager.setDataReserver(params);
        ApplicationSettings.file=params.get("outDataFileName").toString();
//        String sss =ApplicationSettings.TEST_RESOURCE_PATH + ApplicationSettings.path +ApplicationSettings.file;
        String testSuitName[] = ApplicationSettings.TestSuitName.split("/");
        if(ApplicationSettings.file.split(":").length == 1){
            Map<String, Object> testdata = new JsonLib().jsonToMap(ApplicationSettings.TEST_RESOURCE_PATH +
                    ApplicationSettings.path +ApplicationSettings.file);
            DataManager.setSavedDataForNextTC(testdata);
        }else{
//          String s= ApplicationSettings.TEST_RESOURCE_PATH + ApplicationSettings.path + ApplicationSettings.file;
            Map<String, Object> testdata = new JsonLib().jsonToMap(ApplicationSettings.TEST_RESOURCE_PATH + "/" +
                    ApplicationSettings.TestSuitName.split("/")[0]+"/"+ApplicationSettings.file.split(":")[0]+"/" + ApplicationSettings.file.split(":")[1]);
            //save data for output file
            DataManager.setSavedDataForNextTC(testdata);
        }

        //save data for output file
//        DataManager.setSavedDataForNextTC(testdata);
                try {
                    for(Map<String,Object> action1: (List<Map<String,Object>>) params.get("steps")){
                        for (Map.Entry entry1 : action1.entrySet()) {
                                String s = entry1.getKey().toString().substring(3);
                                switch (entry1.getKey().toString().substring(3)) {
                                    case "LoginPage":
                                        for (Object action11 : (ArrayList) entry1.getValue()) {
                                            LoginPage.class.getDeclaredMethod(action11.toString(), WebDriver.class).invoke(new LoginPage(), driver);
                                        }
                                        break;
                                    case "HomePage":
                                        for (Object action11 : (ArrayList) entry1.getValue()) {
                                            HomePage.class.getDeclaredMethod(action11.toString(), WebDriver.class).invoke(new HomePage(), driver);
                                        }
                                        break;
                                }
                        }
                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    BaseTest.logger.log(LogStatus.FAIL, ExceptionUtils.getStackTrace(e));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    BaseTest.logger.log(LogStatus.FAIL, ExceptionUtils.getStackTrace(e));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    BaseTest.logger.log(LogStatus.FAIL, ExceptionUtils.getStackTrace(e));
                } catch (Exception e) {
                    e.printStackTrace();
                    BaseTest.logger.log(LogStatus.FAIL, ExceptionUtils.getStackTrace(e));
                }


//        storeRunData(params.get("outDataFileName").toString());
    }
}
