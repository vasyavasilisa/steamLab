package steam.forms;

import framework.*;
import framework.services.CommonFunctions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ActionPage extends BasePage {
    Image imgWithMaxDiscount;
    Button btnSpecialsTab;
    String discountLocatorKey = "discountLocator";
    String imageLocatorKey = "imageLocator";
    String priceLabelLocatorKey = "priceLabelLocator";
    String specialsLocatorKey = "specialsLocator";


    public ActionPage() {
    }

    public void clickOnSpecials() {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitElementExplicide(locatorProperties.getProperty(specialsLocatorKey));
        btnSpecialsTab = new Button(By.xpath(locatorProperties.getProperty(specialsLocatorKey)));
        btnSpecialsTab.click();

    }

    public List getDiscount() {
        Properties locatorProperties = getLocatorProperties();
        BrowserFactory.waitPageToLoad();
        BrowserFactory.waitJavascript();
        BrowserFactory.waitJavascript();


        CommonFunctions commonFunctions = new CommonFunctions();
        Label label1 = new Label();
        List<Label> list = label1.getConvertedElements(locatorProperties.getProperty(discountLocatorKey));
        List<Integer> discounts = commonFunctions.getListOfDiscounts(list);
        int maxInd = commonFunctions.getIndMaxDiscount(discounts);

        List<String> ldiscount_price = new ArrayList<>();

        List<Label> l = label1.getConvertedElements(locatorProperties.getProperty(discountLocatorKey));
        List<Label> l2 = label1.getConvertedElements(locatorProperties.getProperty(priceLabelLocatorKey));
        Label labelDiscount = label1.findElementByInd(l, maxInd);
        Label labelPrice = label1.findElementByInd(l2, maxInd);
        ldiscount_price.add(labelDiscount.getText());
        ldiscount_price.add(labelPrice.getText());
        Image image = new Image();
        List<Image> gameImages = image.getConvertedElements(locatorProperties.getProperty(imageLocatorKey));
        imgWithMaxDiscount = image.findElementByInd(gameImages, maxInd);
        imgWithMaxDiscount.click();
        return ldiscount_price;

    }
}
