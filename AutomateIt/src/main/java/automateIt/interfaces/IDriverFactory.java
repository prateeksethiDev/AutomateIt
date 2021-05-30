package automateIt.interfaces;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface IDriverFactory {
    public RemoteWebDriver getDriverFromThreadLocal() ;
    public void setDriverInThreadLocal(RemoteWebDriver driver);
}
