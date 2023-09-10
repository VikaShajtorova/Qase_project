package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST START: " +result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST SUCCESS: " +result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST FAILURE: " +result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST SKIPPED: " +result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info(">>>>>>>>>>>>>>TEST FAILED but within success percentage: " +result.getName() + "<<<<<<<<<<<<<<<<<" );

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST START: " +iTestContext.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST FINISH: " +iTestContext.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }
}
