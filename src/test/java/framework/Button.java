package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by v.demyanova on 5/16/17.
 */
public class Button extends BaseElement {

    WebElement button;
    WebDriver driver;

    public Button(){

    }

    public Button(WebElement button,WebDriver driver){
        this.button=button;
        this.driver=driver;

    }

    @Override
    public void click() {
        button.click();
    }
}
