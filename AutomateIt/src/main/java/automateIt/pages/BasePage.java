package automateIt.pages;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BasePage extends PageActions{

    BasePage(RemoteWebDriver driver){
       super(driver);
    }

}