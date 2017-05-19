package framework;

import org.openqa.selenium.*;


import java.util.List;


public abstract class BaseElement extends BaseEntity {


    WebDriver driver;

    public BaseElement() {

    }

    public abstract void click();

    public abstract String getText();

    public abstract String getAttribute(String str);

    public abstract void moveTo();

    public List<WebElement> findElements(String by) {
        return getDriver().findElements(By.xpath(by));

    }


    public WebElement findElement(By locator) {

        return getDriver().findElement(locator);
    }


}
