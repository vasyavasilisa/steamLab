package steam.Menu;

import framework.BaseElement;
import framework.services.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class Menu {

    WebElement menu;



    private static final String TEXT_LOCATORS_PATH = "%s_text.properties";
    private static final String MAIN_PROPERTIES_PATH = "brouser.properties";

    public static String GAMES;
    public static String ACTION;



    public Menu() {
        initItems();
    }


    public void initItems() {
        CommonFunctions commonFunctions = new CommonFunctions();
        Properties mainProp = commonFunctions.readProperties(MAIN_PROPERTIES_PATH);
        String lang = mainProp.getProperty("language");
        Properties textLocatorProp = commonFunctions.readProperties(String.format(TEXT_LOCATORS_PATH, lang));
        try {
            ACTION = new String(textLocatorProp.getProperty("gamesAction").getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }






}
