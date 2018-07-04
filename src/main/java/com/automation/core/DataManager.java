package com.automation.core;

import java.util.HashMap;
import java.util.Map;

public class DataManager {


    public static Map<String, Object> dataReserver = new HashMap<>();
    public static Map<String, Object> savedDataForNextTC = new HashMap<>();
    public static Map<String, Object> notToBeSavedData = new HashMap<>();


    public static Map<String, Object> getDataReserver() {
        return dataReserver;
    }

    public static void setDataReserver(Map<String, Object> dataReserver) {
        DataManager.dataReserver = dataReserver;
    }

    public static Map<String, Object> getSavedDataForNextTC() {
        return savedDataForNextTC;
    }

    public static void setSavedDataForNextTC(Map<String, Object> savedDataForNextTC) {
        DataManager.savedDataForNextTC = savedDataForNextTC;
    }

    public static Map<String, Object> getNotToBeSavedData() {
        return notToBeSavedData;
    }

    public static void setNotToBeSavedData(Map<String, Object> notToBeSavedData) {
        DataManager.notToBeSavedData = notToBeSavedData;
    }








    public static String getDataFromDataReserver(String key){
        return dataReserver.get(key).toString();
    }

    public static void putDataReserverForNextTC(String key, String value){
        savedDataForNextTC.put(key, value);
    }

    public static String getDataFromToBeSavedNextTC(String key){
        return savedDataForNextTC.get(key).toString();
    }

    public static void putDataForNotToBeSavedDataReserver(String key, String value){
        notToBeSavedData.put(key,value);
    }

    public static String getDataFromNotToBeSavedDataReserver(String key){

        return notToBeSavedData.get(key).toString();
    }

//    public static void destroyNotToBeSavedData(){
//        notToBeSavedData = null;
//    }

    public static Map<String, Object> getTestData(String testCaseName){
        if(testCaseName.split(":").length == 1) {
            Map<String, Object> testdata = new JsonLib().jsonToMap(ApplicationSettings.TEST_RESOURCE_PATH + "/" +
                    ApplicationSettings.path + testCaseName);
            return testdata;
        }else {
            String testSuitName[] = ApplicationSettings.TestSuitName.split("/");
            Map<String, Object> testdata = new JsonLib().jsonToMap(ApplicationSettings.TEST_RESOURCE_PATH + "/" +
                    testSuitName[0]+"/"+testCaseName.split(":")[0]+"/" + testCaseName.split(":")[1]);
            return testdata;
        }

    }
}
