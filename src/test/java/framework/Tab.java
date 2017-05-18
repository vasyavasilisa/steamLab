package framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by v.demyanova on 5/15/17.
 */
public class Tab extends BaseElement {
    WebDriver driver;
    WebElement tab;



    public Tab(WebElement tab,WebDriver driver) {
        this.tab=tab;
        this.driver = driver;

    }


    @Override
    public void click() {

        tab.click();
    }
}
