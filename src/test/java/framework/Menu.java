package framework;

import framework.services.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.Properties;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class Menu extends BaseElement {
    BrowserFactory fact;
    By gamesMenuLocator = By.xpath("//div[@id='genre_tab']/span/a");
    By actionLocator = By.xpath("//a[text()='Экшен']");
    WebDriver driver;
    WebElement menu;

    private String games;
    private String actions;



    public Menu() {
    }

    public Menu(WebDriver driver) {
        super(driver);
    }

    public Menu(BrowserFactory fact) {
        this.fact = fact;
    }

    public Menu(WebElement menu, WebDriver driver) {
        this.menu = menu;
        this.driver = driver;

    }

    public Menu(WebDriver driver, By gamesMunuLocator, By actionLocator) {
        this.driver = driver;
        this.gamesMenuLocator = gamesMunuLocator;
        this.actionLocator = actionLocator;
    }

    public WebDriver getDriver() {
        CommonFunctions commonFunctions = new CommonFunctions();
        Properties properties = commonFunctions.readProperties("brouser.properties");
        String br = properties.getProperty("brouser_type");
        WebDriver driver = fact.getMyDriver(br);
        return driver;
    }

    @Override
    public void click() {
      menu.click();

        // action.moveToElement(menu).build().perform();
        // menu.click();
       /* wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionLocator));*/
        // driver.findElement(actionLocator).click();
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(gamesMenuLocator));
        WebElement webElement = driver.findElement(gamesMenuLocator);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionLocator));
        driver.findElement(actionLocator).click();*/

    }

    public void moveTo() {
        Actions action = new Actions(driver);

       action.moveToElement(driver.findElement(gamesMenuLocator)).build().perform();



    }


}
