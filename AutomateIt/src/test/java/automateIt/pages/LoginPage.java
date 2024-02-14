package automateIt.pages;

import automateIt.utils.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    By email_address_txt= By.name("username");
    By password_txt= By.name("password");
    By signIn_btn= By.xpath("//button[normalize-space()='Login']");

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void loadAppURL(String appURL){
        driver.get(appURL);
    }
    public void login(String email, String password){
        sendKeysToText(email_address_txt,"email_address_txt",email);
        sendKeysToText(password_txt,"password_txt",password);
        clickOnWebElement(signIn_btn,"sign_in_btn");
    }
}