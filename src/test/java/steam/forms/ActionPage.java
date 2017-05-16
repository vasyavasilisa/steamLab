package steam.forms;

import framework.BaseElement;
import framework.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by USER on 14.05.2017.
 */
public class ActionPage {
    WebDriver driver;
    By specialsLocator = By.xpath("//div[@id='tab_select_Discounts']/div");
    WebElement tab;

    public ActionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSpecials(){
        BaseElement baseElement = new BaseElement(driver);
        //////////////////////////////////
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(specialsLocator));
        ///////////////////////////////////////////
        tab=new Tab(baseElement.findElement(specialsLocator),driver);
        tab.click();

    }
}
