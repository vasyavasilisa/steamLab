package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class Image extends BaseElement {


    WebDriver driver;
    By discountLocator;
    By imageLocator;
    By priceLabelLocator;


    public Image(WebDriver driver, By discountLocator, By imageLocator, By priceLabelLocator) {
        this.driver = driver;
        this.discountLocator = discountLocator;
        this.imageLocator = imageLocator;
        this.priceLabelLocator = priceLabelLocator;
    }

    @Override
    public void click() {



       /* Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(StaleElementReferenceException.class);

        WebElement foo =(WebElement) wait.until(new Function<WebDriver,WebElement>() {

            public WebElement apply(WebDriver driver) {

                return driver.findElement(discountLocator);

            }

        });*/
       /* WebDriverWait wdWait = new WebDriverWait(driver, 10);
        wdWait.ignoring(InvalidSelectorException.class, StaleElementReferenceException.class);
        wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(discountLocator)));*/

        List<WebElement> list = (driver.findElements( discountLocator));
        System.out.println(list.size());
        List<Integer> discounts = new ArrayList<>();
        Pattern pat = Pattern.compile("[0-9]+");
        for (WebElement el : list) {
            Matcher matcher = pat.matcher(el.getText());
            while (matcher.find()) {
                discounts.add(new Integer(matcher.group()));
            }
        }
        int max = discounts.get(0);
        int ind =0;
        int  maxInd=0;
        for (Integer discount : discounts) {
            if (discount > max) {
                max = discount;
                maxInd=ind;
            }
            ind ++;
        }
        List<String> ldiscount_price= new ArrayList<>();
        ldiscount_price.add(driver.findElements( discountLocator).get(maxInd).getText());
        ldiscount_price.add(driver.findElements(priceLabelLocator).get(maxInd).getText());

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(imageLocator));
        List<WebElement> imageList = driver.findElements(imageLocator);
        imageList.get(maxInd).click();

    }


}
