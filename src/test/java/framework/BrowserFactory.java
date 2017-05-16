package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by USER on 09.05.2017.
 */
public abstract class BrowserFactory {

    public abstract WebDriver getDriver();
    public static WebDriver driver;
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

}
