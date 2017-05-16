package framework.services;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 10.05.2017.
 */
public class CommonFunctions {

    private static final String BROWSER_PROPERTIES_PATH="brouser.properties";


    public Properties readProperties(String path){
        File ff = new File(getClass().getClassLoader().getResource(path).getFile());
        FileInputStream fis= null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(ff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }

    public List<Integer> getListOfDiscounts(List<WebElement> list){
        List<Integer> discounts = new ArrayList<>();
        Pattern pat = Pattern.compile("[0-9]+");
        for (WebElement el : list) {
            Matcher matcher = pat.matcher(el.getText());
            while (matcher.find()) {
                discounts.add(new Integer(matcher.group()));
            }
        }

        return discounts;
    }

    public int getIndMaxDiscount(List<Integer> discounts){
        int max = discounts.get(0);
        int ind =0;
        int  maxInd=0;
        for (Integer discount : discounts) {
            if (discount > max) {
                max = discount;
                maxInd=ind;
            }
            ind ++;
        }

        return maxInd;
    }


}
