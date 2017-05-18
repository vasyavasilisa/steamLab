package framework.services;

import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonFunctions {



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

    public boolean isFullDownLoad(String filePath,long size){
        File f = new File(filePath);
        if (f.exists()) {
            return f.length()==size;
        } else {
            return false;
        }

    }




}
