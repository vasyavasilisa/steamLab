package steam.forms;

import com.google.common.base.Function;
import framework.BaseElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;


public class SpecialsPage {
    WebDriver driver;
    By discountLocator = By.xpath("//div[@class = 'tab_content_ctn large']/div[@id = 'tab_Discounts_content']//a");
    By aaa = By.xpath("//div[@class = 'tab_content_ctn large']/div[@id = 'tab_Discounts_content']//a//div[@class='discount_pct']");
    By imageLocator = By.xpath("//div[@class = 'tab_content_ctn large']/div[@id = 'tab_Discounts_content']" +
            "//a//img");

    By priceLabelLocator = By.xpath("//div[@class = 'tab_content_ctn large']/div[@id = 'tab_Discounts_content']//a//" +
            "div[@class='discount_final_price']");

    public SpecialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List getDiscount() {
      /* WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(discountLocator));*/

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

        BaseElement baseElement=new BaseElement();

        List<WebElement> list = baseElement.findElements(driver,aaa);
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
        ldiscount_price.add(driver.findElements(aaa).get(maxInd).getText());
        ldiscount_price.add(driver.findElements(priceLabelLocator).get(maxInd).getText());

       //System.out.println(driver.findElement(priceLabelLocator).getText());
      WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(imageLocator));
        List<WebElement> imageList = driver.findElements(imageLocator);
        imageList.get(maxInd).click();
        return ldiscount_price;
    }


}
