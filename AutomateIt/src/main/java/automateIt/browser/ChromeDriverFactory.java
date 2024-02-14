package automateIt.browser;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverFactory  {
    RemoteWebDriver driver;

    public  RemoteWebDriver getDriver(Boolean remoteExecution, String hubURL) throws MalformedURLException {
        ChromeOptions chromeOptions=setChromeOptions();
            if(remoteExecution){
                driver= new RemoteWebDriver(new URL(hubURL),chromeOptions);
            }else{

                driver= new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
            }
      //  driver.get(appURL);
        return  driver;
    }

    public ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        return options;
    }
}
