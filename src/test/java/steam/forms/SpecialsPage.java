package steam.forms;

import com.google.common.base.Function;
import framework.BaseElement;
import framework.BrowserFactory;
import framework.Image;
import framework.services.CommonFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.zone.ZoneRulesProvider.refresh;
import static java.util.concurrent.TimeUnit.SECONDS;


public class SpecialsPage extends BasePage {
    WebDriver driver;
    WebElement imageWithMaxDiscount;

    String discountLocatorKey = "discountLocator";
    String imageLocatorKey = "imageLocator";

    String priceLabelLocatorKey = "priceLabelLocator";

    Long started;

    public SpecialsPage() {
        this.driver = getDriver();
    }

    public List getDiscount() {
        Properties locatorProperties = getLocatorProperties();
       // BrowserFactory.waitElementsExplicide(locatorProperties.getProperty(discountLocatorKey));
        BrowserFactory.waitJavascript();
       /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(discountLocator)));
        WebDriverWait w3 = new WebDriverWait(driver, Long.parseLong("1000"));

        try {
            w3.until(d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                if (result != null && result instanceof Boolean && (Boolean) result) {
                    return true;
                }
                return false;
            });
        } catch (Exception e) {
            // Logger.getInstance().warn(getLoc("loc.browser.page.timeout"));
        }
        */

        //= System.currentTimeMillis();
        /*WebDriverWait wait1 = new WebDriverWait(driver, Long.parseLong("1000"));
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
           // waitForPageToLoad();
        }*/
        BrowserFactory.waitJavascript();
       /*WebDriverWait w2 = new WebDriverWait(driver, Long.parseLong("1000"));

        try {
            w2.until(d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                if (result != null && result instanceof Boolean && (Boolean) result) {
                    return true;
                }
                return false;
            });
        } catch (Exception e) {
           // Logger.getInstance().warn(getLoc("loc.browser.page.timeout"));
        }*/
// Logger.getInstance().info("waitForPageToLoad ended");

       /* try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       /* WebDriverWait wdWait = new WebDriverWait(driver, 10);
        wdWait.ignoring(InvalidSelectorException.class, StaleElementReferenceException.class);
        wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(discountLocator)));*/

        BaseElement baseElement = new BaseElement(driver);
        CommonFunctions commonFunctions = new CommonFunctions();
        List<WebElement> list = baseElement.findElements(locatorProperties.getProperty(discountLocatorKey));
        List<Integer> discounts = commonFunctions.getListOfDiscounts(list);
        System.out.println(list.size());

        System.out.println("ioioipoipoipoipo");
        BrowserFactory.waitJavascript();
     /*   WebDriverWait w = new WebDriverWait(driver, Long.parseLong("1000"));

        try {
            w.until(d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                if (result != null && result instanceof Boolean && (Boolean) result) {
                    return true;
                }
                return false;
            });
        } catch (Exception e) {
            // Logger.getInstance().warn(getLoc("loc.browser.page.timeout"));
        }*/
        //System.out.println("ioioipoipoipoipo32312");
        int maxInd = commonFunctions.getIndMaxDiscount(discounts);
        // System.out.println("ioioipoipoipoipo");
        System.out.println(maxInd);
        List<String> ldiscount_price = new ArrayList<>();

        ldiscount_price.add(baseElement.findElements(locatorProperties.getProperty(discountLocatorKey)).get(0).getText());
        ldiscount_price.add(baseElement.findElements(locatorProperties.getProperty(priceLabelLocatorKey)).get(0).getText());

        //System.out.println(driver.findElement(priceLabelLocator).getText());
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       /* w1 = new WebDriverWait(driver, Long.parseLong("1000"));

        try {
            w1.until(d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                if (result != null && result instanceof Boolean && (Boolean) result) {
                    return true;
                }
                return false;
            });
        } catch (Exception e) {
            // Logger.getInstance().warn(getLoc("loc.browser.page.timeout"));
        }*/
        imageWithMaxDiscount = new Image(baseElement.findElements(locatorProperties.getProperty(imageLocatorKey)).get(0), driver);
       /*wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(discountLocator));*/
        imageWithMaxDiscount.click();
        return ldiscount_price;
    }


}
