package framework;

import org.openqa.selenium.*;



import java.util.List;

/**
 * Created by v.demyanova on 5/15/17.
 */
public  class BaseElement{


    WebDriver driver;

    public BaseElement() {

    }


    public BaseElement(WebDriver driver) {
this.driver=driver;
    }



    public List<WebElement> findElements(String by) {
        List<WebElement> list = (driver.findElements(By.xpath(by)));
        return list;
    }


    public  void click(){

    };

    public WebElement findElement(String by) {
        return driver.findElement(By.xpath(by));
    }



}
