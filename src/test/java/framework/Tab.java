package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class Tab extends BaseElement {
    WebDriver driver;
    WebElement tab;
    //By specialsLocator;

    public Tab(WebDriver driver) {
        this.driver = driver;

    }

    public Tab(WebElement tab,WebDriver driver) {
        this.tab=tab;
        this.driver = driver;

    }


    @Override
    public void click() {

        tab.click();
    }
}
