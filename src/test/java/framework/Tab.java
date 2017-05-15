package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class Tab extends BaseElement {
    WebDriver driver;
    By specialsLocator;

    public Tab(WebDriver driver, By specialsLocator) {
        this.driver = driver;
        this.specialsLocator = specialsLocator;
    }

    @Override
    public void click() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(specialsLocator));
        driver.findElement(specialsLocator).click();
    }
}
