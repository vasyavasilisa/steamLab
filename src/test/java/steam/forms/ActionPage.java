package steam.forms;

import framework.BaseElement;
import framework.BrowserFactory;
import framework.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ActionPage extends BasePage{
    WebDriver driver;
    String specialsLocator = "//div[@id='tab_select_Discounts']/div";
    WebElement tab;

    public ActionPage() {
        this.driver = getDriver();
    }

    public void clickOnSpecials(){
        BaseElement baseElement = new BaseElement(driver);
        BrowserFactory.waitElementExplicide(specialsLocator);
        tab=new Tab(baseElement.findElement(specialsLocator),driver);
        tab.click();

    }
}
