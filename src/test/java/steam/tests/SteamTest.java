package steam.tests;

import framework.BrowserFactory;
import framework.Menu;
import framework.services.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steam.forms.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

/**
 * Created by USER on 14.05.2017.
 */
public class SteamTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // CommonFunctions commonFunctions = new CommonFunctions();
        BasePage basePage = new BasePage();
        Properties properties = basePage.initProperties();

        String br = properties.getProperty("brouser_type");
        //BrowserFactory fact=BrowserFactory.getFactory(br);
        driver = BrowserFactory.getMyDriver(br);
        String mainPage = properties.getProperty("main_page_url");
        basePage.setDriver(driver);
        basePage.maximaseWindow();
        basePage.navigate(mainPage);
    }

    @Test
    public void shouldWork() throws UnsupportedEncodingException {
        CommonFunctions c = new CommonFunctions();
        String str1 = c.readProperties("templates.properties").getProperty("actionLocator");
        System.out.println(new String(str1.getBytes("ISO-8859-1"), "UTF-8"));

        StartPage startPage = new StartPage();
        startPage.changeLanguage();
        startPage.moveToGamesMenu();
        startPage.clickOnActionSubmenu(Menu.ACTION);

        ActionPage actionPage = new ActionPage();
        actionPage.clickOnSpecials();

        SpecialsPage specialsPage = new SpecialsPage();
        List<String> list = specialsPage.getDiscount();
        System.out.println(list.size());
        DescriptionPage descriptionPage = new DescriptionPage();
        descriptionPage.chooseAgeIfExist();
        Assert.assertTrue(descriptionPage.isSimilarPriceDiscount(list));
        descriptionPage.clickOnInstall();
        InstallPage installPage = new InstallPage();
        installPage.clickOnSetUpFile();

    }

    @AfterTest
    public void exit() {
        BasePage basePage = new BasePage(driver);
        basePage.exit();
    }
}
