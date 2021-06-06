package automateIt.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.logging.Logger;
import automateIt.pages.AccountPage;
import automateIt.pages.AdminPage;
import auutomateIt.fixtures.beans.AdminUserBean;
import auutomateIt.fixtures.dataProviders.UserDataProvider;



public class UserTests extends BaseTest{
	Logger log = Logger.getLogger(UserTests.class.getName());
	AccountPage accountPage=null;
	AdminPage adminPage=null;
	
	@BeforeClass (alwaysRun = true)
	private void setPageObjects(){
        accountPage=new AccountPage(driver);
        adminPage=new AdminPage(driver);
    }
	
	 @Test(description = "To verify user can be created from UI",dataProvider = "createUserDataProvider",
			 dataProviderClass = UserDataProvider.class)
	    public void testcreateUser(AdminUserBean adminUserBean) {
		 log.info(adminUserBean.toString());
	        accountPage.clickOnAdminTab();
	        adminPage.addAdminUser(adminUserBean);
	        assertTrue( adminPage.verifyUserLandedOnUsersearchPage(), "user could not navigated to search user page");
	    
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	 
	 
	 @Test(description = "To verify user can be searched from UI",dataProvider = "searchUserDataProvider",
			 dataProviderClass = UserDataProvider.class,groups = {"smoke-tests"})
	    public void testSearchUser(AdminUserBean adminUserBean) {
		 log.info(adminUserBean.toString());
	        accountPage.clickOnAdminTab();
	        adminPage.isSytemUsersExists(adminUserBean);
	        assertTrue( adminPage.isSytemUsersExists(adminUserBean), "user could not be found in search user page");    
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
}