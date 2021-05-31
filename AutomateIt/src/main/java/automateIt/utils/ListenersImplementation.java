package automateIt.utils;

import automateIt.browser.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenersImplementation implements ITestListener {

    static ExtentReports report;
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test=report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+" is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+" is Failed");
        // add screenshot for failed tests

        File src =((TakesScreenshot) DriverFactory.getInstance().getDriverFromThreadLocal()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate= format.format(date);
        String screenshotPath=System.getProperty("user.dir")+"/Reports/Screenshots/"+actualDate+".jpeg";
        File dest = new File(screenshotPath);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath,"Test case failure screenshot");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+" is Skipped");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            report =ExtentReportNG.setupReports();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}
