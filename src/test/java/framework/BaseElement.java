package framework;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by v.demyanova on 5/15/17.
 */
public  class BaseElement implements WebElement{


    @Override
    public List<WebElement> findElements(By by) {
        return null;
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
        return null;
    }


    public List<WebElement> findElements(WebDriver driver,By discountLocator) {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<WebElement> list = (driver.findElements(discountLocator));
        return list;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
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
