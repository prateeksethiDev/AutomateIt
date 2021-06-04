package automateIt.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import auutomateIt.fixtures.beans.AdminUserBean;

public class AdminPage extends BasePage{
    
    private By userNameSearch_txt=By.id("searchSystemUser_userName");
    private By userAdd_btn=By.id("btnAdd");
    private By addUser_lbl=By.xpath("//h1[text()='Add User']");
    private By userRole_drpd=By.id("systemUser_userType");
    private By employeeName_txt=By.id("systemUser_employeeName_empName");
    private By addUser_UserName_txt=By.id("systemUser_userName");
    private By status_drpd=By.id("systemUser_status");
    private By password_txt=By.id("systemUser_password");
    private By confirmPassword_txt=By.id("systemUser_confirmPassword");
    private By saveUser_btn=By.id("btnSave");
    private By searchUser_btn=By.id("searchBtn");

    public AdminPage(RemoteWebDriver driver) {
        super(driver);
    }

    
    public void addAdminUser(AdminUserBean adminUserBean){
        clickOnWebElement(userAdd_btn,"Add User button");
        waitForElementToBeVisible(addUser_lbl);
        selectDropDownByVisibleText(userRole_drpd,"user role dropdown",adminUserBean.getUserRole());
        sendKeysToText(employeeName_txt,"username",adminUserBean.getEmployeeName());
        sendKeysToText(addUser_UserName_txt,"username",adminUserBean.getUserName());
        selectDropDownByVisibleText(status_drpd,"status dropdown",adminUserBean.getStatus());
        clearText(password_txt, "clearing the password text if stored before");
        sendKeysToText(password_txt,"password_txt",adminUserBean.getPassword());
        sendKeysToText(confirmPassword_txt,"password_txt",adminUserBean.getConfirmPassword());
        clickOnWebElement(saveUser_btn, "Add User save button");
    }
    
    public void searchUser(AdminUserBean adminUserBean) {
    	
    }


	public boolean verifyUserLandedOnUsersearchPage() {
		return isElementPresent(searchUser_btn,"user search button");
	}


	public void searchSytemUsers(AdminUserBean adminUserBean) {
		sendKeysToText(userNameSearch_txt,"username_searc_txt",adminUserBean.getUserName());
		
	}
}