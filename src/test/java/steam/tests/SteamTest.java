package steam.tests;

import framework.BrowserFactory;
import framework.Menu;
import framework.services.CommonFunctions;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steam.forms.*;

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
    public void shouldWork() {


        StartPage startPage = new StartPage();
        startPage.changeLanguage();
        startPage.clickOnActions();

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

       /* WebDriver driver1 = BrowserFactory.getMyDriver(br);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.onliner.by/");*/

    }

    @AfterTest
    public void exit(){
        BasePage basePage = new BasePage(driver);
        basePage.exit();
    }
}
