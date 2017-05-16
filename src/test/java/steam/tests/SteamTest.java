package steam.tests;

import framework.BrowserFactory;
import framework.Menu;
import framework.services.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steam.forms.*;

import java.util.List;
import java.util.Properties;

/**
 * Created by USER on 14.05.2017.
 */
public class SteamTest {


    @BeforeTest
    public void setUp() {

    }

    @Test
    public void shouldWork() {
      // System.out.println(String.format("//a[text()='%s']","Экшен"));
        CommonFunctions commonFunctions = new CommonFunctions();
        Properties properties = commonFunctions.readProperties("brouser.properties");
        String br = properties.getProperty("brouser_type");
        //BrowserFactory fact=BrowserFactory.getFactory(br);
        WebDriver driver = BrowserFactory.getMyDriver(br);
        String mainPage = properties.getProperty("main_page_url");

        StartPage startPage = new StartPage(driver);
        startPage.navigateToMainPage(mainPage);
        startPage.changeLanguage();
       // startPage.navigateToGamesMenu("Экшен");
        startPage.clickOnActions();

      ActionPage actionPage = new ActionPage(driver);
        actionPage.clickOnSpecials();

        SpecialsPage specialsPage = new SpecialsPage(driver);
        List<String> list = specialsPage.getDiscount();
System.out.println(list.size());
        DescriptionPage descriptionPage = new DescriptionPage(driver);
        descriptionPage.chooseAgeIfExist();
        Assert.assertTrue(descriptionPage.isSimilarPriceDiscount(list));
        descriptionPage.clickOnInstall();
        InstallPage installPage = new InstallPage(driver);
        installPage.clickOnSetUpFile();

       /* WebDriver driver1 = BrowserFactory.getMyDriver(br);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.onliner.by/");*/

    }
}
