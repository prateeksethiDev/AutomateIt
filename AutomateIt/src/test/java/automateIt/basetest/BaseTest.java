package automateIt.basetest;

import automateIt.browser.BrowserFactory;
import automateIt.browser.DriverFactory;
import automateIt.utils.ReadPropertyFile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void launchSetup(){
        String browser=ReadPropertyFile.getProperty("browser");
        boolean remote_execution_mode=Boolean.parseBoolean(ReadPropertyFile.getProperty("remote_execution_mode"));
        String hubURL=ReadPropertyFile.getProperty("hubURL");
        DriverFactory.getInstance().setDriverInThreadLocal(new BrowserFactory().createBrowserInstance(browser,remote_execution_mode,hubURL));
        driver=DriverFactory.getInstance().getDriverFromThreadLocal();
        driver.manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSetup(){
        DriverFactory.getInstance().getDriverFromThreadLocal().close();
    }

}
