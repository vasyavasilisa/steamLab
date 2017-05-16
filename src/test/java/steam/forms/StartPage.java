package steam.forms;

import framework.BaseElement;
import framework.Menu;
import framework.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class StartPage {
    WebDriver driver;
    Menu menu;
    Menu subMenu;
    WebElement languageSelect;
    WebElement concretelanguageSelect;
   /* By gamesMenuLocator = By.xpath("//div[@id='genre_tab']/span/a");
    By actionLocator = By.xpath("//a[text()='Экшен']");
    By languageLocator = By.xpath("//span[@id='language_pulldown']");
    By russionOptionLocator = By.xpath("//a[@href='?l=russian']");*/

    String gamesMenuLocator = "//div[@id='genre_tab']/span/a";
    String actionLocator = "//a[text()='Экшен']";
    String languageLocator = "//span[@id='language_pulldown']";
    String russionOptionLocator = "//a[@href='?l=russian']";


    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToMainPage(String mainPageUrl) {
        driver.manage().window().maximize();
        driver.navigate().to(mainPageUrl);
    }

    public void clickOnActions() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        menu = new Menu(baseElement.findElement(gamesMenuLocator),driver);
       // System.out.println(menu.getText());
       /* wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(gamesMenuLocator));*/
        menu.moveTo();
        ////////////////////////////////////////////////
     /*  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionLocator));*/
        //////////////////////////////////////////////////
        subMenu=new Menu(baseElement.findElement(actionLocator),driver);
        subMenu.click();

    }

    public void changeLanguage() {
        BaseElement baseElement = new BaseElement(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(languageLocator)));

        String lang = driver.findElement(By.xpath(languageLocator)).getText();
        System.out.println(lang);
        if (lang.equals("language")) {
            languageSelect = new Select(baseElement.findElement(languageLocator),driver);
            languageSelect.click();
           // BaseElement baseElement1 = new BaseElement(driver);
           /*  wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(russionOptionLocator));*/
            concretelanguageSelect =new Select(baseElement.findElement(russionOptionLocator),driver);
            System.out.println(baseElement.findElement(russionOptionLocator).getText());
            concretelanguageSelect.click();
        }
    }

    public void navigateToGamesMenu(String id){

        BaseElement baseElement = new BaseElement(driver);
        String locator="//a[text()='%s']";
       // String
        By by=By.xpath(String.format(locator,id));
        menu = new Menu(baseElement.findElement(actionLocator),driver);
        menu.moveTo();
    }
}

