package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
    WebElement image;
    By discountLocator;
    By imageLocator;
    By priceLabelLocator;



    public Image(WebElement image,WebDriver driver){
        this.image=image;
        this.driver=driver;
    }

    public Image(WebDriver driver, By discountLocator, By imageLocator, By priceLabelLocator) {
        this.driver = driver;
        this.discountLocator = discountLocator;
        this.imageLocator = imageLocator;
        this.priceLabelLocator = priceLabelLocator;
        
    }

    @Override
    public void click() {

        image.click();


    }


}
