package steam.forms;

import framework.Menu;
import framework.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StartPage {
    WebDriver driver;
    WebElement menu;
    WebElement languageSelect;
    By gamesMenuLocator= By.xpath("//div[@id='genre_tab']/span/a");
    By actionLocator= By.xpath("//a[text()='Экшен']");
    By languageLocator = By.xpath("//span[@id='language_pulldown']");
    By russionOptionLocator = By.xpath("//a[@href='?l=russian']");


    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToMainPage(String mainPageUrl) {
        driver.manage().window().maximize();
        driver.navigate().to(mainPageUrl);
    }

    public void clickOnActions(){

       menu= new Menu(driver,gamesMenuLocator,actionLocator);
       menu.click();

    }

    public void changeLanguage(){
        languageSelect= new Select(driver,languageLocator,russionOptionLocator);
        languageSelect.click();

        }

    }

