package steam.forms;

import framework.BaseElement;

import framework.services.CommonFunctions;
import framework.services.HttpUtils;


import org.openqa.selenium.WebDriver;




import java.util.Properties;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class InstallPage extends BasePage{
    WebDriver driver;
    String locator ="//div[@id='about_greeting_ctn']//*//a[@id='about_install_steam_link']";


    public InstallPage() {
        this.driver = getDriver();
    }

    public boolean isFullDownload() {

        BaseElement baseElement = new BaseElement(driver);
        String href =baseElement.findElement(locator).getAttribute("href");
        Properties properties = getProperties();
        String filePath = properties.getProperty("downloadFilePath");
        CommonFunctions commonFunctions = new CommonFunctions();
        HttpUtils utils = new HttpUtils();
        long size=utils.getSizeOfContent(href, filePath);
        return commonFunctions.isFullDownLoad(filePath,size);



    }
}
