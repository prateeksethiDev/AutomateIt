package automateIt.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

public class AccountPage extends BasePage{

    By welcome_user_lbl= By.xpath("//a[text()='Welcome Paul']");

    public AccountPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean verifyLoginIsSuccessful(){
        return isElementPresent(welcome_user_lbl,"My Account label on account Page");
    }



}
