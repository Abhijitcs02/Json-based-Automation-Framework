package com.automation.tests.poc;


import com.automation.core.ApplicationSettings;
import com.automation.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * class contains common functions for all testng tests
 * every test class should extend this class
 */
public class  SampleTest1 extends BaseTest {

//    @Test(dataProvider = "testData")
//    @TestData(fileName = "testcaseBank/inbound/JDAtestcase1.json")
//    public void JdaTestCase1(Map<String , Object> params){
//        BaseTest.logger = BaseTest.extent.startTest("TESTCASE111111111111", "DESC11111111111");
//        runner.run(params);
//        Assert.assertTrue(BaseTest.Status);
//        BaseTest.Status = true;
//    }



//    @Test(dataProvider = "testData")
//    @TestData(fileName = "testcaseBank/inbound/testcase1.json")
//    public void test1(Map<String , Object> params){
//        BaseTest.logger = BaseTest.extent.startTest("TESTCASE111111111111", "DESC11111111111");
//        runner.run(params);
//        Assert.assertTrue(BaseTest.Status);
//        BaseTest.Status = true;
//    }
//
//
//    @Test(dataProvider = "testData")
//    @TestData(fileName = "testcaseBank/inbound/testcase2.json")
//    public void test2(Map<String , Object> params){
//        BaseTest.logger = BaseTest.extent.startTest("TESTCASE22222222", "DESC222222222");
//        runner.run(params);
//        Assert.assertTrue(BaseTest.Status);
//        BaseTest.Status = true;
//    }
//
//    @Test(dataProvider = "testData")
//    @TestData(fileName = "testcaseBank/inbound/testcase3.json")
//    public void test3(Map<String , Object> params){
//        BaseTest.logger = BaseTest.extent.startTest("TESTCASE333333", "DESC33333333");
//        runner.run(params);
//        Assert.assertTrue(BaseTest.Status);
//        BaseTest.Status = true;
//    }

    @Test(dataProvider = "testData")
    @TestData(fileName = "testcaseBank/inbound/NtsAppLogin.json")
    public void NtsAppLogin(Map<String , Object> params){
        BaseTest.logger = BaseTest.extent.startTest("NtsAppLogin Test", "Working for Demo");
        runner.run(params);
        Assert.assertTrue(BaseTest.Status);
        BaseTest.Status = true;
    }
}