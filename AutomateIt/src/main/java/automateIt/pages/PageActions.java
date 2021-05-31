package automateIt.pages;

import automateIt.utils.ExtentFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.function.Function;

public class PageActions {
    protected RemoteWebDriver driver;
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    private WebDriverWait wait;

    public PageActions(RemoteWebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    protected WebElement locateElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        List<WebElement> listEle= driver.findElements(locator);
        if(listEle.size()>0){
            return listEle.get(0);
        }else{
            throw new RuntimeException("Could not locate webelement with supplied locator: "+locator);
        }
    }

    protected void sendKeysToText(WebElement element, String fieldName, String valueToBeSent) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(valueToBeSent);
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" entered value as "+valueToBeSent+" is successful");
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" entered value as "+valueToBeSent+" is failed due to "+e.getMessage());
        }
    }

    protected void clickOnWebElement(WebElement element,String fieldName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" click is successful");
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to click on field "+fieldName+" due to exception=>"+e.getMessage());
        }
    }

    protected void clearText(WebElement element,String fieldName) {
        try {
            element.clear();
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" clear is successful");
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to clear on field "+fieldName+" due to exception=>"+e.getMessage());
        }
    }

    protected void moveToElement(WebElement element,String fieldName) {
        try {
            JavascriptExecutor executor=(JavascriptExecutor)driver;
            executor.executeScript("arguments[0].scrollIntoView(true)", element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" Mouse Hovered successful");
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to Mouse Hovered on  "+fieldName+" due to exception=>"+e.getMessage());
        }
    }

    protected boolean isElementPresent(By locator,String fieldName) {
        boolean flag=false;
        try {
            flag= wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, " Presence of field "+fieldName+" is successful");
            return flag;
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to check presence of field "+fieldName+" due to exception=>"+e.getMessage());
        }
        return flag;
    }

    protected boolean isElementNotPresent(WebElement element,String fieldName) {
        boolean flag=false;
        try {
            flag=!element.isDisplayed()?true:false;
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" Presence of field is successful");
            return flag;
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to check presence of field "+fieldName+" due to exception=>"+e.getMessage());
        }
        return flag;
    }

    protected void selectDropDownByVisibleText(WebElement element,String fieldName,String visibleText) {

        try {
            Select s = new Select(element);
            s.selectByVisibleText(visibleText);
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" selected from dropdown is successful");

        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to select visibleText from dropdown "+fieldName+" due to exception=>"+e.getMessage());
        }

    }

    protected void assertEqualsString(String expValue,String actualValue,String locatorName) {
        try {
            Assert.assertEquals(expValue, actualValue);
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, locatorName+" String assertion is successful");

        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, locatorName+" String assertion is failed "+locatorName+" due to exception=>"+e.getMessage());
        }
    }

    protected void assertConfirmationPopUp(String fieldName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.alertIsPresent()).accept();


            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"Acceptance of Confirmation Popup is successful");

        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" Acceptance of Confirmation Popup is "+fieldName+" due to exception=>"+e.getMessage());
        }
    }

    protected void waitElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeAccessible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });
    }

    protected void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForElementIneVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void assertWebElementNotPresent(By locator) {
        try {
            if(driver.findElements(locator).size()==0) {
                //log success message in extent report
                ExtentFactory.getInstance().getExtent().log(Status.PASS, "WebElement with locator: "+ locator+" not present, validation is passed");
            }
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "WebElement with locator: "+ locator+" is present, validation failed due to exception=>"+e.getMessage());
        }
    }

    protected void assertWebElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,20);
            if(wait.until(ExpectedConditions.numberOfElementsToBe(locator, 1)).size()==1) {
                //log success message in extent report
                ExtentFactory.getInstance().getExtent().log(Status.PASS, "WebElement with locator: "+ locator+" present, validation is passed");
            }
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "WebElement with locator: "+ locator+" is not present, validation failed due to exception=>"+e.getMessage());
        }
    }

    protected String getTextFromElement(By locator) {
        String text="";
        try {
            WebDriverWait wait = new WebDriverWait(driver,20);
            if(wait.until(ExpectedConditions.numberOfElementsToBe(locator, 1)).size()==1) {
                text=driver.findElement(locator).getText();
                //log success message in extent report
                ExtentFactory.getInstance().getExtent().log(Status.PASS, "WebElement with locator: "+ locator+" present, validation is passed");
            }
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "WebElement with locator: "+ locator+" is not present, validation failed due to exception=>"+e.getMessage());
        }
        return text;
    }

    protected String getTitleOfPage() {
        return driver.getTitle();
    }

    protected void assertTheResult(boolean exp) {
        try {

            if(exp) {
                //log success message in extent report
                ExtentFactory.getInstance().getExtent().log(Status.PASS, "Expression is evaluate to true, validation is passed");
            }
        }catch(Exception e) {
            //log failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Expression is evaluate to false, validation is failed");
        }
    }

    protected String returnDynamicXpath(String stringToReplace,String stringWithReplace) {
        return String.format(stringToReplace, stringWithReplace);
    }
}
