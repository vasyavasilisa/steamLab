package steam.forms;

import framework.BaseElement;
import framework.BrowserFactory;
import framework.Image;
import framework.Tab;
import framework.services.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ActionPage extends BasePage{
    WebDriver driver;
    Image imageWithMaxDiscount;
    String discountLocatorKey = "discountLocator";
    String imageLocatorKey = "imageLocator";
    String priceLabelLocatorKey = "priceLabelLocator";
    String specialsLocatorKey = "specialsLocator";
    Tab tab;

    public ActionPage() {
        this.driver = getDriver();
    }

    public void clickOnSpecials(){
        Properties locatorProperties=getLocatorProperties();
        BaseElement baseElement = new BaseElement(driver);
        BrowserFactory.waitElementExplicide(locatorProperties.getProperty(specialsLocatorKey));
        tab=new Tab(baseElement.findElement(locatorProperties.getProperty(specialsLocatorKey)),driver);
        tab.click();

    }

    public List getDiscount() {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitJavascript();

        BrowserFactory.waitJavascript();


        BaseElement baseElement = new BaseElement(driver);
        CommonFunctions commonFunctions = new CommonFunctions();
        List<WebElement> list = baseElement.findElements(locatorProperties.getProperty(discountLocatorKey));
        List<Integer> discounts = commonFunctions.getListOfDiscounts(list);
        System.out.println(list.size());


        int maxInd = commonFunctions.getIndMaxDiscount(discounts);

        System.out.println(maxInd);
        List<String> ldiscount_price = new ArrayList<>();

        ldiscount_price.add(baseElement.findElements(locatorProperties.getProperty(discountLocatorKey)).get(maxInd).getText());
        ldiscount_price.add(baseElement.findElements(locatorProperties.getProperty(priceLabelLocatorKey)).get(maxInd).getText());


        imageWithMaxDiscount = new Image(baseElement.findElements(locatorProperties.getProperty(imageLocatorKey)).get(maxInd), driver);

        imageWithMaxDiscount.click();
        return ldiscount_price;
    }
}
