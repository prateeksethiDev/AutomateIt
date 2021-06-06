package automateIt.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import automateIt.pages.AccountPage;
import automateIt.pages.LoginPage;
import automateIt.utils.ReadPropertyFile;
import auutomateIt.fixtures.beans.LoginUserBean;
import auutomateIt.fixtures.dataProviders.LoginDataProvider;


public class LoginTests extends BaseTest {
    LoginPage loginPage=null;
    AccountPage accountPage=null;
    String appURL=null;

    @BeforeClass(alwaysRun = true)
     private void setPageObjects(){
        appURL= ReadPropertyFile.getProperty("appURL");
        loginPage= new LoginPage(driver);
        accountPage=new AccountPage(driver);
    }

    @Test(description = "To verify user is able to login into application with valid credentials",dataProvider = "validUserLoginDataProvider",
			 dataProviderClass = LoginDataProvider.class,groups = {"smoke-tests"})
    public void testLogin(LoginUserBean loginUserBean) {
        loginPage.loadAppURL(appURL);
        loginPage.login(loginUserBean.getUsername(),loginUserBean.getPassword());
        accountPage.verifyLoginIsSuccessful();
    }
}