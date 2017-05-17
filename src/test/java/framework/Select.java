package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class Select extends BaseElement {


    WebDriver driver;
    By languageLocator;
    By russionOptionLocator;
    WebElement select;

    public  Select(WebElement select,WebDriver driver){
        this.select = select;
        this.driver = driver;

    }


    @Override
    public void click() {

       Actions action = new Actions(driver);
        action.moveToElement(select).build().perform();
        select.click();
        System.out.println(select.getText());

    }
}
