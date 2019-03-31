package webautomation.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.*;
import webautomation.page.LoginPage;

public class GeneralListener implements ITestListener, ISuiteListener {
    private static final Logger log = LogManager.getLogger(LoginPage.class);


    @Override
    public void onFinish(ITestContext Result) {
        log.info("TEST FINISHED: " + Result.getName());
    }

    @Override
    public void onStart(ITestContext Result) {
        log.info("TEST STARTED: " + Result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result) {
        log.info("TEST CASE FAILED: " + Result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result) {
        log.info("TEST CASE SKIPPED: " + Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result) {
        log.info("TEST CASE STARTED: " + Result.getName());
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
        log.info("TEST CASE PASSED: " + Result.getName());
    }

    @Override
    public void onStart(ISuite iSuite) {
        log.info("TEST SUITE STARTED: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        log.info("TEST SUITE FINISHED: " + iSuite.getName() + " " + iSuite.getResults());
    }
}
