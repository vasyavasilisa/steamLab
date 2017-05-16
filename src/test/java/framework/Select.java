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
   /* public Select(WebDriver driver, By languageLocator, By russionOptionLocator,
                  WebElement webElement,WebDriver driver1) {
        super(webElement,driver1);
        this.driver = driver;
        this.languageLocator = languageLocator;
        this.russionOptionLocator = russionOptionLocator;
    }*/

    @Override
    public void click() {

       Actions action = new Actions(driver);
        //System.out.println(select.getText());
        action.moveToElement(select).build().perform();
        select.click();
       // select.click();
        System.out.println(select.getText());
      // select.click();
       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(languageLocator));
        String lang = driver.findElement(languageLocator).getText();
        if (lang.equals("language")) {
            driver.findElement(languageLocator).click();*/
           /* driver.findElement(russionOptionLocator).sendKeys(Keys.ENTER);
            driver.findElement(russionOptionLocator).click();*/
           /* Actions action = new Actions(driver);
            WebElement elem = driver.findElement(russionOptionLocator);
            action.doubleClick(elem).build().perform();


        }*/
    }
}
