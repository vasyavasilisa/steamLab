package steam.forms;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class DescriptionPage {
    WebDriver driver;
    By ageMessageLocator = By.xpath("//h2[contains(text(),'Пожалуйста, введите дату вашего рождения')]");
    By daySelectLocator = By.xpath("//select[@name='ageDay']");
    By dayOptionLocator = By.xpath("//select[@name='ageDay']/option");
    By monthSelectLocator = By.xpath("//select[@name='ageMonth']");
    By monthOptionLocator = By.xpath("//select[@name='ageMonth']/option[@value='February']");
    By yearSelectLocator = By.xpath("//select[@name='ageYear']");
    By yearOptionLocator = By.xpath("//select[@name='ageYear']/option[@value='1992']");
    By enterButtonLocator = By.xpath("//span[contains(text(),'Войти')]");
    By installButtonLocator = By.xpath("//a[@class='header_installsteam_btn_content']");
    By discountLocator = By.xpath("//div[@class='discount_pct']");
    By finalPriceLocator = By.xpath("//div[@class='discount_final_price']");

    public DescriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAgeIfExist() {
      /*  WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ageMessageLocator));*/
      /*  Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(TimeoutException.class)
                .ignoring(NoSuchElementException.class);

        WebElement foo =(WebElement) wait.until(new Function<WebDriver,WebElement>() {

            public WebElement apply(WebDriver driver) {

                return driver.findElement(ageMessageLocator);

            }

        });*/

          Wait<WebDriver> wait = new WebDriverWait(driver, 5).ignoring(java.util.NoSuchElementException.class, ElementNotVisibleException.class);

         try{
             //if (driver.findElement(ageMessageLocator).isDisplayed()) {
              wait = new WebDriverWait(driver, 10);
              wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(daySelectLocator));
             WebElement elem1= driver.findElement(daySelectLocator);
             elem1.click();

            Actions action = new Actions(driver);
             WebElement elem = driver.findElements(dayOptionLocator).get(1);
             action.moveToElement(elem1).moveToElement(elem).build().perform();
            // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
             elem.click();
           //  System.out.println(elem.getText());

             driver.findElement(monthSelectLocator).click();
              elem = driver.findElement(monthOptionLocator);
             action.moveToElement(elem).build().perform();
             elem.click();

              driver.findElement(yearSelectLocator).click();
             elem = driver.findElement(yearOptionLocator);
             action.moveToElement(elem).build().perform();
             elem.click();

              driver.findElement(enterButtonLocator).click();
      //}


        }

         catch(TimeoutException e){

         }

        catch(NoSuchElementException e){

        }

    }

    public boolean isSimilarPriceDiscount(List<String> list) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(discountLocator));
        String discount = driver.findElement(discountLocator).getText();
        String price = driver.findElement(finalPriceLocator).getText();
        List<String> new_requisites = new ArrayList<>();
        new_requisites.add(discount);
        new_requisites.add(price.split(" ")[0]);
        for(String l:list){
            System.out.println(l);
        }
        for(String l1:new_requisites){
            System.out.println(l1);
        }
        return list.equals(new_requisites);


    }

    public void clickOnInstall() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(installButtonLocator));
        driver.findElement(installButtonLocator).click();
    }
}
