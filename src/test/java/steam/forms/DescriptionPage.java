package steam.forms;


import framework.BaseElement;
import framework.BrowserFactory;
import framework.Button;
import framework.Select;
import framework.services.CommonFunctions;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.NoSuchElementException;


public class DescriptionPage extends BasePage {
    WebDriver driver;
    WebElement daySelect;
    WebElement concreteDaySelect;
    WebElement monthSelect;
    WebElement concreteMonthSelect;
    WebElement yearSelect;
    WebElement concreteYearSelect;
    WebElement buttonEnter;
    WebElement buttonInstall;
    //  By ageMessageLocator = By.xpath("//h2[contains(text(),'Пожалуйста, введите дату вашего рождения')]");


    String daySelectLocatorKey = "daySelectLocator";
    String dayOptionLocatorKey = "dayOptionLocator";
    String monthSelectLocatorKey = "monthSelectLocator";
    String monthOptionLocatorKey = "monthOptionLocator";
    String yearSelectLocatorKey = "yearSelectLocator";
    String yearOptionLocatorKey = "yearOptionLocator";
    String enterButtonLocatorKey = "enterButtonLocator";
    String installButtonLocatorKey = "installButtonLocator";
    String discountLocator2Key = "discountLocator2";
    String finalPriceLocatorKey = "finalPriceLocator";

    private static final String TEXT_LOCATORS_PATH = "%s_text.properties";


    public DescriptionPage() {
        this.driver = getDriver();
    }

    public void chooseAgeIfExist() {

        Properties locatorProperties = getLocatorProperties();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5).ignoring(java.util.NoSuchElementException.class, ElementNotVisibleException.class);
        BaseElement baseElement = new BaseElement(driver);
        try {
            //if (driver.findElement(ageMessageLocator).isDisplayed()) {
              /*wait = new WebDriverWait(driver, 10);
              wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(daySelectLocator)));*/
            BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(daySelectLocatorKey));
            daySelect = new Select(baseElement.findElement(locatorProperties.getProperty(daySelectLocatorKey)), driver);
            daySelect.click();
            daySelect.click();
             /*WebElement elem1= driver.findElement(daySelectLocator);
             elem1.click();*/
            //BrowserFactory.waitImplicitly();
            concreteDaySelect = new Select(baseElement.findElement(locatorProperties.getProperty(dayOptionLocatorKey)), driver);
            concreteDaySelect.click();

            /* wait = new WebDriverWait(driver, 10);
             wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(monthSelectLocator));*/

            //   WebElement ele=driver.findElement(By.xpath("//div[@class='page_content']"));

           /* Actions act = new Actions(driver);
             act.moveToElement(ele).build().perform();
             ele.click();*/
            // act.doubleClick(e).build().perform();
           BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(monthSelectLocatorKey));


            monthSelect = new Select(baseElement.findElement(locatorProperties.getProperty(monthSelectLocatorKey)), driver);
            monthSelect.click();
            monthSelect.click();

            concreteMonthSelect = new Select(baseElement.findElement(locatorProperties.getProperty(monthOptionLocatorKey)), driver);
            concreteMonthSelect.click();


            yearSelect = new Select(baseElement.findElement(locatorProperties.getProperty(yearSelectLocatorKey)), driver);
            yearSelect.click();
            yearSelect.click();

            BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(yearSelectLocatorKey));
            concreteYearSelect = new Select(baseElement.findElement(locatorProperties.getProperty(yearOptionLocatorKey)), driver);
            concreteYearSelect.click();
            CommonFunctions commonFunctions= new CommonFunctions();
            String lang=getProperties().getProperty("language");
            System.out.println(lang);
            String nameFile=String.format(TEXT_LOCATORS_PATH,lang);
            System.out.println(nameFile);
            String prop=new String (commonFunctions.readProperties(nameFile).getProperty("enterButton"));
            System.out.println(prop);
            prop=new String (prop.getBytes("ISO-8859-1"), "UTF-8");
String locator=new String(String.format(locatorProperties.getProperty("enterButtonLocator"),prop));
            //String str = new String(locatorProperties.getProperty(enterButtonLocatorKey).getBytes("ISO-8859-1"), "UTF-8");
System.out.println(locator);
            buttonEnter = new Button(baseElement.findElement(locator), driver);
            buttonEnter.click();



            // driver.findElement(enterButtonLocator).click();
            //}


        } catch (TimeoutException e) {

        } catch (NoSuchElementException e) {

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public boolean isSimilarPriceDiscount(List<String> list) {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(discountLocator2Key));
        BaseElement baseElement = new BaseElement(driver);
        String discount = baseElement.findElement(locatorProperties.getProperty(discountLocator2Key)).getText();
        String price = baseElement.findElement(locatorProperties.getProperty(finalPriceLocatorKey)).getText();
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

    public void clickOnInstall() throws UnsupportedEncodingException {
        BaseElement baseElement = new BaseElement(driver);
        Properties locatorProperties = getLocatorProperties();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(installButtonLocatorKey));
        String str = new String(locatorProperties.getProperty(installButtonLocatorKey));

        buttonInstall = new Button(baseElement.findElement(str), driver);
        buttonInstall.click();
    }
}
