package steam.tests;

import framework.BrowserFactory;
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
        CommonFunctions commonFunctions = new CommonFunctions();
        Properties properties = commonFunctions.readProperties();
        String br = properties.getProperty("brouser_type");
        WebDriver driver = BrowserFactory.getFactory(br).getDriver();
        String mainPage = properties.getProperty("main_page_url");

        StartPage startPage = new StartPage(driver);
        startPage.navigateToMainPage(mainPage);
        startPage.changeLanguage();
        startPage.clickOnActions();

        ActionPage actionPage = new ActionPage(driver);
        actionPage.clickOnSpecials();

        SpecialsPage specialsPage = new SpecialsPage(driver);
        List<String> list = specialsPage.getDiscount();

        DescriptionPage descriptionPage = new DescriptionPage(driver);
        descriptionPage.chooseAgeIfExist();
        Assert.assertTrue(descriptionPage.isSimilarPriceDiscount(list));
        descriptionPage.clickOnInstall();
        InstallPage installPage = new InstallPage(driver);
        installPage.clickOnSetUpFile();


    }
}
