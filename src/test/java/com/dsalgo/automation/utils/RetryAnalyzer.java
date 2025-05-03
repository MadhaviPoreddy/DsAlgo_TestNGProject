package com.dsalgo.automation.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private final int maxTry = 3;

    @Override
    public boolean retry(ITestResult result) {
        count++;
        return count < maxTry;
    }
}
