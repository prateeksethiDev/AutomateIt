package automateIt.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
    private ExtentFactory() {

    }
    private static ExtentFactory instance = new ExtentFactory();
    public static ExtentFactory getInstance() {
        return instance;
    }

    //Factory design Pattern
    ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

    public ExtentTest getExtent() {
        return extent.get();
    }

    public void setExtent(ExtentTest exteentTestObj) {
        extent.set(exteentTestObj);
    }

    public void removeExtentObject() {
        extent.remove();
    }
}
