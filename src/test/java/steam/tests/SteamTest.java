package steam.tests;

import framework.BrowserFactory;
import framework.Menu;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steam.forms.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;


public class SteamTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        BasePage basePage = new BasePage();
        Properties properties = basePage.initProperties();
        basePage.initLocatorProperties();
        String br = properties.getProperty("brouser_type");
        driver = BrowserFactory.getMyDriver(br);
        String mainPage = properties.getProperty("main_page_url");
        basePage.setDriver(driver);
        basePage.maximaseWindow();
        basePage.navigate(mainPage);
    }

    @Test
    public void shouldWork() throws UnsupportedEncodingException {


        StartPage startPage = new StartPage();
        startPage.changeLanguage();
        startPage.moveToGamesMenu();
        startPage.clickOnActionSubmenu(Menu.ACTION);

        ActionPage actionPage = new ActionPage();
        actionPage.clickOnSpecials();


        List<String> list =  actionPage.getDiscount();
        System.out.println(list.size());
        DescriptionPage descriptionPage = new DescriptionPage();
        descriptionPage.chooseAgeIfExist();
        Assert.assertTrue(descriptionPage.isSimilarPriceDiscount(list));
        descriptionPage.clickOnInstall();
        InstallPage installPage = new InstallPage();
        Assert.assertTrue(installPage.isFullDownload());


    }

    @AfterTest
    public void exit() {
        BasePage basePage = new BasePage(driver);
        basePage.exit();
    }
}
