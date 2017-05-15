package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class Menu extends BaseElement {

    By gamesMenuLocator;
    By actionLocator;
    WebDriver driver;


    public Menu(WebDriver driver, By gamesMunuLocator, By actionLocator) {
        this.driver = driver;
        this.gamesMenuLocator = gamesMunuLocator;
        this.actionLocator = actionLocator;
    }

    @Override
    public void click() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(gamesMenuLocator));
        WebElement webElement = driver.findElement(gamesMenuLocator);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionLocator));
        driver.findElement(actionLocator).click();

    }


}
