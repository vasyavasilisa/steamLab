package steam.forms;

import framework.BaseElement;
import framework.BrowserFactory;
import framework.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;


public class ActionPage extends BasePage{
    WebDriver driver;
    String specialsLocatorKey = "specialsLocator";
    WebElement tab;

    public ActionPage() {
        this.driver = getDriver();
    }

    public void clickOnSpecials(){
        Properties locatorProperties=getLocatorProperties();
        BaseElement baseElement = new BaseElement(driver);
        BrowserFactory.waitElementExplicide(locatorProperties.getProperty(specialsLocatorKey));
        tab=new Tab(baseElement.findElement(locatorProperties.getProperty(specialsLocatorKey)),driver);
        tab.click();

    }
}
