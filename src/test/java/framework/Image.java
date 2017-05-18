package framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by v.demyanova on 5/15/17.
 */
public class Image extends BaseElement {


    WebDriver driver;
    WebElement image;




    public Image(WebElement image,WebDriver driver){
        this.image=image;
        this.driver=driver;
    }



    @Override
    public void click() {

        image.click();


    }


}
