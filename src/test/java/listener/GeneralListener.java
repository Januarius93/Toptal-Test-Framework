package listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.*;
import page.LoginPage;

public class GeneralListener implements ITestListener, ISuiteListener {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @Override
    public void onFinish(ITestContext Result) {
        Reporter.log("TEST FINISHED: " + Result.getName());
    }

    @Override
    public void onStart(ITestContext Result) {
        Reporter.log("TEST STARTED: " + Result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result) {
        Reporter.log("TEST CASE FAILED: " + Result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result) {
        Reporter.log("TEST CASE SKIPPED: " + Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result) {
        Reporter.log("TEST CASE STARTED: " + Result.getName());
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
        Reporter.log("TEST CASE PASSED: " + Result.getName());
    }

    @Override
    public void onStart(ISuite iSuite) {
        Reporter.log("TEST SUITE STARTED: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        Reporter.log("TEST SUITE FINISHED: " + iSuite.getName() + " " + iSuite.getResults());
    }
}
