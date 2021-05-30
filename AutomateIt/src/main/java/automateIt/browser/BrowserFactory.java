package automateIt.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.logging.Logger;

public class BrowserFactory {
    Logger logger = Logger.getLogger(BrowserFactory.class.getName());
    RemoteWebDriver driver;


     public RemoteWebDriver createBrowserInstance(String browser,Boolean remoteExecution, String hubURL){
        try {
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeDriverFactory chromeObject=new ChromeDriverFactory();
            driver=chromeObject.getDriver(remoteExecution,hubURL);
        }else if(browser.equalsIgnoreCase("firefox")) {
            FirefoxDriverFactory firefoxObject = new FirefoxDriverFactory();
            driver=firefoxObject.getDriver(remoteExecution,hubURL);
        }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}