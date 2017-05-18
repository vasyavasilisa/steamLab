package steam.forms;

import framework.BaseElement;
import framework.BrowserFactory;
import framework.Menu;
import framework.Select;
import framework.services.CommonFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class StartPage extends BasePage {
    WebDriver driver;
    Menu menu;
    Menu subMenu;
    Select languageSelect;
    Select concretelanguageSelect;
    Properties locatorProperties;

    private static final String TEXT_LOCATORS_PROPERTIES = "%s_text.properties";
    String gamesMenuLocatorKey = "gamesMenuLocator";
    String actionLocatorKey = "actionLocator";
    String languageLocatorKey = "languageLocator";
    String russionOptionLocatorKey = "russionOptionLocator";


    public StartPage() {
        this.driver = getDriver();
        menu = new Menu();

    }



    public void moveToGamesMenu() throws UnsupportedEncodingException {

        BrowserFactory.waitImplicitly();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseElement baseElement = new BaseElement(driver);
        menu = new Menu(baseElement.findElement(locatorProperties.getProperty(gamesMenuLocatorKey)), driver);
        menu.moveTo();


    }

    public void changeLanguage() throws UnsupportedEncodingException {
        BaseElement baseElement = new BaseElement(driver);
        CommonFunctions commonFunctions= new CommonFunctions();
        String lang = driver.findElement(By.xpath(getProperties().getProperty(languageLocatorKey))).getText();
        String language = getProperties().getProperty("language");
        locatorProperties = getLocatorProperties();

        if ((language.equals("ru") && !lang.equals("язык")) ||  (language.equals("en") && !lang.equals("language"))) {
            String filename=String.format(TEXT_LOCATORS_PROPERTIES,language);
            Properties textLocatorsProp= commonFunctions.readProperties(filename);
            String locator=new String(textLocatorsProp.getProperty("language").getBytes("ISO-8859-1"), "UTF-8");
            locator=String.format(locatorProperties.getProperty(russionOptionLocatorKey),locator);
            languageSelect = new Select(baseElement.findElement(locatorProperties.getProperty(languageLocatorKey)), driver);
            languageSelect.click();
            concretelanguageSelect = new Select(baseElement.findElement(locator), driver);
            concretelanguageSelect.click();
        }


    }

    public void clickOnActionSubmenu(String id) throws UnsupportedEncodingException {

        BaseElement baseElement = new BaseElement(driver);
        String locator = new String(locatorProperties.getProperty(actionLocatorKey).getBytes("ISO-8859-1"), "UTF-8");
        subMenu = new Menu(baseElement.findElement(String.format(locator,id)), driver);
        subMenu.click();
    }



}

