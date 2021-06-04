package automateIt.tests;

import automateIt.pages.LoginPage;
import automateIt.pages.AccountPage;
import automateIt.utils.ReadPropertyFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    LoginPage loginPage=null;
    AccountPage accountPage=null;
    String appURL=null;

    @BeforeClass
     private void setPageObjects(){
        appURL= ReadPropertyFile.getProperty("appURL");
        loginPage= new LoginPage(driver);
        accountPage=new AccountPage(driver);
    }

    @Test(description = "To verify user is able to login into application with valid credentials")
    public void testLogin() {
        loginPage.loadAppURL(appURL);
        loginPage.login("Admin","admin123");
        accountPage.verifyLoginIsSuccessful();
    }
}