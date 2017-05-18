package steam.forms;


import framework.BaseElement;
import framework.BrowserFactory;
import framework.Button;
import framework.Select;
import framework.exceptions.ElementNotFoundException;
import framework.exceptions.OutOfTimeException;
import framework.services.CommonFunctions;
import org.openqa.selenium.*;

import java.io.UnsupportedEncodingException;
import java.util.*;


public class DescriptionPage extends BasePage {
    WebDriver driver;
    Select daySelect;
    Select concreteDaySelect;
    Select monthSelect;
    Select concreteMonthSelect;
    Select yearSelect;
    Select concreteYearSelect;
    Button buttonEnter;
    Button buttonInstall;


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
        BrowserFactory.waitWithIgnoring();
        BaseElement baseElement = new BaseElement(driver);
        try {

            BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(daySelectLocatorKey));
            daySelect = new Select(baseElement.findElement(locatorProperties.getProperty(daySelectLocatorKey)), driver);
            daySelect.click();
            daySelect.click();

            concreteDaySelect = new Select(baseElement.findElement(locatorProperties.getProperty(dayOptionLocatorKey)), driver);
            concreteDaySelect.click();

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

            String nameFile=String.format(TEXT_LOCATORS_PATH,lang);

            String prop=new String (commonFunctions.readProperties(nameFile).getProperty("enterButton"));

            prop=new String (prop.getBytes("ISO-8859-1"), "UTF-8");
            String locator=new String(String.format(locatorProperties.getProperty(enterButtonLocatorKey),prop));

            buttonEnter = new Button(baseElement.findElement(locator), driver);
            buttonEnter.click();


        } catch (OutOfTimeException e) {

        } catch (ElementNotFoundException e) {

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

        return list.equals(new_requisites);


    }

    public void clickOnInstall() throws UnsupportedEncodingException {
        BaseElement baseElement = new BaseElement(driver);
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(installButtonLocatorKey));
        String str = new String(locatorProperties.getProperty(installButtonLocatorKey));
        buttonInstall = new Button(baseElement.findElement(str), driver);
        buttonInstall.click();
    }
}
