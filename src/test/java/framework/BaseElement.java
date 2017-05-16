package framework;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by v.demyanova on 5/15/17.
 */
public  class BaseElement implements WebElement {

    /*WebElement webElement;*/
    WebDriver driver;

    public BaseElement() {

    }

    /*public WebDriver getDriver() {
        return driver;
    }*/

    public BaseElement(WebDriver driver) {
this.driver=driver;
    }

   /* public BaseElement(WebElement webElement,WebDriver driver) {
        this.webElement = webElement;
        this.driver=driver;
    }*/

    @Override
    public List<WebElement> findElements(By by) {
        List<WebElement> list = (driver.findElements(by));
        return list;
}


    public List<WebElement> findElements(String by) {
        List<WebElement> list = (driver.findElements(By.xpath(by)));
        return list;
    }

    @Override
    public  void click(){

    };



    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return "hjhjhk";
    }




    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElement(String by) {
        return driver.findElement(By.xpath(by));
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }


}
