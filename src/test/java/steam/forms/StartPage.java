package steam.forms;

import framework.BrowserFactory;
import steam.Menu.Menu;
import framework.Select;
import framework.services.CommonFunctions;
import org.openqa.selenium.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class StartPage extends BasePage {

    Menu menu;
    Select selGamesmenu;
    Select selAction;
    Select languageSelect;
    Select concretelanguageSelect;
    Properties locatorProperties;

    private static final String TEXT_LOCATORS_PROPERTIES = "%s_text.properties";
    String gamesMenuLocatorKey = "gamesMenuLocator";
    String actionLocatorKey = "actionLocator";
    String languageLocatorKey = "languageLocator";
    String russionOptionLocatorKey = "russionOptionLocator";


    public StartPage() {
        menu = new Menu();

    }


    public void moveToGamesMenu() throws UnsupportedEncodingException {

        BrowserFactory.waitImplicitly();
        BrowserFactory.waitPageToLoad();
        selGamesmenu = new Select(By.xpath(locatorProperties.getProperty(gamesMenuLocatorKey)));
        selGamesmenu.moveTo();


    }

    public void changeLanguage() throws UnsupportedEncodingException {

        CommonFunctions commonFunctions = new CommonFunctions();
        String language = getProperties().getProperty("language");
        locatorProperties = getLocatorProperties();
        String locat = locatorProperties.getProperty(languageLocatorKey);
        languageSelect = new Select(By.xpath(locat));
        String lang = languageSelect.getText();

        if ((language.equals("ru") && !lang.equals("язык")) || (language.equals("en") && !lang.equals("language"))) {
            String filename = String.format(TEXT_LOCATORS_PROPERTIES, language);
            Properties textLocatorsProp = commonFunctions.readProperties(filename);
            String locator = new String(textLocatorsProp.getProperty("language").getBytes("ISO-8859-1"), "UTF-8");
            locator = String.format(locatorProperties.getProperty(russionOptionLocatorKey), locator);
            languageSelect.click();
            concretelanguageSelect = new Select(By.xpath(locator));
            concretelanguageSelect.click();

        }


    }

    public void clickOnActionSubmenu(String id) throws UnsupportedEncodingException {
        String locator = new String(locatorProperties.getProperty(actionLocatorKey).getBytes("ISO-8859-1"), "UTF-8");
        selAction = new Select(By.xpath(String.format(locator, id)));
        selAction.click();
    }


}

