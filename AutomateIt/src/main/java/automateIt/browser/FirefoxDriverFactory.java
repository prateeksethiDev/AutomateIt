package automateIt.browser;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverFactory {
    private DesiredCapabilities cap;
    RemoteWebDriver driver;

    public RemoteWebDriver getDriver(Boolean remoteExecution, String hubURL) throws MalformedURLException {

        if (remoteExecution) {
            cap=new DesiredCapabilities();
            cap.setCapability(CapabilityType.BROWSER_NAME,"firefox");
            driver = new RemoteWebDriver(new URL(hubURL), cap);
        } else {

            driver = new FirefoxDriver();
        }
       // driver.get(appURL);
        return driver;
    }

}
