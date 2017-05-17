package steam.forms;


import framework.BaseElement;
import framework.BrowserFactory;
import framework.Button;
import framework.Select;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.NoSuchElementException;



public class DescriptionPage extends BasePage{
    WebDriver driver;
    WebElement daySelect;
    WebElement concreteDaySelect;
    WebElement monthSelect;
    WebElement concreteMonthSelect;
    WebElement yearSelect;
    WebElement concreteYearSelect;
    WebElement buttonEnter;
    WebElement buttonInstall;
    By ageMessageLocator = By.xpath("//h2[contains(text(),'Пожалуйста, введите дату вашего рождения')]");




    String daySelectLocator ="//select[@name='ageDay']";
    String dayOptionLocator = "//select[@name='ageDay']/option[@value='2']";
    String monthSelectLocator = "//select[@name='ageMonth']";
    String monthOptionLocator = "//select[@name='ageMonth']/option[@value='February']";
    String yearSelectLocator = "//select[@name='ageYear']";
    String yearOptionLocator = "//select[@name='ageYear']/option[@value='1999']";
    String enterButtonLocator = "//span[contains(text(),'Войти')]";
    String installButtonLocator = "//a[@class='header_installsteam_btn_content']";
    String discountLocator2 = "//div[@class='discount_pct']";
    String finalPriceLocator = "//div[@class='discount_final_price']";


    public DescriptionPage() {
        this.driver = getDriver();
    }

    public void chooseAgeIfExist() {


          Wait<WebDriver> wait = new WebDriverWait(driver, 5).ignoring(java.util.NoSuchElementException.class, ElementNotVisibleException.class);
        BaseElement baseElement = new BaseElement(driver);
         try{
             //if (driver.findElement(ageMessageLocator).isDisplayed()) {
              /*wait = new WebDriverWait(driver, 10);
              wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(daySelectLocator)));*/
              BrowserFactory.waitElementsExplicide(daySelectLocator);
             daySelect= new Select(baseElement.findElement(daySelectLocator),driver);
             daySelect.click();
             /*WebElement elem1= driver.findElement(daySelectLocator);
             elem1.click();*/
             concreteDaySelect = new Select(baseElement.findElement(dayOptionLocator),driver);
             concreteDaySelect.click();
            /* wait = new WebDriverWait(driver, 10);
             wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(monthSelectLocator));*/

          //   WebElement ele=driver.findElement(By.xpath("//div[@class='page_content']"));

           /* Actions act = new Actions(driver);
             act.moveToElement(ele).build().perform();
             ele.click();*/
            // act.doubleClick(e).build().perform();
             BrowserFactory.waitElementsExplicide(monthSelectLocator);


             monthSelect=new Select(baseElement.findElement(monthSelectLocator),driver);
             monthSelect.click();

             concreteMonthSelect=new Select(baseElement.findElement(monthOptionLocator),driver);
             concreteMonthSelect.click();

             yearSelect=new Select(baseElement.findElement(yearSelectLocator),driver);
             yearSelect.click();
             BrowserFactory.waitElementsExplicide(yearSelectLocator);
             concreteYearSelect=new Select(baseElement.findElement(yearOptionLocator),driver);
             concreteYearSelect.click();

             buttonEnter = new Button(baseElement.findElement(enterButtonLocator),driver);
             buttonEnter.click();

            /* concreteDaySelect.click();
             Actions action = new Actions(driver);
             WebElement elem = driver.findElements(dayOptionLocator).get(1);
             action.moveToElement(elem1).moveToElement(elem).build().perform();
            // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
             elem.click();
           //  System.out.println(elem.getText());
             action = new Actions(driver);
             driver.findElement(monthSelectLocator).click();
              elem = driver.findElement(monthOptionLocator);
             action.moveToElement(elem).build().perform();
             elem.click();

              driver.findElement(yearSelectLocator).click();
             elem = driver.findElement(yearOptionLocator);
             action.moveToElement(elem).build().perform();
             elem.click();*/

             // driver.findElement(enterButtonLocator).click();
      //}


        }

         catch(TimeoutException e){

         }

        catch(NoSuchElementException e){

        }

    }

    public boolean isSimilarPriceDiscount(List<String> list) {
        BrowserFactory.waitElementsExplicide(discountLocator2);
        BaseElement baseElement = new BaseElement(driver);
        String discount = baseElement.findElement(discountLocator2).getText();
        String price = baseElement.findElement(finalPriceLocator).getText();
        List<String> new_requisites = new ArrayList<>();
        new_requisites.add(discount);
        new_requisites.add(price.split(" ")[0]);
       /* for(String l:list){
            //System.out.println(l);
        }
        for(String l1:new_requisites){
            System.out.println(l1);
        }*/
        return list.equals(new_requisites);


    }

    public void clickOnInstall() {
        BaseElement baseElement = new BaseElement(driver);

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        BrowserFactory.waitElementsExplicide(installButtonLocator);
        buttonInstall= new Button(baseElement.findElement(installButtonLocator),driver);
        buttonInstall.click();
    }
}
