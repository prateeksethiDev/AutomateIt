package automateIt.basetest;

import automateIt.browser.BrowserFactory;
import automateIt.browser.DriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    @BeforeSuite
    public void launchSetup(){
        String browser=getPropertyFromFile("browser");
        boolean execution_mode=Boolean.getBoolean(getPropertyFromFile("remoteExecution"));
        String hubURL=getPropertyFromFile("hubURL");
        String appURL=getPropertyFromFile("appURL");
        DriverFactory.getInstance().setDriverInThreadLocal(new BrowserFactory().createBrowserInstance(browser,execution_mode,hubURL));
        RemoteWebDriver driver=DriverFactory.getInstance().getDriverFromThreadLocal();
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDownSetup(){
        DriverFactory.getInstance().getDriverFromThreadLocal().close();
    }

    private String getPropertyFromFile(String propKey){
        Properties prop=new Properties();;
        try {
            FileReader fr = new FileReader(new File("/resources/automation.properties"));
            prop.load(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propKey);
    }
}
