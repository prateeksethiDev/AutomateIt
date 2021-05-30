package automateIt.browser;

import automateIt.interfaces.IDriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory implements IDriverFactory {
    private DriverFactory() {
    }
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();

    public synchronized RemoteWebDriver getDriverFromThreadLocal() {
        return tlDriver.get();
    }

    public void setDriverInThreadLocal(RemoteWebDriver driverParam) {
        tlDriver.set(driverParam);
    }

}