package automateIt.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

public class AccountPage extends BasePage{

    By welcome_user_lbl= By.xpath("//a[text()='Welcome Paul']");
    private By admin_tab= By.xpath("//a/b[text()='Admin']");
    private By userManagement_drpd=By.id("menu_admin_UserManagement");

    public AccountPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean verifyLoginIsSuccessful(){
        return isElementPresent(welcome_user_lbl,"My Account label on account Page");
    }

    public void clickOnAdminTab(){
        clickOnWebElement(admin_tab,"admin_tab");
        waitForElementToBeVisible(userManagement_drpd);
    }

}
