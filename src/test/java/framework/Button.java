package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Button extends BaseElement {

    WebElement button;

    public Button() {

    }

    public Button(By by) {
        this.button = findElement(by);

    }

    public Button(WebElement button) {
        this.button = button;

    }

    @Override
    public void click() {
        button.click();
    }

    public String getAttribute(String name) {
        return button.getAttribute(name);
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void moveTo() {

    }
}
