package automateIt.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

public class AdminPage extends BasePage{
    private By admin_tab= By.xpath("//a/b[text()='Admin']");
    private By userManagement_drpd=By.id("menu_admin_UserManagement");
    private By userName_txt=By.id("searchSystemUser_userName");
    private By userAdd_btn=By.id("btnAdd");
    private By addUser_lbl=By.xpath("//h1[text()='Add User']");
    private By userRole_drpd=By.id("systemUser_userType");
    private By employeeName_txt=By.id("systemUser_employeeName_empName");
    private By addUser_UserName_txt=By.id("systemUser_userName");
    private By status_drpd=By.id("systemUser_status");
    private By password_txt=By.id("systemUser_password");
    private By confirmPassword_txt=By.id("systemUser_confirmPassword");
    private By saveUser_btn=By.id("btnSave");

    AdminPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickOnAdminTab(){
        clickOnWebElement(admin_tab,"admin_tab");
        waitForElementToBeVisible(userManagement_drpd);
    }

    public void addAdminUser(){
        clickOnWebElement(userAdd_btn,"Add User button");
        waitForElementToBeVisible(addUser_lbl);
        selectDropDownByVisibleText(userRole_drpd,"user role dropdown","ESS");
        sendKeysToText(userName_txt,"username","automation_user");
    }


}
