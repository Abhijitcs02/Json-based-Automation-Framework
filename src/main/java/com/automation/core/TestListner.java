package com.automation.core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;

public class TestListner implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Onteststarttttt");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("ontestsuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("ontestfailure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("ontestskipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish");
    }
}
