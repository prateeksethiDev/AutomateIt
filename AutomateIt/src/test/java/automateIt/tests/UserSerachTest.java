package automateIt.tests;

import static org.testng.Assert.assertTrue;
import java.util.logging.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import automateIt.pages.AccountPage;
import automateIt.pages.AdminPage;
import auutomateIt.fixtures.beans.AdminUserBean;
import auutomateIt.fixtures.dataProviders.UserDataProvider;

public class UserSerachTest extends BaseTest{
	
	Logger log = Logger.getLogger(UserTests.class.getName());
	AccountPage accountPage=null;
	AdminPage adminPage=null;
	
	@BeforeClass
	private void setPageObjects(){
        accountPage=new AccountPage(driver);
        adminPage=new AdminPage(driver);
    }
	
	@Test(description = "To verify user can be searched from UI",dataProvider = "getAdminUserForSearchDataProvider",
			 dataProviderClass = UserDataProvider.class)
	    public void testcreateUser(AdminUserBean adminUserBean) {
		 log.info(adminUserBean.toString());
	        accountPage.clickOnAdminTab();
	        
	        assertTrue( adminPage.verifyUserLandedOnUsersearchPage(), "user could not navigated to search user page");
	    
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	

}