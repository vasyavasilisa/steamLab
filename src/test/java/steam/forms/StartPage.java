package steam.forms;

import framework.BaseElement;
import framework.BrowserFactory;
import framework.Menu;
import framework.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class StartPage extends BasePage{
    WebDriver driver;
    Menu menu;
    Menu subMenu;
    WebElement languageSelect;
    WebElement concretelanguageSelect;
    Properties locatorProperties;

private static final String LOCATORS_PROPERTIES="%s_locators.properties";
    String gamesMenuLocatorKey = "gamesMenuLocator";
    String actionLocatorKey = "actionLocator";
    String languageLocatorKey = "languageLocator";
    String russionOptionLocatorKey = "russionOptionLocator";


    public StartPage() {
        this.driver = getDriver();

    }


    public Properties getLocatorProperties(String path){
        locatorProperties=initLocatorProperties(path);
        return locatorProperties;
    }


    public void clickOnActions() {

        BrowserFactory.waitImplicitly();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ////////////////////////////////////////////////
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(gamesMenuLocator));*/
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(gamesMenuLocator));
        WebElement webElement = driver.findElement(gamesMenuLocator);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionLocator));
        driver.findElement(actionLocator).click();*/

        BaseElement baseElement = new BaseElement(driver);
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(gamesMenuLocator)));*/
        menu = new Menu(baseElement.findElement(locatorProperties.getProperty(gamesMenuLocatorKey)),driver);
       // System.out.println(menu.getText());
       /* wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(gamesMenuLocator));*/
        menu.moveTo();
        ////////////////////////////////////////////////
     /*  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionLocator));*/
        //////////////////////////////////////////////////
        subMenu=new Menu(baseElement.findElement(String.format(locatorProperties.getProperty(actionLocatorKey),"Экшен")),driver);
        subMenu.click();

    }

    public void changeLanguage() {
        BaseElement baseElement = new BaseElement(driver);

        BrowserFactory.waitElementExplicide(getProperties().getProperty(languageLocatorKey));

        String lang = driver.findElement(By.xpath(getProperties().getProperty(languageLocatorKey))).getText();
        String language=getProperties().getProperty("language");
        locatorProperties=getLocatorProperties(String.format(LOCATORS_PROPERTIES,language));
        System.out.println(lang);
        if (language.equals("ru")&&!lang.equals("язык")){
        //if (lang.equals("language")) {
            languageSelect = new Select(baseElement.findElement(locatorProperties.getProperty(languageLocatorKey)),driver);
            languageSelect.click();
           // BaseElement baseElement1 = new BaseElement(driver);
           /*  wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(russionOptionLocator));*/
            concretelanguageSelect =new Select(baseElement.findElement(locatorProperties.getProperty(russionOptionLocatorKey)),driver);
           // System.out.println(baseElement.findElement(russionOptionLocator).getText());
            concretelanguageSelect.click();
        }

        if (language.equals("en")&&!lang.equals("language")){
            languageSelect = new Select(baseElement.findElement(locatorProperties.getProperty(languageLocatorKey)),driver);
            languageSelect.click();
            concretelanguageSelect =new Select(baseElement.findElement(locatorProperties.getProperty(russionOptionLocatorKey)),driver);
            concretelanguageSelect.click();
        }
    }

    public void navigateToGamesMenu(String id){

        BaseElement baseElement = new BaseElement(driver);
        String locator="//a[text()='%s']";
       // String
        By by=By.xpath(String.format(locator,id));
        menu = new Menu(baseElement.findElement(locatorProperties.getProperty(actionLocatorKey)),driver);
        menu.moveTo();
    }
}

