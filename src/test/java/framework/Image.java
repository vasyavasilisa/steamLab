package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by v.demyanova on 5/15/17.
 */
public class Image extends BaseElement {


    WebElement image;


    public Image(){


    }

    public Image(By by){

        this.image=findElement(by);
    }

    public Image(WebElement image){
        this.image=image;
    }



    @Override
    public void click() {

        image.click();


    }

    public Image findElementByInd(List<Image> elements, int ind) {
        return  elements.get(ind);

    }

    public List<Image> getConvertedElements(String by) {
        List<WebElement> webElementList = super.findElements(by);
        List<Image> imageList= new ArrayList<>();
        for(WebElement webel: webElementList){
            imageList.add(new Image(webel));
        }
        return imageList;
    }


    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    @Override
    public void moveTo() {

    }
}
