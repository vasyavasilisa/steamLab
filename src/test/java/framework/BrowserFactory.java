package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static java.time.zone.ZoneRulesProvider.refresh;


public abstract class BrowserFactory {

    public abstract WebDriver getDriver();
    public static WebDriver driver;
    static  Long started;

public static WebDriver getMyDriver(String type){
    switch (type) {
        case "chrome": {

            driver=ChromeFactory.getInstance();
            return driver;

        }
        case "firefox": {

            driver=FirefoxFactory.getInstance();
            return driver;
        }
    }
    throw new RuntimeException();
}


    public static BrowserFactory getFactory(String type) {
        switch (type) {
           /* case "chrome": {
                return ChromeFactory.getInstance();
            }*/
          /*  case "firefox": {
                return FirefoxFactory.getInstance();
            }*/
        }
        throw new RuntimeException();
    }

    public static void waitJavascript(){
        WebDriverWait wait1 = new WebDriverWait(driver, Long.parseLong("1000"));
        try {
            wait1.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d).executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    if (result != null && result instanceof Boolean && (Boolean) result) {
                        long now = System.currentTimeMillis();
                        if (now - started > Long.parseLong("1000")) {
                            return true;
                        }else {
                            started = System.currentTimeMillis();
                        }
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            refresh();

        }

    }

    public static void waitImplicitly(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void waitElementExplicide(String locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static void waitElementsExplicide(String locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }


    public static void maximaseWindow(){
        driver.manage().window().maximize();

    }

    public static void navigateUrl(String url){
        driver.navigate().to(url);

    }

    public static void exit(){
        driver.close();
    }

}
