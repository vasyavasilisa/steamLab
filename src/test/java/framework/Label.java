package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 19.05.2017.
 */
public class Label extends BaseElement {


    WebElement label;

    public Label() {

    }

    public Label(By by) {
        this.label = findElement(by);
    }

    public Label(WebElement label) {
        this.label = label;
    }


    @Override
    public void click() {
        label.click();
    }

    @Override
    public void moveTo() {
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    public Label findElementByInd(List<Label> elements, int ind) {
        return elements.get(ind);

    }

    public String getText() {
        return label.getText();
    }


    public List<Label> getConvertedElements(String by) {
        List<WebElement> webElementList = super.findElements(by);
        List<Label> labelList = new ArrayList<>();
        for (WebElement webel : webElementList) {
            labelList.add(new Label(webel));
        }
        return labelList;
    }
}
