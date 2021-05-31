package automateIt.pages;

import automateIt.utils.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    By email_address_txt= By.id("txtUsername");
    By password_txt= By.id("txtPassword");
    By signIn_btn= By.id("btnLogin");

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void loadAppURL(String appURL){
        driver.get(appURL);
    }
    public void login(String email, String password){
        sendKeysToText(locateElement(email_address_txt),"email_address_txt",email);
        sendKeysToText(locateElement(password_txt),"password_txt",password);
        clickOnWebElement(locateElement(signIn_btn),"sign_in_btn");
    }
}