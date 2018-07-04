package com.automation.core;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ExecuteFailedTestCases {

    public static void main(String args[]){
        TestNG runner = new TestNG();
        List<String> list = new ArrayList<String>();
        list.add(System.getProperty("user.dir")+"/test-output/testnf-failed.xml");
        runner.setTestSuites(list);
        runner.run();
    }
}
